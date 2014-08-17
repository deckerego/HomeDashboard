import akka.actor.ActorSystem
import akka.camel.{Camel, CamelExtension}
import play.api._
import play.api.cache.Cache
import play.api.Play.current

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    loadRoutes
  }

  def loadRoutes: Unit = {
    Logger.debug("Starting Camel...")
    val camel = CamelExtension(ActorSystem("camel-system"))
    Cache.set("camel", camel)

    Logger.info("Loading Camel routes...")
    camel.context.addRoutes(new routebuilder.DefaultRouteBuilder)
    Logger.debug(camel.context.getRoutes.toString)
  }
}