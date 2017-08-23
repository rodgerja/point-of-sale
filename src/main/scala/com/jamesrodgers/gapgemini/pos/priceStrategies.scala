package com.jamesrodgers.gapgemini.pos

trait PricingStrategy {
  implicit def strategy: (Product, Int) => Long = (product, count) => product.price * count
}

trait DiscountPointOfSale extends PricingStrategy {

  override implicit val strategy: (Product, Int) => Long = (product, count) => product match {
    case Apple => count / 2 * Apple.price + count % 2 * Apple.price
    case Orange => count / 3 * Orange.price * 2 + count % 3 * Orange.price
    case _ => super.strategy.apply(product, count)
  }
}