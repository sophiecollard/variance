package com.github.sophiecollard

import scala.util.Random

enum DogBreed:
  case Beagle, BorderCollie, Hovawart, Labrador, Retriever, Weimaraner

object DogBreed:
  def random(): DogBreed =
    Random.between(0, 6) match
      case 0 => Beagle
      case 1 => BorderCollie
      case 2 => Hovawart
      case 3 => Labrador
      case 4 => Retriever
      case _ => Weimaraner
