package com.converter

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    val classNames = Source.fromFile("params.txt").getLines().toList
    val result = Converter.convert(Source.fromFile("response.txt").getLines().mkString, classNames)

    Files.write(Paths.get("output.txt"), result.getBytes(StandardCharsets.UTF_8))
  }
}
