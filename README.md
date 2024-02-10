# Variance

Simple examples to illustrate the differences between invariance, covariance and contravariance in Scala.

## Example 1

Consider the following `Animal` type and `Rescue` and `Clinic` type classes:

```scala
sealed abstract class Animal(val name: String)

object Animal:

  final case class Cat(
    override val name: String,
    livesRemaining: Int
  ) extends Animal(name)

  final case class Dog(
    override val name: String,
    breed: Option[DogBreed]
  ) extends Animal(name)
```

```scala
trait Rescue[+A]:
  extension (name: String) def adopt: A

trait Clinic[-A]:
  extension (a: A) def examine: String
```

Now, let's define methods to adopt an animal and take a dog to the vet:

```scala
def adopt(name: String)(using rescue: Rescue[Animal]): Animal =
  rescue.adopt(name)

def takeToTheVet(dog: Dog)(using clinic: Clinic[Dog]): String =
  clinic.examine(dog)
```

Assuming instances of `Rescue[Animal]` and `Clinic[Dog]` have been defined, we could invoke the above methods as
follows:

```scala
val teddy = adopt("Teddy")
println(s"Welcome home ${teddy.name}!")

val médor = Dog(name = "Médor", breed = Some(DogBreed.Labrador))
takeToTheVet(médor)
```

Let's assume however, that we do not have `Rescue[Animal]` nor `Clinic[Dog]` instances. Instead, all we have are
`Rescue[Dog]` and `Clinic[Animal]`:

```scala
val teddy = adopt("Teddy")(using summon[Rescue[Dog]])
println(s"Welcome home ${teddy.name}!")

val médor = Dog(name = "Médor", breed = Some(DogBreed.Labrador))
takeToTheVet(médor)(using summon[Clinic[Animal]])
```

The code above is able to compile thanks to `Rescue` being _covariant_ in `A` and `Clinic` being _contravariant_ in `A`.
