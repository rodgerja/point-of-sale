package com.jamesrodgers.gapgemini.pos

import org.scalatest._

class PointOfSaleTest extends FunSuite with Matchers with PointOfSale {


  test("A product should know its price") {

    Apple.price should be(60)
    Orange.price should be(25)
  }

}
