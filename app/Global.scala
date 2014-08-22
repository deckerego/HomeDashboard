import play.api._
import routebuilder.CamelSystem

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    loadRoutes
  }

  def loadRoutes: Unit = {
    Logger.debug("Starting Camel...")
    CamelSystem.camel.context.addRoutes(new routebuilder.DefaultRouteBuilder)
    Logger.debug(CamelSystem.camel.context.getRoutes.toString)
  }
}