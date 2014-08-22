package controllers

import play.api.test._
import play.api.mvc._
import scala.concurrent.Future

object CameraSpec extends PlaySpecification with Results {

  "Camera" should {
    "fetch an image" in new WithTestConfiguration {
      val result: Future[Result] = Camera.image().apply(FakeRequest(GET, "/camera/image"))

      headers(result).get("Content-Type").get must be equalTo "image/jpeg"
      status(result) must be equalTo(OK)
    }
  }
}
