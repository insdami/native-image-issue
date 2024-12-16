import sbt._

object Version {
  val `circe-extras`   = "0.14.4"
  val circe   = "0.14.10"
  val decline = "2.4.1"
}

object Dependencies {
  lazy val `circe-generic-extras` = "io.circe"     %% "circe-generic-extras" % Version.`circe-extras`
  lazy val `circe-parser`         = "io.circe"     %% "circe-parser"         % Version.circe
  lazy val `decline-effect`       = "com.monovore" %% "decline-effect"       % Version.decline
}
