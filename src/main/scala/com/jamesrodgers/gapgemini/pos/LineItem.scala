package com.jamesrodgers.gapgemini.pos

case class LineItem(product: Product, count: Long) {

  lazy val describe =
    s"$count $product @ ${formatCurrency(product.price)} = ${formatCurrency(product.price * count)}"

  lazy val totalCost: Long = product.price * count

  }
