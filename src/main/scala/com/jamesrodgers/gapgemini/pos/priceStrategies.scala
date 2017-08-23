package com.jamesrodgers.gapgemini.pos

trait PricingStrategy {
  implicit def strategy: (Product, Int) => Long = (product, count) => product.price * count
}