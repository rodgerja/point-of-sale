package com.jamesrodgers.gapgemini.pos


trait PointOfSale {

  val message = "Hello sales"

  def grandTotal(lineItems: Seq[LineItem]): Long = lineItems.map(_.totalCost).sum


}
