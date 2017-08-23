package com.jamesrodgers.gapgemini.pos

import scala.annotation.tailrec
import scala.io.StdIn


trait PointOfSale {

  this: PricingStrategy =>

  val message = "Hello sales"

  def grandTotal(lineItems: Seq[LineItem]): Long = lineItems.map(_.totalCost).sum

  def mkLineItems(products: Seq[Product]): Seq[LineItem] =
    products.groupBy(identity).map {
      case (k, v) => LineItem(k, v.size)
    }.toSeq

  def receipt(lineItems: Seq[LineItem]): Seq[String] = {
    lineItems.map(_.describe) :+ s"Total = ${formatCurrency(grandTotal(lineItems))}"
  }

  def readProducts(prompt: String): Seq[Product] = {
    @tailrec
    def read(lines: Seq[Product]): Seq[Product] = {

      val line = StdIn.readLine(prompt).trim

      line match {
        case "a" => read(lines :+ Apple)
        case "o" => read(lines :+ Orange)
        case "t" => lines
        case "c" => Seq.empty
        case _ => read(lines)
      }

    }
    read(Nil)
  }



}
