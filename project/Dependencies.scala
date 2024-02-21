import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "webdriver-factory" % "0.46.0"  % Test,
    "org.scalatest"       %% "scalatest"         % "3.2.17"   % Test,
    "org.scalatestplus"   %% "selenium-4-12"     % "3.2.17.0" % Test,
    "com.vladsch.flexmark" % "flexmark-all"      % "0.62.2" % Test,
    "com.typesafe"         % "config"            % "1.4.2"   % Test,
    "uk.gov.hmrc"         %% "domain-play-30"    % "9.0.0"
  )
}
