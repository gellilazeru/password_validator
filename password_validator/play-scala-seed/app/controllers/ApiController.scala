package controllers

import javax.inject.Inject
import play.api.mvc._

class ApiController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def hello = Action {
    Ok("Hello, World!")
  }
}
