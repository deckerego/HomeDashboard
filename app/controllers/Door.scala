package controllers

import play.api._
import play.api.mvc._

object Door extends Controller {

  def open(id: Int) = Action {
    Ok(views.html.index())
  }

}