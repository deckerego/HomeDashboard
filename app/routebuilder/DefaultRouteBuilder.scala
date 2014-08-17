package routebuilder

import org.apache.camel.{Exchange, Processor}
import org.apache.camel.builder.RouteBuilder
import com.typesafe.config.ConfigFactory

class DefaultRouteBuilder extends RouteBuilder {
  val conf = ConfigFactory.load();
  val xmppConf = conf.getConfig("xmpp")

  def configure {
    from("direct:talk").
      to(s"xmpp://${xmppConf.getString("server")}:${xmppConf.getInt("port")}/${xmppConf.getString("recipient")}?serviceName=${xmppConf.getString("name")}&user=${xmppConf.getString("username")}&password=${xmppConf.getString("password")}")
  }
}
