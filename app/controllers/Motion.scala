package controllers

import play.api.mvc._
import routebuilder.CamelSystem

object Motion extends Controller {

  def motionDetected = Action {
    val template = CamelSystem.camel.template
    template.sendBody("direct:talk", "Motion detected")
    Ok("{\"success\": \"true\"}")
  }
}
