import sbt._

object Dependencies {

  object Version {
    val play = "2.3.7"
  }

  lazy val library1 = common ++ Seq(
    "net.sf.supercsv" % "super-csv" % "2.3.1"
  )

  lazy val library2 = common ++ library1 ++ Seq(
    "com.typesafe.play" %% "play-json" % Version.play
  )

  val common = Seq(
    "junit" % "junit" % "4.8.1" % "test"
  )

}
