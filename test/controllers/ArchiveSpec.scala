package controllers

import play.api.test._
import play.api.mvc._
import scala.concurrent.Future

object ArchiveSpec extends PlaySpecification with Results {

  "Archive" should {
    "list all media" in new WithTestConfiguration {
      val result: Future[Result] = Archive.index().apply(FakeRequest(GET, "/archive"))

      status(result) must equalTo(OK)
      contentAsString(result) must be contain "test.jpg"
    }

    "fetch an image" in new WithTestConfiguration {
      val result: Future[Result] = Archive.at("test.jpg").apply(FakeRequest(GET, "/media/test.jpg"))

      status(result) must equalTo(OK)
      headers(result).get("Content-Type").get must be equalTo "image/jpeg"
    }
  }
}
