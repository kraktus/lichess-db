inThisBuild(
  Seq(
    scalaVersion  := "3.6.4",
    versionScheme := Some("early-semver"),
    version       := "2.0",
    run / javaOptions += "-Dconfig.override_with_env_vars=true"
  )
)
lazy val app = project
  .in(file("."))
  .settings(
    name         := "lichess-db",
    organization := "org.lichess",
    scalacOptions -= "-Xfatal-warnings",
    scalacOptions ++= Seq(
      "-source:future",
      "-rewrite",
      "-new-syntax",
      "-explain",
      "-Wunused:all",
      "-release:21"
    ),
    resolvers ++= Seq("lila-maven".at("https://raw.githubusercontent.com/lichess-org/lila-maven/master")),
    libraryDependencies ++= Seq(
      "org.reactivemongo" %% "reactivemongo"            % "1.1.0-RC13",
      "org.reactivemongo" %% "reactivemongo-akkastream" % "1.1.0-RC13",
      "org.lichess"       %% "scalalib-core"            % "11.7.0",
      "org.lichess"       %% "scalachess"               % "17.3.2",
      "com.typesafe.akka" %% "akka-actor"               % "2.6.21",
      "com.typesafe.akka" %% "akka-stream"              % "2.6.21",
      "com.typesafe.akka" %% "akka-slf4j"               % "2.6.21",
      "org.playframework" %% "play-json"                % "3.0.4",
      "org.lichess"       %% "compression"              % "1.10",
      "org.slf4j"          % "slf4j-nop"                % "1.7.36"
      // "ch.qos.logback"      % "logback-classic"          % "1.4.14"
    )
  )
