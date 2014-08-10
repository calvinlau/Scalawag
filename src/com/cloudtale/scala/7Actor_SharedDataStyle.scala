package com.cloudtale.scala

import scala.actors.Actor._
import scala.actors._

/**
 * Created by Calvin Liu on 2014/8/9.
 */
object SharedDataStyle {

  case class Add(number: Int)

  case class GetResult(sender: Actor)

  class AddActor extends Actor {
    override def act(): Unit = process(0)

    def process(value: Int): Unit = {
      reactWithin(500) {
        case Add(number) => process(value + number)
        case GetResult(a) => a ! value; process(value)
        case _ => process(value)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val addActor = new AddActor
    addActor.start()
    addActor ! Add(1)
    addActor ! Add(2)
    addActor ! Add(3)
    addActor ! GetResult(self)
    receiveWithin(1000) {
      case result => println("Total is " + result)
    }
  }
}