package com.cloudtale.scala

trait Ord {
    def < (that: Any): Boolean
    def <=(that: Any): Boolean = (this < that) || (this == that)
    def > (that: Any): Boolean = !(this <= that)
    def >=(that: Any): Boolean = !(this < that)
}

class OrdDate(y: Int, m: Int, d: Int) extends Ord {
    def year = y
    def month = m
    def day = d
    override def toString(): String = year + "-" + month + "-" + day

	override def equals(that: Any): Boolean =
	that.isInstanceOf[OrdDate] && {
	      val o = that.asInstanceOf[OrdDate]
	      o.day == day && o.month == month && o.year == year
	}

}
