package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  println("exists: " + exists(singletonSet(1), (x: Int) => x > 0))

  printSet(singletonSet(1))
  printSet(map(singletonSet(1), (x: Int) => 2*x))
}
