name := """pydgn"""
organization := "com.pygdn"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies ++= Seq(
    "org.mongodb" % "mongodb-driver" % "3.0.4"
)
