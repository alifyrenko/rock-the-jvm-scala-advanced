package lectures.part3.concurrency

import java.util.concurrent.Executors

object Intro extends App{

  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("Running in parallel")
  })

  aThread.start()
  aThread.join() // blocks until the thread finishes running

  val threadHello = new Thread(() => (1 to 5).foreach(_ => println("hello")))
  val threadGoodbuy = new Thread(() => (1 to 5).foreach(_ => println("goodbuy")))

  threadHello.start()
  threadGoodbuy.start()

  val pool = Executors.newFixedThreadPool(10)

  pool.execute(() => println("Something in the threadList"))

  pool.execute(() => {
    Thread.sleep(1000)
    println("done after 1 sec")
  })

  pool.execute(() => {
    Thread.sleep(1000)
    println("almost done")
    Thread.sleep(1000)
    println("done after 2 sec")
  })

  pool.shutdown()

  var x = 0

  def runInParalel = {
    val aThread1 = new Thread(() => {
      x = 1
    })

    val aThread2 = new Thread(() => {
      x = 2
    })

    aThread1.start()
    aThread2.start()

    println(x)
  }

  for(_ <- 1 to 100) runInParalel





}
