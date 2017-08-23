package com.jamesrodgers.gapgemini.pos


object Main extends PointOfSale with App {
    val prompt = "(a: Apple, o: Orange, t: Total, c: Cancel) > "
    val scanAndSum = readProducts _ andThen mkLineItems andThen receipt

    scanAndSum(prompt).foreach(println)
}


