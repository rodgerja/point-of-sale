package com.jamesrodgers.gapgemini.pos

case class LineItem(product: Product, count: Int)(implicit strategy: (Product, Int) => Long) {

  lazy val describe =
    s"$count $product @ ${formatCurrency(product.price)} = ${formatCurrency(product.price * count)}"

  lazy val totalCost: Long = strategy(product, count)

  }
