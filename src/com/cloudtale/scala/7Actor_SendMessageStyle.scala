package com.cloudtale.scala

import scala.actors.Actor._
import scala.actors._

/**
 * Created by Calvin Liu on 2014/8/9.
 */
object SendMessageStyle {

  def main(args: Array[String]): Unit = {
    val caller = self
    val accumulator = actor {
      var continue = true
      var sum = 0
      loopWhile(continue) {
        reactWithin(500) {
          case number: Int => sum += number
          case TIMEOUT =>
            continue = false
            caller ! sum
        }
      }
    }
    accumulator ! 1
    accumulator ! 2
    accumulator ! 3
    receiveWithin(1000) {
      case result => println("Total is " + result)
    }
  }
}