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

  test("A line item should describe itself") {

    val expectedApplePrice = "%05.2f".format(Apple.price / 100.0)
    val expectedOrangePrice = "%05.2f".format(Orange.price / 100.0)

    for (appleCount <- 1 to 10; orangeCount <- 1 to 10) {

      val expectedAppleTotal = "%05.2f".format(Apple.price * appleCount / 100.0)
      val expectedOrangeTotal = "%05.2f".format(Orange.price * orangeCount / 100.0)

      LineItem(Apple, appleCount).describe should be(s"$appleCount Apple @ $expectedApplePrice = $expectedAppleTotal")
      LineItem(Orange, orangeCount).describe should be(s"$orangeCount Orange @ $expectedOrangePrice = $expectedOrangeTotal")
    }
  }

  test("Should generate receipt") {

    for (appleCount <- 1 to 10; orangeCount <- 1 to 10) {

      val appleLineItem = LineItem(Apple, appleCount)
      val orangeLineItem = LineItem(Orange, orangeCount)
      val lineItems = appleLineItem :: orangeLineItem :: Nil

      val expectedTotal = (appleLineItem.totalCost + orangeLineItem.totalCost) / 100.0

      receipt(lineItems) should contain inOrderOnly(
        appleLineItem.describe,
        orangeLineItem.describe,
        f"Total = $expectedTotal%05.2f")
    }
  }

}
