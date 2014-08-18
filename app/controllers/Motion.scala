package controllers

import akka.camel.Camel
import play.api.Play.current
import play.api.cache.Cache
import play.api.mvc._

object Motion extends Controller {
  val camel: Camel = Cache.getAs[Camel]("camel").get

  def motionDetected = Action {
    val template = camel.template
    template.sendBody("direct:talk", "Motion detected")
    Ok("{\"success\": \"true\"}")
  }
}
