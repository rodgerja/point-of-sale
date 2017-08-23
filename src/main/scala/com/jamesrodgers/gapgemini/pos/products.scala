package com.jamesrodgers.gapgemini.pos

trait Product {
  def price: Long
}

object Apple extends Product {
  val price = 60
  override def toString: String = "Apple"
}

object Orange extends Product {
  val price = 25
  override def toString: String = "Orange"
}