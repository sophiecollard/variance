package com.github.sophiecollard

import com.github.sophiecollard.Animal.Dog

trait PetClinic[-A] {
  def examine(pet: A): String
}

object PetClinic {

  val dogClinic: PetClinic[Dog] = new PetClinic[Dog] {
    override def examine(dog: Dog): String =
      s"${dog.name} is a ${dog.healthStatus} ${dog.breed.getOrElse("dog")}"
  }

  val petClinic: PetClinic[Animal] = new PetClinic[Animal] {
    override def examine(pet: Animal): String = pet match {
      case Animal.Cat(name, healthStatus, livesRemaining) =>
        s"$name is a $healthStatus cat with $livesRemaining lives remaining"
      case Dog(name, healthStatus, breed) =>
        s"$name is a $healthStatus ${breed.getOrElse("dog")}"
      case Animal.Horse(name, healthStatus, racesWon) =>
        s"$name is a $healthStatus horse who won $racesWon races"
    }
  }

}
