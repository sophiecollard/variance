package com.github.sophiecollard

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
