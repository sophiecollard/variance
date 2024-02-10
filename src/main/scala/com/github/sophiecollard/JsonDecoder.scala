package com.github.sophiecollard

trait JsonDecoder[+A]:
  extension (json: String) def decode: Option[A]
