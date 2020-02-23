package lectures.part1as

object DarkSugars extends App{

  // syntax sugar #1 => methods with single param
  def singleArgMethod(x: Int): String = s"$x little ducks..."

  val description = singleArgMethod {
    // some code
    56
  }

  List(1,2,3).map{ x =>
    x + 1
  }

  // single abstract method
  trait Action{
    def act(x: Int): Int
  }

  val anIstance = new Action {
    override def act(x: Int): Int = x + 1
  }

  val aFunkyInstance: Action = (x: Int) => x + 1

  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("Hello, Scala")
  })

  val aSweetyThread = new Thread(() => println("Hello, Scala"))
}
