import sbt.Keys._
import sbt._
import sbtassembly.{MergeStrategy, PathList}

name := "OnlyForAssembly"

version := "1.0"

scalaVersion := "2.10.5"


javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

// protocol buffer support
//seq(sbtprotobuf.ProtobufPlugin.protobufSettings: _*)

// additional libraries
libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.0",
  "org.apache.spark" %% "spark-core" % "1.6.0" % "provided",
  "org.apache.spark" %% "spark-sql" % "1.6.0",
  "org.apache.spark" %% "spark-hive" % "1.6.0",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "org.apache.hadoop" % "hadoop-hdfs" % "2.6.0-cdh5.9.0" % "test",
  "org.apache.hadoop" % "hadoop-common" % "2.6.0-cdh5.9.0" % "test",
  "org.apache.hadoop" % "hadoop-minicluster" % "2.6.0-cdh5.9.0" % "test",
  "org.mockito" % "mockito-all" % "1.9.5" % "test",
  "org.apache.kafka" % "kafka-clients" % "0.8.2-beta",
  "org.scalacheck" % "scalacheck_2.11" % "1.11.5" % "test"

)

resolvers ++= Seq(
  "JBoss Repository" at "http://repository.jboss.org/nexus/content/repositories/releases/",
  "Spray Repository" at "http://repo.spray.cc/",
  "Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Twitter4J Repository" at "http://twitter4j.org/maven2/",
  "Apache HBase" at "https://repository.apache.org/content/repositories/releases",
  "Twitter Maven Repo" at "http://maven.twttr.com/",
  "scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Second Typesafe repo" at "http://repo.typesafe.com/typesafe/maven-releases/",
  "Mesosphere Public Repository" at "http://downloads.mesosphere.io/maven",
  Resolver.sonatypeRepo("public")
)
mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
{
  case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
  case m if m.startsWith("META-INF") => MergeStrategy.discard
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.first
  case PathList("org", "apache", xs @ _*) => MergeStrategy.first
  case PathList("org", "jboss", xs @ _*) => MergeStrategy.first
  case "about.html"  => MergeStrategy.rename
  case "reference.conf" => MergeStrategy.concat
  case _ => MergeStrategy.first
}
}
