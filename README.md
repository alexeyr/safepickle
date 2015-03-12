# safepickle

A deliberately restricted pickling library for Scala. It has certain features, and deliberately lacks others, because it is tailormade for a particular scenario I needed. Most people will prefer general purpose libraries such as scala-pickling, upickle, or rapture, but this one is optimized for the following goals:

 1. Security. Pickled input can be generated by untrusted sources. Unpickling must not instantiate unexpected classes, take unpredictable amounts of space or time, or produce values not of the expected type. The set of pickleable types, and the code that serializes them, is determined at compile time, and runtime reflection is never used.
 2. Certain changes to the definitions of pickled types are guaranteed to be backward and forward compatible, so different versions of the program can communicate, and pickled data can be used for long term storage.
 3. Backward incompatible changes can be managed explicitly, with version numbers and conversion code, allowing new code to read data written by old code, and old code to fail on encountering data written by new code.
 4. Pickled classes correspond directly to the pickled form (at least for JSON and BSON), making it easy to write classes to represent data whose main schema definition is written in terms of the pickled format.

The library is also small enough to understand and validate by hand, and to make sure its performance is driven by that of the backend used (e.g. Jackson for JSON).

## Usage overview

`safepickle` artifacts are published on Maven Central with the group ID `com.fsist` and the names `safepickle`, `safepickle-jackson`, `safepickle-joda-time`, `safepickle-reactivemongo`. The published artifact versions correspond to the release tags in the Github project.

The `safepickle-*` modules are separate because they add dependencies on other libraries - Jackson, Joda-Time and ReactiveMongo, respectively. They define picklers for their types and pickling backends for their JSON and BSON implementations. 

To pickle or unpickle a value, you need to choose an implementation of `PicklerBackend`, such as `JacksonPicklerBackend.String`, and call its `read` and `write` methods. These two methods take an implicit parameter of type `Pickler[T]`, which knows how to pickle and unpickle values of type `T`.

```
case class A(i: Int, b: String)
object A {
 implicit val pickler = Autogen[A]
}

val json = backend.write(A(1, "foo")) 
// Result: """{ "i": 1, "b": "foo }"""
```

### Using Autogen

It's possible to implement a `Pickler[T]` manually, but normally Picklers are generated using the `Autogen` family of macros and placed on the companion object of `T` to be available as an implicit:

```
case class C(a: String, b: Int = 2)
object C {
  implicit val pickler = Autogen[C]
}

sealed trait T
object T {
  case class One(a: String) extends T
  case object Two extends T

  implicit val pickler = Autogen.children[T, One | Two.type]
}
```

`Autogen` serializes a class by writing the arguments of its primary constructor and their values. These arguments have to be `val`s, as in a case class. The complete details are listed below.

`Autogen.children` can be used on any trait or class with descendants, and it doesn't have to be sealed. However, you have to provide an explicit list of the subtypes you wish to support. Because of a long-standing scala compiler [issue](https://issues.scala-lang.org/browse/SI-7588), even when the parent type is sealed, if you invoke `Autogen.children` in the same compilation unit (file) where the parent type is defined, you must pass an explicit list of child types.

The Autogen macros (including Autogen.apply and Autogen.children) will use any implicit picklers that are in scope for pickling referenced types. They will also always use the built-in picklers defined in `DefaultPicklers` for primitive values (Int, String, etc.) and collections. 

If a pickler is not available, they will call Autogen recursively for the missing types:

```
case class A(s: String)
case class B(a: A)
case class C(i: Int) {
  implicit val pickler = ...
}
case class D(b: B, c: C)
object D {
  implicit val pickler = Autogen[D]
}
```

The pickler generated by `Autogen[D]` will use the existing `C.pickler`, because it's available as an implicit on the `C` companion object. It will call `Autogen[B]`, which will call `Autogen[A]`.

### Modifying Autogen's output

There are several annotations that can be placed on class parameters

## Introduction to the main types

