import Dependencies._

lazy val root = (project in file("."))
  .enablePlugins(ProjectPlugin)
  .configs(IntegrationTest)
  .settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % "test,it"
  )