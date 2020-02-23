package exercises

import exercises.CallByNamePlayground.A

object CallByNamePlayground extends App{

 val myFunction: Int => Int = x => x * 2
  val myFunction0: (Int,Int) => Int = (x,y) => x+y

  println(myFunction0(10,20))


  //==============================
  trait C

  class A(val a: Int, val b: String) extends C {
  }

  object A {
    def unapply(arg: A): Option[(Int, String)] = Some(arg.a, arg.b)
  }

  class B(val a: Int, val b: Double) extends C {
  }
  object B {
    def unapply(arg: B): Option[(Int, Double)] = Some(arg.a, arg.b)
  }

  val someFunc: C => Int = {
    case A(a,b) => a
    case B(a,b) => a
  }

  val a: List[C]  = List[A](new A(1, "Foo"))





}
