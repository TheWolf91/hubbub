package com.wolf.pages
import geb.Page

class LoginPage extends Page {
    static url = "login/form"

    static content = {
        loginIdField { $("input[name='loginId']") }
        passwordField { $("input[name='password']") }
        signInButton { $("input[type='submit']") }
    }

    static at = {
        title.contains("Sign into Hubbub")
    }
}