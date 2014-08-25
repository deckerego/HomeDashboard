package controllers

import routebuilder.CamelSystem
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.component.mock.MockEndpoint
import play.api.test._
import play.api.mvc._
import scala.concurrent.Future

object MotionSpec extends PlaySpecification with Results {

  "Motion" should {
    "send a Jabber message" in new WithTestConfiguration {
      val camel = CamelSystem.camel
      camel.context.addRoutes(new MotionSpecRouteBuilder)

      val mockEndpoint: MockEndpoint = camel.context.getEndpoint("mock:xmpp", classOf[MockEndpoint])
      mockEndpoint.expectedMessageCount(1)

      val result: Future[Result] = Motion.motionDetected().apply(FakeRequest(PUT, "/motion/area_detected"))

      status(result) must equalTo(OK)
      MockEndpoint.assertIsSatisfied(camel.context)
    }
  }
}

class MotionSpecRouteBuilder extends RouteBuilder {
  def configure {
    from("direct:talk").
      to("mock:xmpp")
  }
}
