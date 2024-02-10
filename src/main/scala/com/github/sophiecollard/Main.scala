package com.github.sophiecollard

import com.github.sophiecollard.Animal.Dog

object Main:

  def main(args: Array[String]): Unit =
    val teddy = adopt("Teddy")(using summon[Rescue[Dog]])
    println(s"Welcome home ${teddy.name}!")

    val médor = Dog(name = "Médor", breed = Some(DogBreed.Labrador))
    takeToTheVet(médor)(using summon[Clinic[Animal]])

  def adopt(name: String)(using rescue: Rescue[Animal]): Animal =
    rescue.adopt(name)

  def takeToTheVet(dog: Dog)(using clinic: Clinic[Dog]): String =
    clinic.examine(dog)
