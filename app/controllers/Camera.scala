package controllers

import play.api._
import play.api.mvc._
import scala.io.Source

object Camera extends Controller {
  val lastImagePath = Play.current.configuration.getString("motion.lastImagePath")

  def image = Action {
    val file = Source.fromFile(lastImagePath.get)(scala.io.Codec.ISO8859)
    val byteArray = file.map(_.toByte).toArray
    file.close()

    Ok(byteArray).as("image/jpeg")
  }

}