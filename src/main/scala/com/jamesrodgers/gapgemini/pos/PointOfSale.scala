package com.jamesrodgers.gapgemini.pos


trait PointOfSale {

  val message = "Hello sales"

  def grandTotal(lineItems: Seq[LineItem]): Long = lineItems.map(_.totalCost).sum

  def mkLineItems(products: Seq[Product]): Seq[LineItem] =
    products.groupBy(identity).map {
      case (k, v) => LineItem(k, v.size)
    }.toSeq


}
