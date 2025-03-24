package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

case class PasswordRequest(password: String)

object PasswordRequest {
  // Implicit JSON formatter to convert the PasswordRequest to/from JSON
  implicit val passwordRequestFormat: OFormat[PasswordRequest] = Json.format[PasswordRequest]
}

@Singleton
class ApiController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def isValidPassword(password: String): Boolean = {
    val hasDigit = password.exists(_.isDigit)
    val hasLower = password.exists(_.isLower)
    val hasUpper = password.exists(_.isUpper)
    val noInvalidChars = !password.exists(c => c == ' ' || c == '/' || c == '\"' || c == '\'')
    val minLength = password.length >= 8

    println(s"Password: $password")
    println(s"Has digit: $hasDigit, Has lowercase: $hasLower, Has uppercase: $hasUpper, Valid chars: $noInvalidChars, Min length: $minLength")

    hasDigit && hasLower && hasUpper && noInvalidChars && minLength
  }

  def validatePassword = Action(parse.json) { request =>
    request.body.validate[PasswordRequest].map { passwordRequest =>
      val password = passwordRequest.password
      if (isValidPassword(password)) {
        Ok(Json.obj("message" -> "Password is valid"))
      } else {
        BadRequest(Json.obj("message" -> "Password is invalid"))
      }
    }.getOrElse {
      // Invalid JSON format in the request body
      BadRequest(Json.obj("message" -> "Invalid request format"))
    }
  }
}