`safepickle` supports multiple backends which write data in different formats and using different implementations. It comes with a backend for JSON that uses Jackson and another for BSON that uses ReactiveMongo, and more can be added.

Every backend is required to support reading and writing these primitive types:
 
 * Boolean, String, Null
 * Int, Long, Float, Double
 * Array: a sequence of values of any types
 * Object: a map of strings to values of any types

A particular backend might support more primitives. For instance, BSON supports Binary (i.e. Array[Byte]) as a primitive type, but JSON doesn't. Other types are written as objects or arrays using primitive types.

A backend is declared by implementing `trait PicklingBackend`, which defines the types used (e.g. for JSON it might be a String), and provides a factory for `PickleReader`s and `PickleWriter`s.

Implementations of `trait PickleReader` and `trait PickleWriter` provide low-level access to reading and writing a sequence of primitive values in a particular backend. Users of `safepickle` normally don't interact directly with these interfaces, except for manually implementing `Pickler`s.

The high-level trait for pickling looks like this:

```
trait Pickler[T] {
  def pickle(t: T, writer: PickleWriter[_], emitObjectStart: Boolean = true): Unit
  def unpickle(reader: PickleReader, expectObjectStart: Boolean = true): T
}
```

## Supported values for pickling

The primitive values corresponding to the above list (Boolean, String, Int, Long, Float, Double, and Null) are pickled directly as such.

An `Array[Byte]` is pickled as a base64 string, but some backends override this with, e.g. BSON-based backends have a dedicated Binary type.

Values of type `Iterable[T]`, where T is any supported type, are pickled as Arrays. This includes all kinds of `Iterable`s, including `Set`s, as well as `Array[T]`, which isn't natively an `Iterable[T]`.

Tuples of supported types.

`Map`s are serialized as arrays, where each key-value pair is pickled as an array of size 2. However, as a special case, `Map`s with String keys are pickled as Objects.

Objects are pickled as strings whose value is the object's (non fully qualified) name.

Classes are pickled as Objects whose attributes correspond to the values of the class's main constructor arguments.

Case objects and case classes behave the same way as ordinary objects and classes.

A `sealed trait` or `sealed abstract class` is pickled as whichever of its (immediate) descendants is actually present. If that results in an Object, it will have an extra attribute named `$type`, equal to the class's name. This is known as the type tag, and tells the unpickler which value to instantiate. If pickling results in a String, because the concrete descendant of `trait T` is an object or a class with zero parameters, then the value of the string provides this service.

A sealed trait (or abstract class) T1, which is extended by another sealed trait T2, will be pickled as follows: an Object with attribute `$type = T2` and another attribute `$value` equal to whatever the concrete value extending T2 is pickled as.

## Pickling classes

Picklers for classes are generated using the `Autogen` macro. The class must obey these requirements:

 * The primary constructor (the one that's written as part of the `class` definition) must have no more than one parameter list.
 * The primary constructor must be public.
 * The primary constructor's parameters must be declared as public `val`s or `var`s (using a case class does this by default).
 * The primary constructor's parameter types must have implicit picklers in scope. (Pickler definitions from DefaultPicklers
   are used automatically and don't have to be explicitly imported.)

Autogenerated class picklers have some special behaviors, designed to allow the compatible changes to class declarations that are listed in another section.

 1. If the class's primary constructor has no parameter lists, or a single empty parameter list, it's not pickled as an Object, but as a String whose value is the name of the class, the same as a Scala `object`.
 2. When unpickling, the order of the pickled Object's attributes doesn't have to correspond to the order of the constructor parameters. However, the `$version` attribute (if present) must come first.
 3. When unpickling, attributes with unexpected names are discarded.
 4. When pickling, if a parameter's value is equal to its declared default value, that parameter is not written. Equality is determined using == (i.e. the `equals` method). This behavior can be disabled for a particular attribute by adding the @WriteDefault annotation.
 5. When unpickling, if a constructor parameter with a declared default value is missing a pickled value, the default value will be used instead.
 6. Class parameters of type `Option[T]` are pickled as follows: for `Some[T]`, the `T` value is written directly; for `None`, no attribute is written at all. This allows making an existing class parameter optional, which is a common change.

## Types not supported out of the box

It's always possible to write a Pickler manually for any unsuppored type.

 * Classes whose primary constructor has more than one parameter list, or is not public
 * Classes whose primary constructor has a parameter whose type isn't pickleable
 * Iterables whose static member type isn't pickleable (there's no Pickler available for it)

