organization := "com.scvh.apps"

name := "Coffeefuck"

version := "1.0"

scalaVersion := "2.11.11"

exportJars := true

mainClass := Some("com.scvh.apps.CoffeeFuckApplication")

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-target:jvm-1.8",
  "-unchecked",
  "-Ywarn-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Xlint"
)

scalacOptions in(Compile, doc) ++= baseDirectory.map {
  (bd: File) =>
    Seq[String](
      "-sourcepath", bd.getAbsolutePath,
      "-doc-source-url", "https://github.com/mslinn/{name.value}/tree/master€{FILE_PATH}.scala"
    )
}.value

javacOptions ++= Seq(
  "-Xlint:deprecation",
  "-Xlint:unchecked",
  "-source", "1.8",
  "-target", "1.8",
  "-g:vars"
)

resolvers ++= Seq(
)

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter" % "1.5.4.RELEASE" withSources(),
  "org.springframework.boot" % "spring-boot-starter-aop" % "1.5.4.RELEASE" withSources(),
  "org.springframework.boot" % "spring-boot-starter-cache" % "1.5.4.RELEASE" withSources(),
  "org.springframework.boot" % "spring-boot-starter-mobile" % "1.5.4.RELEASE" withSources(),
  "org.springframework.retry" % "spring-retry" % "1.2.1.RELEASE" withSources(),
  "org.springframework.boot" % "spring-boot-starter-thymeleaf" % "1.5.4.RELEASE" withSources(),
  "org.springframework.boot" % "spring-boot-starter-validation" % "1.5.4.RELEASE" withSources(),
  "org.springframework.boot" % "spring-boot-starter-web" % "1.5.4.RELEASE" withSources(),
  "org.springframework.boot" % "spring-boot-starter-websocket" % "1.5.4.RELEASE" withSources(),
  "org.springframework.boot" % "spring-boot-configuration-processor" % "1.5.4.RELEASE" withSources(),
  "org.springframework.boot" % "spring-boot-starter-test" % "1.5.4.RELEASE" % "test" withSources(),
  "org.scalatest" % "scalatest_2.11" % "3.0.3" % "test" withJavadoc() withSources(),
  "org.apache.commons" % "commons-text" % "1.1" withJavadoc() withSources(),
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.9" withJavadoc() withSources(),
  "org.scalatest" %% "scalatest" % "3.0.3" % Test withJavadoc() withSources(),
  "junit" % "junit" % "4.12" % Test
)

logLevel := Level.Warn

// Only show warnings and errors on the screen for compilations.
// This applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Warn

// Level.INFO is needed to see detailed output when running tests
logLevel in test := Level.Info

// define the statements initially evaluated when entering 'console', 'console-quick', but not 'console-project'
initialCommands in console :=
  """
    |""".stripMargin

cancelable := true