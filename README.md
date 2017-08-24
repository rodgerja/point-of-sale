# Point of Sale

## Author
james_rodgers@yahoo.com

## Dependencies
- sbtVersion 0.13.16
- scalaVersion 2.12.3

## run
`sbt run`

Choose one of the options
- `com.jamesrodgers.gapgemini.pos.DiscountMain`: discounted pricing
- `com.jamesrodgers.gapgemini.pos.Main`

Products are entered at the terminal with single characters as described in the prompt:

>> `(a: Apple, o: Orange, t: Total, c: Cancel) >`

## test
`sbt test`

## Issues
The program was developed on Ubuntu 16.04. Consequently an issue with the Windows console was
not spotted until development was complete. 

The program will run on Linux and Windows, but, in the latter case, console input is not correctly echoed to the screen.

The issue is described at [StackOverflow](https://stackoverflow.com/questions/23611588/console-input-within-sbt-does-not-echo-to-the-screen).
