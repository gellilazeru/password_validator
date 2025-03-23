ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.8"  // Compatible with Play 2.8.x

lazy val root = (project in file("."))
  .settings(
    name := "password_validator",

    // Add Play dependencies
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play" % "2.8.8",  // Play 2.8.7 for Scala 2.13.x
      "com.typesafe.play" %% "play-guice" % "2.8.8"  // Optional, for dependency injection
    ),

    // Add Play sbt plugin
    addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.8"),

    // Add repositories (Maven Central and JCenter)
    resolvers ++= Seq(
      Resolver.mavenCentral,
      Resolver.jcenterRepo
    )
  )
