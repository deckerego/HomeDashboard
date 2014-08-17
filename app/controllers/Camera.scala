package controllers

import akka.camel.Camel
import play.api.cache.Cache
import play.api._
import play.api.mvc._
import play.api.Play.current
import scala.io.Source

object Camera extends Controller {
  val lastImagePath = Play.current.configuration.getString("motion.lastImagePath")
  val camel: Camel = Cache.getAs[Camel]("camel").get

  def image = Action {
    val file = Source.fromFile(lastImagePath.get)(scala.io.Codec.ISO8859)
    val byteArray = file.map(_.toByte).toArray
    file.close()

    val template = camel.template
    template.sendBody("direct:talk", "Test Message")

    Ok(byteArray).as("image/jpeg")
  }
}