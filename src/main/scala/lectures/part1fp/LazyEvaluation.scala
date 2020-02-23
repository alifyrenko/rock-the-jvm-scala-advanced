package lectures.part1fp

object LazyEvaluation extends App {

  lazy val x: Int = {
    println("Hello")
    42
  }

  println(x)
  println(x)

  def sideEffectCondition: Boolean = {
    println("Boo")
    true
  }

  def simpleCondition: Boolean = false

  lazy val lazyCondition = sideEffectCondition

  println(if(simpleCondition && lazyCondition) "yes" else "no")
}
