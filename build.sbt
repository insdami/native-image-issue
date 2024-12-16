import Dependencies._

ThisBuild / scalaVersion     := "2.13.15"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "native-image-issue",
    libraryDependencies ++= Seq(`decline-effect`, `circe-generic-extras`, `circe-parser`),
    Compile / mainClass   := Some("example.Main"),
    nativeImageVersion    := "23.0.1",
    nativeImageJvm        := "graalvm-java23",
    nativeImageAgentMerge := true,
    nativeImageOptions ++= List(
      "--verbose",
      "--no-fallback",
      "--report-unsupported-elements-at-runtime",
      "--allow-incomplete-classpath",
      "--install-exit-handlers",
      "-H:+ReportExceptionStackTraces"
    )
  )
  .enablePlugins(NativeImagePlugin)
