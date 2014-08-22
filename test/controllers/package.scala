import play.api.test._
import play.api.test.Helpers._
import org.specs2.execute.AsResult

package object controllers {

  trait WithTestConfiguration extends WithApplication {
    val config = Map(
      "motion.mediaPath" -> "test/public/images/",
      "motion.lastImageName" -> "test.jpg"
    )

    override def around[T: AsResult](t: => T) = {
      running(FakeApplication(additionalConfiguration = config)) {
        AsResult(t)
      }
    }
  }
}
