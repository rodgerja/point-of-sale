package com.jamesrodgers.gapgemini.pos


trait Checkout extends App {
  this: PointOfSale =>

  private val prompt = "(a: Apple, o: Orange, t: Total, c: Cancel) > "
  private val scanAndSum = readProducts _ andThen mkLineItems andThen receipt

  scanAndSum(prompt).foreach(println)
}

object Main extends PricingStrategy with PointOfSale with Checkout

object DiscountMain extends DiscountPointOfSale with PointOfSale with Checkout






