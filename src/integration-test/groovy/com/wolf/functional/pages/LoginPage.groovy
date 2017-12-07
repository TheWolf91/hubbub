package com.wolf.functional.pages
import geb.Page

class LoginPage extends Page {
    static url = "login/form"

    static content = {
        loginIdField { $("input[name='username']") }
        passwordField { $("input[name='password']") }
        signInButton { $("input[type='submit']") }
    }

    static at = {
        title.contains("Sign into Hubbub")
    }
}