package com.jamesrodgers.gapgemini.pos

trait Product {
  def price: Long
}

object Apple extends Product {
  val price = 60
}

object Orange extends Product {
  val price = 25
}