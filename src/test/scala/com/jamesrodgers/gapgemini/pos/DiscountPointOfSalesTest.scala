package com.jamesrodgers.gapgemini.pos

import org.scalatest.{FunSuite, Matchers}


class DiscountPointOfSalesTest extends FunSuite with Matchers with PointOfSale {

  ignore("Should correctly sum reduced price apples") {

    for (count <- 1 to 100) {
      val appleLineItem = LineItem(Apple, count)
      appleLineItem.totalCost should be (count / 2 * Apple.price + count % 2 * Apple.price)
    }

    for (count <- 1 to 100) {
      val orangeLineItem = LineItem(Orange, count)
      orangeLineItem.totalCost should be (count / 3 * Orange.price * 2 + count % 3 * Orange.price)
    }

  }

}
