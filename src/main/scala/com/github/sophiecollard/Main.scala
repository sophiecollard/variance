package com.github.sophiecollard

import com.github.sophiecollard.Animal.Dog

object Main {

  def main(args: Array[String]): Unit = {
    val medorTheDog = adopt("Médor", PetRescue.dogRescue)
    // TODO Try making the A type parameter in PetRescue invariant (PetRescue[A]).
    //  What happens and why?
    //  What benefit does covariance give us?
    //  If unsure, try reasoning as follows:
    //    - I want to adopt an animal
    //    - A dog is an animal
    //    - Hence, I can adopt an animal from a dog rescue, i.e. I can use an instance of
    //      PetRescue[Dog] where an instance of PetRescue[Animal] is required.
    val medorTheAnimal = adopt[Animal]("Médor", PetRescue.dogRescue)

    val examinationReportA = takeToVet(medorTheDog, PetClinic.dogClinic)
    println(examinationReportA)
    // TODO Try making the A type parameter in PetClinic invariant (PetClinic[A]).
    //  What happens and why?
    //  What benefit does contravariance give us?
    //  If unsure, try reasoning as follows:
    //    - I need to take my dog to a clinic
    //    - A dog is an animal
    //    - Hence, I can take my dog to an animal clinic, i.e. I can use an instance of
    //      PetClinic[Animal] where an instance PetClinic[Dog] is required.
    val examinationReportB = takeToVet[Dog](medorTheDog, PetClinic.petClinic)
    println(examinationReportB)
  }

  def adopt[A](name: String, rescue: PetRescue[A]): A =
    rescue.adopt(name)

  def takeToVet[A](pet: A, clinic: PetClinic[A]): String =
    clinic.examine(pet)

}
