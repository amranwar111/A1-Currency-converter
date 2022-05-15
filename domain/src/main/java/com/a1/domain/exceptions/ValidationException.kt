package com.a1.domain.exceptions

sealed class ValidationException: Exception(){
    object InValidPhoneException : ValidationException()
    object InValidNameException : ValidationException()
    object InValidPasswordException : ValidationException()
    object InValidEmailAddressException : ValidationException()
    object InValidVerificationCodeException : ValidationException()
}
