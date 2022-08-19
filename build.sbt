name := """ebean-enhancer-issue-8"""

organization := "es.danpintas"
version := "1.0-SNAPSHOT"
scalaVersion := "2.12.9"

logLevel := Level.Debug

EclipseKeys.projectFlavor := EclipseProjectFlavor.ScalaIDE
EclipseKeys.createSrc := EclipseCreateSrc.ManagedClasses + EclipseCreateSrc.ManagedResources
EclipseKeys.preTasks := Seq(compile in Compile)

lazy val business = project in file("modules/business")

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean, SbtWeb)
  .dependsOn(business)
  .aggregate(business)

libraryDependencies ++= Seq(
  javaJdbc,
  evolutions,
  cacheApi,
  javaWs,
  guice,
  "junit" % "junit" % "4.13.2" % "test"
)

resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("snapshots")
)

logLevel := Level.Info

javacOptions ++= Seq("-source", "11", "-target", "11")
javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:cast")
javacOptions ++= Seq("-Xlint:-options")
scalacOptions ++= Seq("-target:jvm-1.8")

pipelineStages := Seq(digest)
updateOptions := updateOptions.value.withCachedResolution(true)

fork in Test := false
