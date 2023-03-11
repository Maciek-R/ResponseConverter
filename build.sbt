ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "2.13.10"

assembly / mainClass := Some("com.converter.Main")

lazy val root = (project in file("."))
  .settings(
    name := "ResponseConverter",
    assembly / mainClass := Some("com.converter.Main"),
    assembly / assemblyJarName := "ResponseConverter.jar",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
  )
