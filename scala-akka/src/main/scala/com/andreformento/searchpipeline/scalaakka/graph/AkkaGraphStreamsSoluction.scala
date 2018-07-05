package com.andreformento.searchpipeline.scalaakka.graph

// https://doc.akka.io/docs/akka/current/stream/stream-graphs.html
object AkkaGraphStreamsSoluction extends App {

  val step1: Request => FirstStepResult = (r: Request) => {
    println("First step")
    FirstStepResult(r.pageNum, List(r.pageNum)) // complex implementation step
  }

  val step2Alternative1: FirstStepResult => SecondStepResult = (r: FirstStepResult) => {
    println("Second step, alternative 1")
    SecondStepResult(r.hits, r.ids) // complex implementation step
  }

  val step2Alternative2: FirstStepResult => SecondStepResult = (r: FirstStepResult) => {
    println("Second step, alternative 2")
    SecondStepResult(r.hits, r.ids) // complex implementation step
  }

  val finalStep: SecondStepResult => Response = (r: SecondStepResult) => {
    println("Final step")
    Response(r.hits, r.ids, 30) // complex implementation step
  }

  val pipeline = step1.andThen(step2Alternative1).andThen(finalStep)

  val response: Response = pipeline(Request("notebook", "relevance", 2))

}

case class Request(query: String, sort: String, pageNum: Int)

case class FirstStepResult(hits: Int, ids: List[Int])

case class SecondStepResult(hits: Int, ids: List[Int])

case class Response(hits: Int, ids: List[Int], time: Int)
