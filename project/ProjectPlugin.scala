import de.heikoseeberger.sbtheader.{AutomateHeaderPlugin, FileType, HeaderPlugin}
import de.heikoseeberger.sbtheader.AutomateHeaderPlugin.autoImport._
import de.heikoseeberger.sbtheader.HeaderPlugin.autoImport._
import sbt._
import sbt.Keys._

object ProjectPlugin extends AutoPlugin {

  override def requires: Plugins =
      HeaderPlugin && AutomateHeaderPlugin

  override val projectSettings = Seq(
    startYear := Some(2017),
    organizationName := "Ferhat Aydin",
    licenses :=  Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    headerLicense := Some(
      HeaderLicense.Custom(
        """|Copyright: 2017 https://github.com/ferhtaydn/sack/graphs
             |License: http://www.apache.org/licenses/LICENSE-2.0
             |""".stripMargin
        )
      ),
      headerMappings :=
        headerMappings.value ++
          Map(
            FileType("sbt") -> HeaderCommentStyle.CppStyleLineComment,
            HeaderFileType.java -> HeaderCommentStyle.CppStyleLineComment,
            HeaderFileType.scala -> HeaderCommentStyle.CppStyleLineComment
          )
    ) ++ Defaults.itSettings ++
      headerSettings(IntegrationTest) ++
      automateHeaderSettings(IntegrationTest)
}
