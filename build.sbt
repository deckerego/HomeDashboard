name := """GarageSecurity"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)
