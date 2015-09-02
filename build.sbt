// TODO Set your organization here
// organization in ThisBuild := "your.organization"

name in ThisBuild := "activator-prj-base"

version in ThisBuild := "1.0"

scalaVersion in ThisBuild := "2.11.7"

lazy val library1 = (project in file("library1"))
    .settings(
        name := "library1",
        libraryDependencies ++= Dependencies.library1
        // how to add a resolver: resolvers += "Stanford" at "http://www-nlp.stanford.edu/repo"
    )

lazy val library2 = (project in file("library2"))
    // for the play framework: .enablePlugins(PlayScala)
    .settings(
        name := "library2",
        libraryDependencies ++= Dependencies.library2  // also for play framework: ++ Seq(filters, cache)
        // also for the play framework: pipelineStages := Seq(digest, gzip)
    ).dependsOn(library1).aggregate(library1)

//
// Scala Compiler Options
//
scalacOptions in ThisBuild ++= Seq(
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-deprecation", // warning and location for usages of deprecated APIs
  "-feature", // warning and location for usages of features that should be imported explicitly
  "-unchecked", // additional warnings where generated code depends on assumptions
  "-Xlint", // recommended additional warnings
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver
//  "-Ywarn-value-discard", // Warn when non-Unit expression results are unused
  "-Ywarn-inaccessible",
  "-Ywarn-dead-code"
)

EclipseKeys.skipParents in ThisBuild := false

EclipseKeys.withSource in ThisBuild := true
