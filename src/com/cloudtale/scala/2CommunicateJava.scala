package com.cloudtale.scala

import java.text.DateFormat.LONG
import java.text.DateFormat.getDateInstance
import java.util.Date
import java.util.Locale
object FrenchDate {
  def main(args: Array[String]) {
    val now = new Date
    val df = getDateInstance(LONG, Locale.CHINA)
    println(df format now)
  }
}