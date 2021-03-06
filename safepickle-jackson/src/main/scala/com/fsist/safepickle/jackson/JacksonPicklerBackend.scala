package com.fsist.safepickle.jackson

import java.io.{StringWriter, ByteArrayOutputStream, IOException}

import com.fasterxml.jackson.core.JsonParser.NumberType
import com.fsist.safepickle._

import com.fasterxml.jackson.core._

object JacksonPicklerBackend {
  private lazy val factory = (new JsonFactory)
    .configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false)
    .configure(JsonParser.Feature.ALLOW_COMMENTS, true)
    .configure(JsonParser.Feature.ALLOW_YAML_COMMENTS, true)
    .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
    .configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true)
    .configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false)
    .configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT, false)
    .configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true)

  object Array extends PicklerBackend {
    type Repr = Array[Byte]

    override def reader(repr: Array[Byte]): PickleReader = {
      val parser = factory.createParser(repr)
      parser.nextToken() // Advance to first token
      new JacksonPickleReader(parser)
    }

    override def writer(): PickleWriter[Repr] = {
      val bos = new ByteArrayOutputStream()
      val gen = factory.createGenerator(bos).useDefaultPrettyPrinter()
      new JacksonPickleWriter(gen, {
        gen.flush()
        bos.toByteArray
      })
    }
  }

  object String extends PicklerBackend {
    type Repr = String

    override def reader(repr: String): PickleReader = {
      val parser = factory.createParser(repr)
      parser.nextToken() // Advance to first token
      new JacksonPickleReader(parser)
    }

    override def writer(): PickleWriter[Repr] = {
      val buf = new StringWriter()
      val gen = factory.createGenerator(buf).useDefaultPrettyPrinter()

      new JacksonPickleWriter(gen, {
        gen.flush()
        buf.toString
      })
    }
  }

}

class JacksonPickleReader(parser: JsonParser) extends PickleReader {

  import com.fasterxml.jackson.core.JsonTokenId._

  override def next(): Boolean = try {
    parser.nextToken() != null
  }
  catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def atEof(): Boolean = {
    val id = parser.getCurrentTokenId
    id == ID_NO_TOKEN || id == ID_NOT_AVAILABLE
  }

  override def tokenType: TokenType = parser.getCurrentTokenId match {
    case ID_NUMBER_INT => parser.getNumberType match {
      case NumberType.INT => TokenType.Int
      case NumberType.LONG => TokenType.Long
      case other => TokenType.String
    }
    case ID_NUMBER_FLOAT => parser.getNumberType match {
      case NumberType.FLOAT => TokenType.Float
      case NumberType.DOUBLE => TokenType.Double
      case other => TokenType.String
    }
    case ID_STRING => TokenType.String
    case ID_TRUE | ID_FALSE => TokenType.Boolean
    case ID_NULL => TokenType.Null
    case ID_START_ARRAY => TokenType.ArrayStart
    case ID_END_ARRAY => TokenType.ArrayEnd
    case ID_START_OBJECT => TokenType.ObjectStart
    case ID_END_OBJECT => TokenType.ObjectEnd
    case ID_FIELD_NAME => TokenType.AttributeName
    case other => TokenType.String // Everything else will be rendered as a string, which may not be parsed but is at least supported
  }

  override def boolean: Boolean = try {
    parser.getBooleanValue
  }
  catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def int: Int = try {
    parser.getIntValue
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def long: Long = try {
    parser.getLongValue
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def float: Float = try {
    parser.getFloatValue
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }
  
  override def double: Double = try {
    parser.getDoubleValue
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def string: String = try {
    parser.getText
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def attributeName: String = try {
    parser.getText
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }
}

class JacksonPickleWriter[Repr](generator: JsonGenerator, makeResult: => Repr) extends PickleWriter[Repr] {
  override def result(): Repr = makeResult

  override def writeString(string: String): this.type = try {
    generator.writeString(string)
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def writeInt(int: Int): this.type = try {
    generator.writeNumber(int)
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def writeLong(long: Long): this.type = try {
    generator.writeNumber(long)
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def writeFloat(float: Float): this.type = try {
    generator.writeNumber(float)
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }
  
  override def writeDouble(double: Double): this.type = try {
    generator.writeNumber(double)
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def writeBoolean(boolean: Boolean): this.type = try {
    generator.writeBoolean(boolean)
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def writeNull(): this.type = try {
    generator.writeNull()
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def writeArrayStart(): this.type = try {
    generator.writeStartArray()
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def writeObjectStart(): this.type = try {
    generator.writeStartObject()
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def writeArrayEnd(): this.type = try {
    generator.writeEndArray()
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def writeObjectEnd(): this.type = try {
    generator.writeEndObject()
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }

  override def writeAttributeName(name: String): this.type = try {
    generator.writeFieldName(name)
    this
  } catch {
    case e: IOException => throw new UnpicklingException(e.toString, e)
  }
}
