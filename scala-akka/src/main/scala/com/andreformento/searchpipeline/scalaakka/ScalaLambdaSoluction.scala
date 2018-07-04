package com.andreformento.searchpipeline.scalaakka

object ScalaLambdaSoluction extends App {

  val step1: Request => FirstStepResult = (r: Request) => {
    FirstStepResult(r.pageNum, List(r.pageNum)) // complex implementation step
  }

  val step2Alternative1: FirstStepResult => SecondStepResult = (r: FirstStepResult) => {
    SecondStepResult(r.hits, r.ids) // complex implementation step
  }

  val step2Alternative2: FirstStepResult => SecondStepResult = (r: FirstStepResult) => {
    SecondStepResult(r.hits, r.ids) // complex implementation step
  }

  val pipeline = step1.andThen(step2Alternative1)

  val response: SecondStepResult = pipeline(Request("notebook", "relevance", 2))

}

case class Request(query: String, sort: String, pageNum: Int)

case class FirstStepResult(hits: Int, ids: List[Int])

case class SecondStepResult(hits: Int, ids: List[Int])
