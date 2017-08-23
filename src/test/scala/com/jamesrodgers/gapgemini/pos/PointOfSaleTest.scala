package com.jamesrodgers.gapgemini.pos

import org.scalatest._

class PointOfSaleTest extends FunSuite with Matchers with PointOfSale {


  test("A product should know its price") {

    Apple.price should be(60)
    Orange.price should be(25)
  }

  test("A line item should know its product") {
    LineItem(Apple, 5).product should be(Apple)
    LineItem(Orange, 7).product should be(Orange)
  }

}
