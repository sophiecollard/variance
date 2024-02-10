package com.github.sophiecollard

trait JsonEncoder[-A]:
  extension (a: A) def encode: String
