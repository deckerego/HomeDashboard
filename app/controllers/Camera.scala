package controllers

import play.api._
import play.api.mvc._
import play.api.Play.current
import scala.io.Source

object Camera extends Controller {
  val mediaPath = Play.configuration.getString("motion.mediaPath")
  val lastImagePath = mediaPath.getOrElse("") + Play.configuration.getString("motion.lastImageName").get

  def image = Action {
    val file = Source.fromFile(lastImagePath)(scala.io.Codec.ISO8859)
    val byteArray = file.map(_.toByte).toArray
    file.close()

    Ok(byteArray).as("image/jpeg")
  }
}