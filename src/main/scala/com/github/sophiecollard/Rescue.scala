package com.github.sophiecollard

import com.github.sophiecollard.Animal.{Cat, Dog}

import scala.util.Random

trait Rescue[+A]:
  extension (name: String) def adopt: A

object Rescue:

  def summon[A](using rescue: Rescue[A]): Rescue[A] = rescue

  given Rescue[Dog] with
    extension (name: String) def adopt: Dog =
      Dog(name, breed = None)

  given Rescue[Animal] with
    extension (name: String) def adopt: Animal =
      Random.between(0, 2) match
        case 0 => Cat(name, livesRemaining = 7)
        case _ => Dog(name, breed = None)
