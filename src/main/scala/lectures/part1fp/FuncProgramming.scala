package lectures.part1fp

object FuncProgramming extends App{

  val inputDescription: PartialFunction[String, String] = {
    case "hello" => "Hello, Mr.Anderson"
    case "hi" => "Hello, Neo"
    case _ => "some default message"
  }

  scala.io.Source.stdin.getLines().map(inputDescription).foreach(println)
}
