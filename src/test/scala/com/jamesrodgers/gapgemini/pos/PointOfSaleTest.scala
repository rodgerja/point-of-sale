package com.jamesrodgers.gapgemini.pos

import org.scalatest._

import scala.util.Random.shuffle

class PointOfSaleTest extends FunSuite with Matchers with PointOfSale {


  test("A product should know its price") {

    Apple.price should be(60)
    Orange.price should be(25)
  }

  test("A line item should know its product") {
    LineItem(Apple, 5).product should be(Apple)
    LineItem(Orange, 7).product should be(Orange)
  }

  test("A line item should know its total") {
    (1 to 50) foreach { count =>
      LineItem(Apple, count).totalCost should be(count * Apple.price)
      LineItem(Orange, count).totalCost should be(count * Orange.price)
    }
  }

  test("Line items can be totalled") {
    val appleLineItem = LineItem(Apple, 8)
    val orangeLineItem = LineItem(Orange, 4)

    grandTotal(appleLineItem :: orangeLineItem :: Nil) should be(
      appleLineItem.totalCost + orangeLineItem.totalCost)
  }

  test("Should group products into line items") {

    val apples = Apple :: Apple :: Apple :: Nil
    val oranges = Orange :: Orange :: Nil

    val lineItems = shuffle(mkLineItems(apples ++ oranges))

    lineItems should contain only(LineItem(Apple, 3), LineItem(Orange, 2))
  }
}
