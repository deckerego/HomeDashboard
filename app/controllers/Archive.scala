package controllers

import play.api.Play.current
import play.api._
import play.api.mvc._
import java.io.File
import scala.io.Source

object Archive extends Controller {
  val mediaPath = Play.configuration.getString("motion.mediaPath").getOrElse("")

  def index = Action {
    val files = new File(mediaPath).listFiles
    val fileList = files.map(_.getName())

    Ok(views.html.archive(fileList))
  }

  def at(fileName: String) = Action {
    val file = Source.fromFile(mediaPath + fileName)(scala.io.Codec.ISO8859)
    val byteArray = file.map(_.toByte).toArray
    file.close()

    val contentType = fileName match {
      case name if name.endsWith(".jpg") => "image/jpeg"
      case name if name.endsWith(".avi") => "video/avi"
      case _ => "application/octet-stream"
    }

    Ok(byteArray).as(contentType)
  }
}
