package com.jamesrodgers.gapgemini.pos


trait PointOfSale {

  val message = "Hello sales"

  def grandTotal(lineItems: Seq[LineItem]): Long = lineItems.map(_.totalCost).sum

  def mkLineItems(products: Seq[Product]): Seq[LineItem] =
    products.groupBy(identity).map {
      case (k, v) => LineItem(k, v.size)
    }.toSeq

  def receipt(lineItems: Seq[LineItem]): Seq[String] = {
    lineItems.map(_.describe) :+ s"Total = ${format(grandTotal(lineItems))}"
  }

  private def format(value: Long): String = "%05.2f".format(value / 100.0)



}
