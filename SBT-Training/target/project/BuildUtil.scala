import sbt._
import scala.util.Try

object BuildUtil extends Build {

  val jLogs = Seq(("org.slf4j", Some("slf4j-log4j12")), ("log4j", Some("log4j")), ("org.slf4j", Some("slf4j-simple")))
  val commonsLogging = Seq(("commons-logging", Some("commons-logging")))
  val javaxServlet = Seq(("javax.servlet", None))

  implicit class EnhancedModuleID(val m: ModuleID) extends AnyVal {

    /*
    * Accept the Seq of [Org, Option[Name]] where Org and Name are string that describe lib dependence.
    *
    * In case the Name is None then we `excludeAll` from passed organisation
    * In case the Name is Some then we `exclude` per org and name
    *
    * */
    def exclude(orgAndNames: Seq[(String, Option[String])]*) = orgAndNames.flatten.toSet.foldLeft(m) {
      (module, orgAndName) =>
        orgAndName._2.map {
          name => module.exclude(orgAndName._1, name)
        }.getOrElse(module.excludeAll(ExclusionRule(organization = orgAndName._1)))
    }
  }

  val VersionRegex = "([0-9]+.[0-9]+.[0-9]+)-?(.*)?".r

  /*
  * Creates a version string based on the tag description passed from sbt-git
  *
  * */
  def versionFromTag(version: Option[String]) = {
    version match {
      case Some(VersionRegex(v, "SNAPSHOT")) => s"$v-SNAPSHOT"
      case Some(VersionRegex(v, "")) => s"$v"
      case Some(VersionRegex(v, s)) => s"$v-$s-SNAPSHOT"
      case v => ""
    }
  }
}