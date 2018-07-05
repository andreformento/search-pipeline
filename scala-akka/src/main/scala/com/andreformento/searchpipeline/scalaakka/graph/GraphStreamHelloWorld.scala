package com.andreformento.searchpipeline.scalaakka.graph


import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.scaladsl.{Broadcast, Flow, GraphDSL, Keep, Merge, RunnableGraph, Sink, Source}
import akka.stream.{ActorMaterializer, ClosedShape}

import scala.concurrent.{Await, Future}

// https://doc.akka.io/docs/akka/current/stream/stream-graphs.html
object GraphStreamHelloWorld extends App {

  implicit val system = ActorSystem("simple-streams")

  // Transforming and consuming simple streams
  implicit val materializer = ActorMaterializer()

  val g = RunnableGraph.fromGraph(GraphDSL.create() { implicit builder: GraphDSL.Builder[NotUsed] =>
    import GraphDSL.Implicits._
    val in = Source(1 to 1)
    val out = Sink.ignore

    val bcast = builder.add(Broadcast[Int](2))
    val merge = builder.add(Merge[Int](2))

    val fA = Flow[Int].map(f => {
      val result = f + 1
      println(s"fA($f) -> $result")
      result
    })
    val fB = Flow[Int].map(f => {
      val result = f + 2
      println(s"fB($f) -> $result")
      result
    })
    val fC = Flow[Int].map(f => {
      val result = f + 3
      println(s"fC($f) -> $result")
      result
    })
    val fD = Flow[Int].map(f => {
      val result = f + 4
      println(s"fD($f) -> $result")
      result
    })

    in ~> fA ~> bcast ~> fB ~> merge ~> fC ~> out
    bcast ~> fD ~> merge

    println("end")

    ClosedShape
  })

  g.run()

  /*
    end
    fA(1) -> 2
    fB(2) -> 4
    fC(4) -> 7
    fD(2) -> 6
    fC(6) -> 9
  * */

}


object GraphStreamFlow extends App {
  val topHeadSink = Sink.head[Int]
  val bottomHeadSink = Sink.head[Int]
  val sharedDoubler = Flow[Int].map(_ * 2)

  val f = RunnableGraph.fromGraph(GraphDSL.create(topHeadSink, bottomHeadSink)((_, _)) { implicit builder =>
    (topHS, bottomHS) =>
      import GraphDSL.Implicits._
      val broadcast = builder.add(Broadcast[Int](2))
      Source.single(1) ~> broadcast.in

      broadcast ~> sharedDoubler ~> topHS.in
      broadcast ~> sharedDoubler ~> bottomHS.in
      ClosedShape
  })

}

// https://gist.github.com/tonymurphy/ec375d10da15d8dac882
object ApplicationMain extends App {

  implicit val system = ActorSystem("simple-streams")

  // Transforming and consuming simple streams
  implicit val materializer = ActorMaterializer()

  val source = Source(1 to 10)
  val sink = Sink.fold[Int,Int](0)(_+_)
  val runnable: RunnableGraph[Future[Int]] = source.toMat(sink)(Keep.right)

  val sum: Future[Int] = runnable.run()
  import scala.concurrent.duration._
  val result:Int = Await.result(sum, 4 seconds).asInstanceOf[Int]

  println(s"result $result")

}

//class GraphStreamShow extends App {
//
//  implicit val system = ActorSystem("simple-streams")
//
//  // Transforming and consuming simple streams
//  implicit val materializer = ActorMaterializer()
//
//  val sinks = List("a", "b", "c").map(prefix ⇒
//    Flow[String].filter(str ⇒ str.startsWith(prefix)).toMat(Sink.head[String])(Keep.right)
//  )
//
//  val g: RunnableGraph[Seq[Future[String]]] = RunnableGraph.fromGraph(GraphDSL.create(sinks) { implicit b ⇒
//    sinkList ⇒
//      val broadcast = b.add(Broadcast[String](sinkList.size))
//
//      Source(List("ax", "bx", "cx")) ~> broadcast
//      sinkList.foreach(sink ⇒ broadcast ~> sink)
//
//      ClosedShape
//  })
//
//  val matList: Seq[Future[String]] = g.run()
//
//}
