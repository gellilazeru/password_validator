import scala.io.StdIn

object PasswordValidator {
  def isValidPassword(password: String): Boolean = {
    val hasDigit = password.exists(_.isDigit)
    val hasLower = password.exists(_.isLower)
    val hasUpper = password.exists(_.isUpper)
    val noInvalidChars = !password.exists(c => c == ' ' || c == '/' || c == '\"' || c == '\'')
    val minLength = password.length >= 8

    hasDigit && hasLower && hasUpper && noInvalidChars && minLength
  }

  def main(args: Array[String]): Unit = {
    val password = StdIn.readLine()
    if (isValidPassword(password)) {
      println("password valid")
    } else {
      println("Invalid password, try again")
    }
  }
}