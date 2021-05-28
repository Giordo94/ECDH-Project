lazy val root = (project in file("."))
  .settings(
    name := "ProjectECDH",
    version := "0.1",
    scalaVersion := "2.13.2",
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    libraryDependencies ++= Seq(
      "junit" % "junit" % "4.12" % Test,
      "com.novocode" % "junit-interface" % "0.11" % Test,
      "org.scalatest" %% "scalatest" % "3.1.1" % "test"
    ),
    crossPaths := false, // https://github.com/sbt/junit-interface/issues/35
    //logBuffered in Test := false,
    Test / parallelExecution := false
  )