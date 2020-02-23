package lectures.part1fp

object CurriesPAF extends App{

  // curried functions
  val superAdder: Int => Int => Int = x => y => x + y

  val add3 = superAdder(3)

  println(add3(5))
  println(superAdder(3)(3))  // curried function

  def curriedAdder(x: Int)(y: Int): Int = x + y // curried method

  val add4: Int => Int = curriedAdder(4)
  println(add4(5))

  val add5 = curriedAdder(5) _

  // Excercise
  val simpleAddFunction = (x: Int, y: Int) => x + y
  def simpleAddMethod(x: Int, y: Int) = x + y
  def curriedAddMethod(x: Int)(y: Int) = x + y

  // add7: Int => Int = y => y + 1
  val add7_1 = curriedAddMethod(7) _
  val add7_1_1 = curriedAddMethod(7)(_)
  val add7_2 = (x: Int) => simpleAddFunction(x, 7)
  val add7_2_1 = simpleAddMethod(7, _: Int)
  val add7_3 = (x: Int) => simpleAddMethod(x, 7)
  val add7_4 = (x: Int) => curriedAddMethod(7)(x)

  val add7_5 = simpleAddFunction.curried(7)

  println(add7_1(3))
  println(add7_2(3))
  println(add7_3(3))
  println(add7_4(3))


}
