// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.7.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-play-ebean" % "5.0.2")

// Web plugins
// addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")
// addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.1.0")
// addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.3")
// addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.7")
addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.4")
// addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.0")
// addSbtPlugin("org.irundaia.sbt" % "sbt-sassify" % "1.4.2")


// Play enhancer - this automatically generates getters/setters for public fields
// and rewrites accessors of these fields to use the getters/setters. Remove this
// plugin if you prefer not to have this feature, or disable on a per project
// basis using disablePlugins(PlayEnhancer) in your build.sbt
addSbtPlugin("com.typesafe.sbt" % "sbt-play-enhancer" % "1.2.2")

// Play Ebean support, to enable, uncomment this line, and enable in your build.sbt using
// enablePlugins(PlayEbean).


addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")


//addSbtPlugin("com.etsy" % "sbt-checkstyle-plugin" % "3.1.1")
addSbtPlugin("org.xerial.sbt" % "sbt-jcheckstyle" % "0.2.1")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.9.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "1.0.0")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")

//for Java 9 support. javassist is dependency of plugin sbt-play-enhancer. But uses version 3.21.0-GA which does not support Java 9
dependencyOverrides += "org.javassist" % "javassist" % "3.23.1-GA"