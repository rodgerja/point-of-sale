package com.jamesrodgers.gapgemini.pos

case class LineItem(product: Product, count: Long) {

  lazy val describe = s"$count $product @ $formattedPrice = $formattedTotal"

  lazy val totalCost: Long = product.price * count

  private lazy val formattedPrice = "%05.2f".format(product.price / 100.0)
  private lazy val  formattedTotal = "%05.2f".format(product.price * count / 100.0)
}
