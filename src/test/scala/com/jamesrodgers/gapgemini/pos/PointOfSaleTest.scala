package com.jamesrodgers.gapgemini.pos

import org.scalatest._
import scala.List.fill
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
    (0 to 50) foreach { count =>
      LineItem(Apple, count).totalCost should be(count * Apple.price)
      LineItem(Orange, count).totalCost should be(count * Orange.price)
    }
  }

  test("Line items can be totalled") {

    for (count <- 0 to 50) {

      val appleLineItem = LineItem(Apple, count)
      val orangeLineItem = LineItem(Orange, count)

      grandTotal(appleLineItem :: orangeLineItem :: Nil) should be(
        appleLineItem.totalCost + orangeLineItem.totalCost)
    }
  }

  test("Should group products into line items") {

    for (appleCount <- 1 to 10; orangeCount <- 1 to 10) {

      val apples = fill(appleCount)(Apple)
      val oranges = fill(orangeCount)(Orange)

      val lineItems = shuffle(mkLineItems(apples ++ oranges))
      lineItems should contain only(LineItem(Apple, appleCount), LineItem(Orange, orangeCount))
    }


  }
}
