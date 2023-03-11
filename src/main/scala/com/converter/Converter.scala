package com.converter

import scala.util.Try

object Converter {

  def convert(text: String, nameOfClassesToSplit: Seq[String]) = {
    conv(new StringBuilder(), text, nameOfClassesToSplit.sortBy(-_.length)).result().substring(1)
  }

  private def conv(stringBuilder: StringBuilder, text: String, nameOfClassesToSplit: Seq[String], currentIndex: Int = 0): StringBuilder = {
    Try(nameOfClassesToSplit.map(nameOfClass => (text.indexOf(nameOfClass, currentIndex), nameOfClass))
      .filter(_._1 != -1)
      .minBy(_._1)).toOption match {
      case Some((minIndex, nameOfClass)) =>
        val toAdd = s"${text.substring(currentIndex, minIndex)}\n${nameOfClass}"
        conv(stringBuilder.append(toAdd), text, nameOfClassesToSplit, minIndex + nameOfClass.length)
      case None => stringBuilder.append(text.substring(currentIndex))
    }
  }
}
