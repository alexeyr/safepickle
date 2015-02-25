package com.fsist.safepickle

import scala.reflect.runtime.universe._

/** Implicit definitions of picklers for tuples of all sizes. */
trait TuplePicklers {
  import PrimitivePicklers._

  implicit def tuple1[T1](implicit tpickler1: Pickler[T1], tag1: TypeTag[T1]): Pickler[Tuple1[T1]] =
    new Pickler[Tuple1[T1]] {
      override def pickle(t: Tuple1[T1], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple1[T1] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple1(t1)
      }
    }


  implicit def tuple2[T1, T2](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tag1: TypeTag[T1], tag2: TypeTag[T2]): Pickler[Tuple2[T1, T2]] =
    new Pickler[Tuple2[T1, T2]] {
      override def pickle(t: Tuple2[T1, T2], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple2[T1, T2] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple2(t1, t2)
      }
    }


  implicit def tuple3[T1, T2, T3](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3]): Pickler[Tuple3[T1, T2, T3]] =
    new Pickler[Tuple3[T1, T2, T3]] {
      override def pickle(t: Tuple3[T1, T2, T3], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple3[T1, T2, T3] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple3(t1, t2, t3)
      }
    }


  implicit def tuple4[T1, T2, T3, T4](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4]): Pickler[Tuple4[T1, T2, T3, T4]] =
    new Pickler[Tuple4[T1, T2, T3, T4]] {
      override def pickle(t: Tuple4[T1, T2, T3, T4], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple4[T1, T2, T3, T4] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple4(t1, t2, t3, t4)
      }
    }


  implicit def tuple5[T1, T2, T3, T4, T5](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5]): Pickler[Tuple5[T1, T2, T3, T4, T5]] =
    new Pickler[Tuple5[T1, T2, T3, T4, T5]] {
      override def pickle(t: Tuple5[T1, T2, T3, T4, T5], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple5[T1, T2, T3, T4, T5] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple5(t1, t2, t3, t4, t5)
      }
    }


  implicit def tuple6[T1, T2, T3, T4, T5, T6](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6]): Pickler[Tuple6[T1, T2, T3, T4, T5, T6]] =
    new Pickler[Tuple6[T1, T2, T3, T4, T5, T6]] {
      override def pickle(t: Tuple6[T1, T2, T3, T4, T5, T6], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple6[T1, T2, T3, T4, T5, T6] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple6(t1, t2, t3, t4, t5, t6)
      }
    }


  implicit def tuple7[T1, T2, T3, T4, T5, T6, T7](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7]): Pickler[Tuple7[T1, T2, T3, T4, T5, T6, T7]] =
    new Pickler[Tuple7[T1, T2, T3, T4, T5, T6, T7]] {
      override def pickle(t: Tuple7[T1, T2, T3, T4, T5, T6, T7], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple7[T1, T2, T3, T4, T5, T6, T7] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple7(t1, t2, t3, t4, t5, t6, t7)
      }
    }


  implicit def tuple8[T1, T2, T3, T4, T5, T6, T7, T8](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8]): Pickler[Tuple8[T1, T2, T3, T4, T5, T6, T7, T8]] =
    new Pickler[Tuple8[T1, T2, T3, T4, T5, T6, T7, T8]] {
      override def pickle(t: Tuple8[T1, T2, T3, T4, T5, T6, T7, T8], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple8[T1, T2, T3, T4, T5, T6, T7, T8] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple8(t1, t2, t3, t4, t5, t6, t7, t8)
      }
    }


  implicit def tuple9[T1, T2, T3, T4, T5, T6, T7, T8, T9](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9]): Pickler[Tuple9[T1, T2, T3, T4, T5, T6, T7, T8, T9]] =
    new Pickler[Tuple9[T1, T2, T3, T4, T5, T6, T7, T8, T9]] {
      override def pickle(t: Tuple9[T1, T2, T3, T4, T5, T6, T7, T8, T9], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple9[T1, T2, T3, T4, T5, T6, T7, T8, T9] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple9(t1, t2, t3, t4, t5, t6, t7, t8, t9)
      }
    }


  implicit def tuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10]): Pickler[Tuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]] =
    new Pickler[Tuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]] {
      override def pickle(t: Tuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple10(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)
      }
    }


  implicit def tuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11]): Pickler[Tuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]] =
    new Pickler[Tuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]] {
      override def pickle(t: Tuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple11(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)
      }
    }


  implicit def tuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tpickler12: Pickler[T12], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11], tag12: TypeTag[T12]): Pickler[Tuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]] =
    new Pickler[Tuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]] {
      override def pickle(t: Tuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.write[T12](t._12)(tpickler12)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray
        val t12 = reader.readTagged[T12]()(tpickler12, tag12); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple12(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)
      }
    }


  implicit def tuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tpickler12: Pickler[T12], tpickler13: Pickler[T13], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11], tag12: TypeTag[T12], tag13: TypeTag[T13]): Pickler[Tuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]] =
    new Pickler[Tuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]] {
      override def pickle(t: Tuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.write[T12](t._12)(tpickler12)
        writer.write[T13](t._13)(tpickler13)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray
        val t12 = reader.readTagged[T12]()(tpickler12, tag12); reader.nextInArray
        val t13 = reader.readTagged[T13]()(tpickler13, tag13); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple13(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)
      }
    }


  implicit def tuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tpickler12: Pickler[T12], tpickler13: Pickler[T13], tpickler14: Pickler[T14], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11], tag12: TypeTag[T12], tag13: TypeTag[T13], tag14: TypeTag[T14]): Pickler[Tuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]] =
    new Pickler[Tuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]] {
      override def pickle(t: Tuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.write[T12](t._12)(tpickler12)
        writer.write[T13](t._13)(tpickler13)
        writer.write[T14](t._14)(tpickler14)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray
        val t12 = reader.readTagged[T12]()(tpickler12, tag12); reader.nextInArray
        val t13 = reader.readTagged[T13]()(tpickler13, tag13); reader.nextInArray
        val t14 = reader.readTagged[T14]()(tpickler14, tag14); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple14(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14)
      }
    }


  implicit def tuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tpickler12: Pickler[T12], tpickler13: Pickler[T13], tpickler14: Pickler[T14], tpickler15: Pickler[T15], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11], tag12: TypeTag[T12], tag13: TypeTag[T13], tag14: TypeTag[T14], tag15: TypeTag[T15]): Pickler[Tuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]] =
    new Pickler[Tuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]] {
      override def pickle(t: Tuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.write[T12](t._12)(tpickler12)
        writer.write[T13](t._13)(tpickler13)
        writer.write[T14](t._14)(tpickler14)
        writer.write[T15](t._15)(tpickler15)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray
        val t12 = reader.readTagged[T12]()(tpickler12, tag12); reader.nextInArray
        val t13 = reader.readTagged[T13]()(tpickler13, tag13); reader.nextInArray
        val t14 = reader.readTagged[T14]()(tpickler14, tag14); reader.nextInArray
        val t15 = reader.readTagged[T15]()(tpickler15, tag15); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple15(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15)
      }
    }


  implicit def tuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tpickler12: Pickler[T12], tpickler13: Pickler[T13], tpickler14: Pickler[T14], tpickler15: Pickler[T15], tpickler16: Pickler[T16], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11], tag12: TypeTag[T12], tag13: TypeTag[T13], tag14: TypeTag[T14], tag15: TypeTag[T15], tag16: TypeTag[T16]): Pickler[Tuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]] =
    new Pickler[Tuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]] {
      override def pickle(t: Tuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.write[T12](t._12)(tpickler12)
        writer.write[T13](t._13)(tpickler13)
        writer.write[T14](t._14)(tpickler14)
        writer.write[T15](t._15)(tpickler15)
        writer.write[T16](t._16)(tpickler16)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray
        val t12 = reader.readTagged[T12]()(tpickler12, tag12); reader.nextInArray
        val t13 = reader.readTagged[T13]()(tpickler13, tag13); reader.nextInArray
        val t14 = reader.readTagged[T14]()(tpickler14, tag14); reader.nextInArray
        val t15 = reader.readTagged[T15]()(tpickler15, tag15); reader.nextInArray
        val t16 = reader.readTagged[T16]()(tpickler16, tag16); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple16(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16)
      }
    }


  implicit def tuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tpickler12: Pickler[T12], tpickler13: Pickler[T13], tpickler14: Pickler[T14], tpickler15: Pickler[T15], tpickler16: Pickler[T16], tpickler17: Pickler[T17], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11], tag12: TypeTag[T12], tag13: TypeTag[T13], tag14: TypeTag[T14], tag15: TypeTag[T15], tag16: TypeTag[T16], tag17: TypeTag[T17]): Pickler[Tuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]] =
    new Pickler[Tuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]] {
      override def pickle(t: Tuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.write[T12](t._12)(tpickler12)
        writer.write[T13](t._13)(tpickler13)
        writer.write[T14](t._14)(tpickler14)
        writer.write[T15](t._15)(tpickler15)
        writer.write[T16](t._16)(tpickler16)
        writer.write[T17](t._17)(tpickler17)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray
        val t12 = reader.readTagged[T12]()(tpickler12, tag12); reader.nextInArray
        val t13 = reader.readTagged[T13]()(tpickler13, tag13); reader.nextInArray
        val t14 = reader.readTagged[T14]()(tpickler14, tag14); reader.nextInArray
        val t15 = reader.readTagged[T15]()(tpickler15, tag15); reader.nextInArray
        val t16 = reader.readTagged[T16]()(tpickler16, tag16); reader.nextInArray
        val t17 = reader.readTagged[T17]()(tpickler17, tag17); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple17(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17)
      }
    }


  implicit def tuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tpickler12: Pickler[T12], tpickler13: Pickler[T13], tpickler14: Pickler[T14], tpickler15: Pickler[T15], tpickler16: Pickler[T16], tpickler17: Pickler[T17], tpickler18: Pickler[T18], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11], tag12: TypeTag[T12], tag13: TypeTag[T13], tag14: TypeTag[T14], tag15: TypeTag[T15], tag16: TypeTag[T16], tag17: TypeTag[T17], tag18: TypeTag[T18]): Pickler[Tuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]] =
    new Pickler[Tuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]] {
      override def pickle(t: Tuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.write[T12](t._12)(tpickler12)
        writer.write[T13](t._13)(tpickler13)
        writer.write[T14](t._14)(tpickler14)
        writer.write[T15](t._15)(tpickler15)
        writer.write[T16](t._16)(tpickler16)
        writer.write[T17](t._17)(tpickler17)
        writer.write[T18](t._18)(tpickler18)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray
        val t12 = reader.readTagged[T12]()(tpickler12, tag12); reader.nextInArray
        val t13 = reader.readTagged[T13]()(tpickler13, tag13); reader.nextInArray
        val t14 = reader.readTagged[T14]()(tpickler14, tag14); reader.nextInArray
        val t15 = reader.readTagged[T15]()(tpickler15, tag15); reader.nextInArray
        val t16 = reader.readTagged[T16]()(tpickler16, tag16); reader.nextInArray
        val t17 = reader.readTagged[T17]()(tpickler17, tag17); reader.nextInArray
        val t18 = reader.readTagged[T18]()(tpickler18, tag18); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple18(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18)
      }
    }


  implicit def tuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tpickler12: Pickler[T12], tpickler13: Pickler[T13], tpickler14: Pickler[T14], tpickler15: Pickler[T15], tpickler16: Pickler[T16], tpickler17: Pickler[T17], tpickler18: Pickler[T18], tpickler19: Pickler[T19], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11], tag12: TypeTag[T12], tag13: TypeTag[T13], tag14: TypeTag[T14], tag15: TypeTag[T15], tag16: TypeTag[T16], tag17: TypeTag[T17], tag18: TypeTag[T18], tag19: TypeTag[T19]): Pickler[Tuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]] =
    new Pickler[Tuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]] {
      override def pickle(t: Tuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.write[T12](t._12)(tpickler12)
        writer.write[T13](t._13)(tpickler13)
        writer.write[T14](t._14)(tpickler14)
        writer.write[T15](t._15)(tpickler15)
        writer.write[T16](t._16)(tpickler16)
        writer.write[T17](t._17)(tpickler17)
        writer.write[T18](t._18)(tpickler18)
        writer.write[T19](t._19)(tpickler19)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray
        val t12 = reader.readTagged[T12]()(tpickler12, tag12); reader.nextInArray
        val t13 = reader.readTagged[T13]()(tpickler13, tag13); reader.nextInArray
        val t14 = reader.readTagged[T14]()(tpickler14, tag14); reader.nextInArray
        val t15 = reader.readTagged[T15]()(tpickler15, tag15); reader.nextInArray
        val t16 = reader.readTagged[T16]()(tpickler16, tag16); reader.nextInArray
        val t17 = reader.readTagged[T17]()(tpickler17, tag17); reader.nextInArray
        val t18 = reader.readTagged[T18]()(tpickler18, tag18); reader.nextInArray
        val t19 = reader.readTagged[T19]()(tpickler19, tag19); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple19(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19)
      }
    }


  implicit def tuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tpickler12: Pickler[T12], tpickler13: Pickler[T13], tpickler14: Pickler[T14], tpickler15: Pickler[T15], tpickler16: Pickler[T16], tpickler17: Pickler[T17], tpickler18: Pickler[T18], tpickler19: Pickler[T19], tpickler20: Pickler[T20], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11], tag12: TypeTag[T12], tag13: TypeTag[T13], tag14: TypeTag[T14], tag15: TypeTag[T15], tag16: TypeTag[T16], tag17: TypeTag[T17], tag18: TypeTag[T18], tag19: TypeTag[T19], tag20: TypeTag[T20]): Pickler[Tuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]] =
    new Pickler[Tuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]] {
      override def pickle(t: Tuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.write[T12](t._12)(tpickler12)
        writer.write[T13](t._13)(tpickler13)
        writer.write[T14](t._14)(tpickler14)
        writer.write[T15](t._15)(tpickler15)
        writer.write[T16](t._16)(tpickler16)
        writer.write[T17](t._17)(tpickler17)
        writer.write[T18](t._18)(tpickler18)
        writer.write[T19](t._19)(tpickler19)
        writer.write[T20](t._20)(tpickler20)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray
        val t12 = reader.readTagged[T12]()(tpickler12, tag12); reader.nextInArray
        val t13 = reader.readTagged[T13]()(tpickler13, tag13); reader.nextInArray
        val t14 = reader.readTagged[T14]()(tpickler14, tag14); reader.nextInArray
        val t15 = reader.readTagged[T15]()(tpickler15, tag15); reader.nextInArray
        val t16 = reader.readTagged[T16]()(tpickler16, tag16); reader.nextInArray
        val t17 = reader.readTagged[T17]()(tpickler17, tag17); reader.nextInArray
        val t18 = reader.readTagged[T18]()(tpickler18, tag18); reader.nextInArray
        val t19 = reader.readTagged[T19]()(tpickler19, tag19); reader.nextInArray
        val t20 = reader.readTagged[T20]()(tpickler20, tag20); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple20(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20)
      }
    }


  implicit def tuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tpickler12: Pickler[T12], tpickler13: Pickler[T13], tpickler14: Pickler[T14], tpickler15: Pickler[T15], tpickler16: Pickler[T16], tpickler17: Pickler[T17], tpickler18: Pickler[T18], tpickler19: Pickler[T19], tpickler20: Pickler[T20], tpickler21: Pickler[T21], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11], tag12: TypeTag[T12], tag13: TypeTag[T13], tag14: TypeTag[T14], tag15: TypeTag[T15], tag16: TypeTag[T16], tag17: TypeTag[T17], tag18: TypeTag[T18], tag19: TypeTag[T19], tag20: TypeTag[T20], tag21: TypeTag[T21]): Pickler[Tuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]] =
    new Pickler[Tuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]] {
      override def pickle(t: Tuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.write[T12](t._12)(tpickler12)
        writer.write[T13](t._13)(tpickler13)
        writer.write[T14](t._14)(tpickler14)
        writer.write[T15](t._15)(tpickler15)
        writer.write[T16](t._16)(tpickler16)
        writer.write[T17](t._17)(tpickler17)
        writer.write[T18](t._18)(tpickler18)
        writer.write[T19](t._19)(tpickler19)
        writer.write[T20](t._20)(tpickler20)
        writer.write[T21](t._21)(tpickler21)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray
        val t12 = reader.readTagged[T12]()(tpickler12, tag12); reader.nextInArray
        val t13 = reader.readTagged[T13]()(tpickler13, tag13); reader.nextInArray
        val t14 = reader.readTagged[T14]()(tpickler14, tag14); reader.nextInArray
        val t15 = reader.readTagged[T15]()(tpickler15, tag15); reader.nextInArray
        val t16 = reader.readTagged[T16]()(tpickler16, tag16); reader.nextInArray
        val t17 = reader.readTagged[T17]()(tpickler17, tag17); reader.nextInArray
        val t18 = reader.readTagged[T18]()(tpickler18, tag18); reader.nextInArray
        val t19 = reader.readTagged[T19]()(tpickler19, tag19); reader.nextInArray
        val t20 = reader.readTagged[T20]()(tpickler20, tag20); reader.nextInArray
        val t21 = reader.readTagged[T21]()(tpickler21, tag21); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple21(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21)
      }
    }


  implicit def tuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22](implicit tpickler1: Pickler[T1], tpickler2: Pickler[T2], tpickler3: Pickler[T3], tpickler4: Pickler[T4], tpickler5: Pickler[T5], tpickler6: Pickler[T6], tpickler7: Pickler[T7], tpickler8: Pickler[T8], tpickler9: Pickler[T9], tpickler10: Pickler[T10], tpickler11: Pickler[T11], tpickler12: Pickler[T12], tpickler13: Pickler[T13], tpickler14: Pickler[T14], tpickler15: Pickler[T15], tpickler16: Pickler[T16], tpickler17: Pickler[T17], tpickler18: Pickler[T18], tpickler19: Pickler[T19], tpickler20: Pickler[T20], tpickler21: Pickler[T21], tpickler22: Pickler[T22], tag1: TypeTag[T1], tag2: TypeTag[T2], tag3: TypeTag[T3], tag4: TypeTag[T4], tag5: TypeTag[T5], tag6: TypeTag[T6], tag7: TypeTag[T7], tag8: TypeTag[T8], tag9: TypeTag[T9], tag10: TypeTag[T10], tag11: TypeTag[T11], tag12: TypeTag[T12], tag13: TypeTag[T13], tag14: TypeTag[T14], tag15: TypeTag[T15], tag16: TypeTag[T16], tag17: TypeTag[T17], tag18: TypeTag[T18], tag19: TypeTag[T19], tag20: TypeTag[T20], tag21: TypeTag[T21], tag22: TypeTag[T22]): Pickler[Tuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]] =
    new Pickler[Tuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]] {
      override def pickle(t: Tuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22], writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        writer.write[T1](t._1)(tpickler1)
        writer.write[T2](t._2)(tpickler2)
        writer.write[T3](t._3)(tpickler3)
        writer.write[T4](t._4)(tpickler4)
        writer.write[T5](t._5)(tpickler5)
        writer.write[T6](t._6)(tpickler6)
        writer.write[T7](t._7)(tpickler7)
        writer.write[T8](t._8)(tpickler8)
        writer.write[T9](t._9)(tpickler9)
        writer.write[T10](t._10)(tpickler10)
        writer.write[T11](t._11)(tpickler11)
        writer.write[T12](t._12)(tpickler12)
        writer.write[T13](t._13)(tpickler13)
        writer.write[T14](t._14)(tpickler14)
        writer.write[T15](t._15)(tpickler15)
        writer.write[T16](t._16)(tpickler16)
        writer.write[T17](t._17)(tpickler17)
        writer.write[T18](t._18)(tpickler18)
        writer.write[T19](t._19)(tpickler19)
        writer.write[T20](t._20)(tpickler20)
        writer.write[T21](t._21)(tpickler21)
        writer.write[T22](t._22)(tpickler22)
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): Tuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        val t1 = reader.readTagged[T1]()(tpickler1, tag1); reader.nextInArray
        val t2 = reader.readTagged[T2]()(tpickler2, tag2); reader.nextInArray
        val t3 = reader.readTagged[T3]()(tpickler3, tag3); reader.nextInArray
        val t4 = reader.readTagged[T4]()(tpickler4, tag4); reader.nextInArray
        val t5 = reader.readTagged[T5]()(tpickler5, tag5); reader.nextInArray
        val t6 = reader.readTagged[T6]()(tpickler6, tag6); reader.nextInArray
        val t7 = reader.readTagged[T7]()(tpickler7, tag7); reader.nextInArray
        val t8 = reader.readTagged[T8]()(tpickler8, tag8); reader.nextInArray
        val t9 = reader.readTagged[T9]()(tpickler9, tag9); reader.nextInArray
        val t10 = reader.readTagged[T10]()(tpickler10, tag10); reader.nextInArray
        val t11 = reader.readTagged[T11]()(tpickler11, tag11); reader.nextInArray
        val t12 = reader.readTagged[T12]()(tpickler12, tag12); reader.nextInArray
        val t13 = reader.readTagged[T13]()(tpickler13, tag13); reader.nextInArray
        val t14 = reader.readTagged[T14]()(tpickler14, tag14); reader.nextInArray
        val t15 = reader.readTagged[T15]()(tpickler15, tag15); reader.nextInArray
        val t16 = reader.readTagged[T16]()(tpickler16, tag16); reader.nextInArray
        val t17 = reader.readTagged[T17]()(tpickler17, tag17); reader.nextInArray
        val t18 = reader.readTagged[T18]()(tpickler18, tag18); reader.nextInArray
        val t19 = reader.readTagged[T19]()(tpickler19, tag19); reader.nextInArray
        val t20 = reader.readTagged[T20]()(tpickler20, tag20); reader.nextInArray
        val t21 = reader.readTagged[T21]()(tpickler21, tag21); reader.nextInArray
        val t22 = reader.readTagged[T22]()(tpickler22, tag22); reader.nextInArray

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple22(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22)
      }
    }



}

