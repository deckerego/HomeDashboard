import com.typesafe.sbt.packager.archetypes.ServerLoader.{SystemV, Upstart}
import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

name := """GarageSecurity"""

version := "3.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.10.2"

maintainer in Linux := "John Smith <john.smith@example.com>"

packageSummary in Linux := "A small package summary"

packageDescription := "A longer description of your application"

serverLoading in Debian := SystemV

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)
