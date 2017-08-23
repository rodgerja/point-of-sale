package com.jamesrodgers.gapgemini.pos

case class LineItem(product: Product, count: Long) {
  lazy val totalCost: Long = product.price * count
}
