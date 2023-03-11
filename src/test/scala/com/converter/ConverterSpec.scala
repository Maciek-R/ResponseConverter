package com.converter

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ConverterSpec extends AnyFlatSpec with Matchers{

  it should "TestClass" in {
    Converter.convert(TestClass("1", "2", "3").toString, Seq("TestClass")) shouldBe
      "TestClass(1,2,3)"
  }

  it should "TestClass with Nested Lists and when name of class is part of name of other class" in {
    Converter.convert(TestCla("1", List(TestC("qwe"),TestC("zxc")),"3").toString, Seq("TestCla", "TestC")) shouldBe
      "TestCla(1,List(" +
        "\nTestC(qwe), " +
        "\nTestC(zxc)),3)"
  }

  case class TestCla(a: String, testC: List[TestC], b: String)

  case class TestC(c: String)

  case class TestClass(a: String, b: String, c: String)
}
