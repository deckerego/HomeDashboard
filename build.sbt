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
  ws,
  "com.pi4j" % "pi4j-core" % "0.0.5",
  "com.typesafe.akka" % "akka-camel_2.10" % "2.3.4" withSources(),
  "org.apache.camel" % "camel-scala" % "2.13.2" withSources(),
  "org.apache.camel" % "camel-xmpp" % "2.13.2"
)
