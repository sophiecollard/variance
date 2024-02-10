package com.github.sophiecollard

import com.github.sophiecollard.Animal.{Cat, Dog}

trait Clinic[-A]:
  extension (a: A) def examine: String

object Clinic:

  def summon[A](using clinic: Clinic[A]): Clinic[A] = clinic

  given Clinic[Dog] with
    extension (dog: Dog) def examine: String =
      s"${dog.name} is a ${dog.breed.map(_.toString).getOrElse("dog")}"

  given Clinic[Animal] with
    extension (animal: Animal) def examine: String = animal match
      case Cat(name, livesRemaining) =>
        s"$name is a cat with $livesRemaining lives remaining"
      case Dog(name, breed) =>
        s"$name is a ${breed.map(_.toString).getOrElse("mongrel")}"
