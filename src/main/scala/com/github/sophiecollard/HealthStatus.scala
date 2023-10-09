package com.github.sophiecollard

sealed trait HealthStatus {
  override def toString: String = this match {
    case HealthStatus.Healthy => "healthy"
    case HealthStatus.Sick    => "sick"
  }
}

object HealthStatus {
  case object Healthy extends HealthStatus
  case object Sick    extends HealthStatus
}
