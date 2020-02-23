package lectures.part1as

import scala.annotation.tailrec

object Recap extends App {

  val aCondition: Boolean = false
  val aConditionedVal = if(aCondition) 42 else 65
  //instructions vs expressions

  val aCodeBlock = {
    if(aCondition) 54
    62
  }

  val theUnit = println("Hello, Scala")

  def aFunction(x: Int): Int = x + 1

  @tailrec def factorial(n: Int, accumulator: Int): Int =
    if(n <= 0) accumulator
    else factorial(n - 1, n * accumulator)

  class Animal
  class Dog extends Animal

  val aDog: Animal = new Dog

  trait Carnivore{
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("crunch!")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog

  val aCarnivor = new Carnivore {
    override def eat(a: Animal): Unit = println("roar!")
  }

  val aPotentialFailure = try{
    throw new RuntimeException
  } catch {
    case e: Exception => println("caught exception")
  } finally {
    println("some logs")
  }

  val incrementer = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  incrementer(1)

  val anonymousIncrementor = (x: Int) => x + 1

  List(1,2,3).map(anonymousIncrementor)

  val pairs = for {
    num <- List(1,2,3)
    char <- List('a','b','c')
  } yield num + "-" + char

  val x = 2

  val order = x match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => x + "th"
  }


}
