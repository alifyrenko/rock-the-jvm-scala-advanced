package lectures.part1fp

object Monads extends App{

  // our own Try monad
  trait Attempt[+A]{
    def flatMap[B](f: A => Attempt[B]): Attempt[B]
  }

  object Attempt {
    def apply[A](a: => A): Attempt[A] = {
      try{
        Success(a)
      } catch {
        case e: Throwable => Fail(e)
      }
    }
  }

  case class Success[+A](value: A) extends Attempt[A]{
    def flatMap[B](f: A => Attempt[B]): Attempt[B] = {
      try{
        f(value)
      } catch {
        case e: Throwable => Fail(e)
      }
    }
  }

  case class Fail(e: Throwable) extends Attempt[Nothing]{
    def flatMap[B](f: Nothing => Attempt[B]): Attempt[B] = this
  }

  /*
    => Monad laws:
        left identity
          unit.flatMap(f) => f(x)   || Attemp(x).flatMap(f) => f(x) // Success case
          Success(x).flatMap(f) => f(x)

        right identity
        attempt.flatMap(unit) => attempt
        Success(x).flatMap(x => Attempt(x)) = Attempt(x) = Success(x)

        associativity
        attempt.flatMap(f).flatMap(g) == attempt.flatMap(x => f(x).flatMap(g))
   */

  val attempt = Attempt {
    throw new RuntimeException("My own monad, yes")
  }

  println(attempt)


  class Lazy[A](value: => A){
    def flatMap[B](f: A => Lazy[B]): Lazy[B] = f(value)
  }

  object Lazy {
    def apply[A](value: => A): Lazy[A] = new Lazy(value)
  }

  println(List("abc", "dfg", "opr").flatMap(x => List(x.reverse)))

}

