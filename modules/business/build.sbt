name := """business"""

EclipseKeys.projectFlavor := EclipseProjectFlavor.ScalaIDE
EclipseKeys.createSrc := EclipseCreateSrc.ManagedClasses + EclipseCreateSrc.ManagedResources
EclipseKeys.preTasks := Seq(compile in Compile)

organization := "es.danpintas"
version := "1.0-SNAPSHOT"
scalaVersion := "2.12.9"

logLevel := Level.Info

// ######### javacOptions #########
javacOptions ++= Seq("-source", "11", "-target", "11")
javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:cast")
javacOptions ++= Seq("-Xlint:-options")
scalacOptions ++= Seq("-target:jvm-1.8")

javaSource in Compile := baseDirectory.value / "src/main/java"
javaSource in Test := baseDirectory.value / "test"
resourceDirectory in Test := baseDirectory.value / "test/resources"

lazy val business = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

libraryDependencies ++= Seq(
  javaJdbc,
  evolutions,
  javaWs,
  cacheApi,
  guice,

  "mysql" % "mysql-connector-java" % "5.1.49",
  "org.liquibase" % "liquibase-core" % "4.6.2",
  "javax.mail" % "javax.mail-api" % "1.6.2",
  "com.sun.mail" % "javax.mail" % "1.6.2",
  "it.innove" % "play2-pdf" % "1.9.1", // from version 1.10 on, it requires _2.13 scala suffix
  "org.apache.pdfbox" % "pdfbox" % "2.0.26",
  "com.amazonaws" % "aws-java-sdk-sqs" % "1.12.+",// sdk v1

  "junit" % "junit" % "4.13.2" % "test",
  "org.hamcrest" % "hamcrest-all" % "1.3" % "test",
  //"org.mockito" % "mockito-core" % "2.28.2" % "test",
  "org.mockito" % "mockito-core" % "2.23.4" % "test",
  "com.h2database" % "h2" % "1.4.200" % "test",
  // "org.avaje" % "avaje-agentloader" % "2.1.2" % "test",
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.5.23" % "test", // Play 2.7.3 uses Akka 2.5.23

  "org.mariuszgromada.math" % "MathParser.org-mXparser" % "4.4.2",
  "net.coobird" % "thumbnailator" % "0.4.15",
  "com.jcraft" % "jsch" % "0.1.55",
  "org.jsoup" % "jsoup" % "1.14.+", // take latest
  "commons-io" % "commons-io" % "2.11.+", // take latest
  "commons-codec" % "commons-codec" % "1.15",

  "org.apache.httpcomponents" % "httpclient" % "4.5.13",
  "org.apache.commons" % "commons-collections4" % "4.4",
  "org.apache.commons" % "commons-lang3" % "3.12.+", // take latest
  "org.apache.commons" % "commons-compress" % "1.21",
  "com.google.code.gson" % "gson" % "2.8.+", // take latest
  "com.jayway.jsonpath" % "json-path" % "2.6.+", // take latest

  "org.apache.xmlgraphics" % "batik-transcoder" % "1.14",
  "org.apache.xmlgraphics" % "batik-codec" % "1.14", // see https://stackoverflow.com/questions/45239099/apache-batik-no-writeadapter-is-available

  // since Java 9 the JAXB modules are not in classpath any more and since
  // java 11 they are removed from JDK, so even "--add-modules" would not work. See:
  // https://stackoverflow.com/questions/48204141/replacements-for-deprecated-jpms-modules-with-java-ee-apis/48279048#48279048
  "javax.xml.bind" % "jaxb-api" % "2.3.1",
  "com.sun.xml.bind" % "jaxb-core" % "2.3.0.1",
  "com.sun.xml.bind" % "jaxb-impl" % "2.3.1"
)
// due to https://github.com/FasterXML/jackson-databind/issues/1723
dependencyOverrides ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.13.1", // take latest
  "com.fasterxml.jackson.core" % "jackson-core" % "2.13.1", // take latest
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.13.1", // take latest

  //fight warnings: "here may be incompatibilities among your library dependencies; run 'evicted' to see detailed eviction warnings."

  "org.scala-lang" % "scala-library" % scalaVersion.value, // lots of "com.typesafe.play:..." used old 2.13.3
  "org.apache.logging.log4j" % "log4j-api" % "2.17.0") // "org.scala-sbt.temp:temp-resolve-..."  used old 3.1

playEbeanModels in Test := Seq("es.danpintas.**")
