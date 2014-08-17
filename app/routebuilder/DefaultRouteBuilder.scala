package routebuilder

import org.apache.camel.{Exchange, Processor}
import org.apache.camel.builder.RouteBuilder

class DefaultRouteBuilder extends RouteBuilder {
  def configure {
    from("direct:talk").to("xmpp://talk.google.com:5222/")
  }
}
