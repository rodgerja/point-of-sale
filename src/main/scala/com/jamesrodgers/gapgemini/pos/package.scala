package com.jamesrodgers.gapgemini

package object pos {

  def formatCurrency(value: Long): String = "%05.2f".format(value / 100.0)

}
