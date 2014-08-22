package controllers

import play.api.test._
import play.api.mvc._
import scala.concurrent.Future

object ApplicationSpec extends PlaySpecification with Results {

  "Application" should {
    "render the index page" in new WithTestConfiguration {
      val result = Application.index().apply(FakeRequest(GET, "/"))

      status(result) must equalTo(OK)
      headers(result).get("Content-Type").get must be contain "text/html"
    }
  }
}
