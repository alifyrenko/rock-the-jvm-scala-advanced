package lectures.part1as

object AdvancedPatternMatching extends App {

  val numbers = List(1)

  val description = numbers match {
    case head :: Nil => println(s"the only element is $head")
    case _ =>
  }

  val x = List(1,2,3,4,5).map {
    case w if w % 2 == 0 => w
    case _ => 0
  }

  println(x)


  // infix pattern
  case class Or[A, B](a: A, b: B)
  val either = Or(2, "two")
  val humanDescription = either match {
    case number Or string => s"$number is written as $string"
  }
  println(humanDescription)


  val vararg = numbers match {
    case List(1, _*) => "starting with one"
  }

  abstract class MyList[+A] {
    def head: A = ???
    def tail: MyList[A] = ???
  }

  case object Empty extends MyList[Nothing]
  case class Cons[+A](override val head: A, override val tail: MyList[A]) extends MyList[A]
}
