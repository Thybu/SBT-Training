logLevel := Level.Warn

//resolvers += Resolver.url("sbt-plugin-releases-scalasbt", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))
resolvers += Resolver.url("bintray-sbt-plugins", url("http://dl.bintray.com/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)


//addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.0.0")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.3")




addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.9.3")


addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.7.0")