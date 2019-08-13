val ZioVersion    = "1.0.0-RC11-1"
val Specs2Version = "4.7.0"
val PureConfig = "0.11.0"
val Http4sVersion = "0.20.9"
val CirceVersion = "0.11.1"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")
//resolvers += Resolver.

lazy val root = (project in file("."))
  .settings(
    organization := "Andrey Atapin",
    name := "song-link-bot",
    version := "0.0.1",
    scalaVersion := "2.12.8",
    maxErrors := 3,
    libraryDependencies ++= Seq(
      "dev.zio"    %% "zio"                   % ZioVersion,
      "dev.zio"    %% "zio-interop-cats"      % "2.0.0.0-RC2",
      "com.github.pureconfig" %% "pureconfig" % PureConfig,
      "org.http4s"      %% "http4s-blaze-server" % Http4sVersion,
      "org.http4s"      %% "http4s-blaze-client" % Http4sVersion,
      "org.http4s"      %% "http4s-circe"        % Http4sVersion,
      "org.http4s"      %% "http4s-dsl"          % Http4sVersion,
      "io.circe"        %% "circe-generic"       % CirceVersion,

      "eu.timepit"      %% "refined"             % "0.9.9",
      "eu.timepit"      %% "refined-cats"        % "0.9.9",

      "org.specs2" %% "specs2-core"       % Specs2Version % "test"
    )
  ) 

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-language:higherKinds",
  "-language:postfixOps",
  "-feature",
  "-Ypartial-unification"
  //"-Xfatal-warnings"
)

scalacOptions --= Seq("-Ywarn-dead-code")

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)
addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.10.3")
addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.0")

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("chk", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")