## Compatible type changes

As long as all object and class picklers used are created by the `Autogen` macro, or are written to be compatible with the above rules, the following changes to Scala definitions will be backward and forward compatible, so that different code versions will be able to exchange data.

Because the compatibility is bidirectional, each of these cases implies the reverse transformation is also compatible.

 1. These are all interchangeable: `object O`, `class O` and `class O()`. Also, case and non-case objects and classes are interchangeable.
 2. A class parameter can be added (at any position), if it has a default value declared. A parameter can be removed (from any position), if it previously (always) had a default value declared. When code with the parameter declared unpickles data without it, it uses the default value. When code without the parameter declared unpickles data with it, it ignores it.
 3. The order of parameters can be changed freely.
 4. Any sequence type (`Iterable[T]` or a subtype of it) can be replaced with any other sequence type with the same member type. E.g., `List[Int]`  can be replaced with `Vector[Int]`. This includes `Set`s and `Map`s, but not `Map`s whose key type is String, because those are pickled as Objects and not as Arrays. (If a non-Set sequence type is replaced with a Set, when unpickling, duplicate values will be discarded.)
 5. Only in a class parameter type, `T` can be replaced with `Option[T]`, as long as the non-optional `T` has always had a default value. (Recall that, for class parameters, `Option[T]` is written as a `T` or omitted entirely if the value was `None`.)
 6. A sequence member type, or a map key or value type, can be replaced with another type, if the two types are compatible according to these rules. For instance, `List[List[Int]]` can be replaced with `Vector[Set[Long]]`.

Extra TODOs (will be moved to tickets):
- Performance tests
- Versioning support
- Create @Specialized versions of Pickler trait?
- Make Autogen use the concrete PickleReader/Writer methods for primitive types to improve performance
- Add tests in Autogen to make sure user attribute names can't clash with our $special attributes
- When Autogen (recursively) generates a pickler for the same type multiple times in the same call to Autogen,
  reuse the generated value
- Find a way to get the declared default value without runtime reflection

## Included backends

`safepickle` includes two `PicklerBackend` implementations, one for JSON using the [Jackson](https://github.com/FasterXML/jackson) implementation, and one for BSON using [ReactiveMongo](http://reactivemongo.org/), an Akka-based Scala driver for Mongo.

### ReactiveMongo integration

The `safepickle-reactivemongo` module includes, in addition to the `PicklerBackend` and `Pickler` implementations, a macro called `MongoHandler.apply[T]`. When an implicit `Pickler[T]` is available, this macro generates a `reactivemongo.bson.BSONHandler[BSONValue, T]`, which is the typeclass instance ReactiveMongo needs to read and write values of type `T` to Mongo. The macro uses the pickler with the reactivemongo `PicklerBackend` implementation without modifying the output.

A second variant on the macro, called `MongoHandler.document[T]`, generates instead a `reactivemongo.bson.BSONDocumentReader[T] with reactivemongo.bson.BSONDocumentWriter[T]`, which are needed for ReactiveMongo to read and writes instances of type `T` as top-level documents in Mongo. If the original Pickler produces a `BSONValue` which is not a `BSONDocument`, like a `BSONString` or a `BSONArray`, the macro wraps it in a `BSONDocument` as the value of the `_id` field.

Typical use then looks as follows:

```
case class A(...)
object A {
  implicit val pickler = Autogen[A]
  implicit val mongoHandler = MongoHandler.document[A]
}
```