object TuplePicklersGen {
  /** Generates the Scala code for all 22 tuple widths */
  def generatePickler(size: Int): String = {
    val ts = (1 to size) map (i => s"T$i") mkString (", ")
    val picklerParams = (1 to size) map (i => s"tpickler$i: Pickler[T$i]") mkString (", ")
    val tagParams = (1 to size) map (i => s"tag$i: TypeTag[T$i]") mkString (", ")
    val tuple = s"Tuple$size[$ts]"

    s"""implicit def tuple$size[$ts](implicit $picklerParams, $tagParams): Pickler[$tuple] =
    new Pickler[$tuple] {
      override def pickle(t: $tuple, writer: PickleWriter[_], emitObjectStart: Boolean): Unit = {
        writer.writeArrayStart()
        ${(1 to size) map (i => s"writer.write[T$i](t._$i)(tpickler$i)") mkString ("\n        ")}
        writer.writeArrayEnd()
      }

      override def unpickle(reader: PickleReader, expectObjectStart: Boolean): $tuple = {
        if (reader.tokenType != TokenType.ArrayStart) throw new UnexpectedEofException("array start")
        reader.nextInArray()

        ${(1 to size) map (i => s"val t$i = reader.readTagged[T$i]()(tpickler$i, tag$i); reader.nextInArray") mkString ("\n        ")}

        if (reader.tokenType != TokenType.ArrayEnd) throw new UnexpectedEofException("array end")

        Tuple$size(${(1 to size) map (i => s"t$i") mkString (", ")})
      }
    }
    """
  }

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 22) {
      val pickler = generatePickler(i)
      println(pickler)
      println()
    }
  }
}