package com.github.sophiecollard

sealed trait Animal {
  def name: String
  def healthStatus: HealthStatus
}

object Animal {

  final case class Cat(
    name: String,
    healthStatus: HealthStatus,
    livesRemaining: Int
  ) extends Animal

  final case class Dog(
    name: String,
    healthStatus: HealthStatus,
    breed: Option[String]
  ) extends Animal

  final case class Horse(
    name: String,
    healthStatus: HealthStatus,
    racesWon: Int
  ) extends Animal

}
