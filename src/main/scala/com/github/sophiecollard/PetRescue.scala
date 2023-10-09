package com.github.sophiecollard

import com.github.sophiecollard.Animal.{Cat, Dog, Horse}
import com.github.sophiecollard.HealthStatus.Healthy

import scala.util.Random

trait PetRescue[+A] {
  def adopt(name: String): A
}

object PetRescue {

  val dogRescue: PetRescue[Dog] = new PetRescue[Dog] {
    override def adopt(name: String): Dog =
      Dog(name, healthStatus = Healthy, breed = None)
  }

  val rspca: PetRescue[Animal] = new PetRescue[Animal] {
    override def adopt(name: String): Animal =
      Random.between(0, 3) match {
        case 0 => Cat(name, healthStatus = Healthy, livesRemaining = 7)
        case 1 => Dog(name, healthStatus = Healthy, breed = None)
        case _ => Horse(name, healthStatus = Healthy, racesWon = Random.between(0, 10))
      }
  }

}
