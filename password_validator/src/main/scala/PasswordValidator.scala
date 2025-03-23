import scala.io.StdIn

object PasswordValidator {
  def isValidPassword(password: String): Boolean = {
//    has at least one numeric digit
    val hasDigit = password.exists(_.isDigit)
//    has at least one small/capital letter
    val hasLower = password.exists(_.isLower)
    val hasUpper = password.exists(_.isUpper)
//    must not have space, quotation mark, slash, or an apostrophe
    val noInvalidChars = !password.exists(c => c == ' ' || c == '/' || c == '\"' || c == '\'')
//    has at least 8 characters (length)
    val minLength = password.length >= 8

//    password must align with the above requirements
    hasDigit && hasLower && hasUpper && noInvalidChars && minLength
  }


//   main function that takes an array of string arguments
  def main(args: Array[String]): Unit = { //    reads user's input as password
    val password = StdIn.readLine()
//    calls the function 'isvalidpassword' to check the validity of the password
    if (isValidPassword(password)) { //      if the password is valid print the below
      println("Password valid!")
    } else { //      if the password is not valid, print the below
      println("Invalid password, try again")
    }
  }
}