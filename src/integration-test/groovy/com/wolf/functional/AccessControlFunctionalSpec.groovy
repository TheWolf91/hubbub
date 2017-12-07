package com.wolf.functional

import com.wolf.functional.pages.GlobalTimelinePage
import com.wolf.functional.pages.LoginPage
import com.wolf.functional.pages.TimelinePage
import grails.testing.mixin.integration.Integration
import grails.transaction.*

import geb.spock.*

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class AccessControlFunctionalSpec extends GebSpec {
    void "Anonymous access to home page"() {
        expect: "Unauthenticated user can access global timeline"
        to GlobalTimelinePage
    }

    void "Anonymous access to restricted page"() {
        when: "Unauthenticated user accesses a user's timeline page"
        via TimelinePage, "phil"
        then: "the user is redirected to the login page"
        at LoginPage
        when: "the user logs in"
        login "frankie", "testing"
        then: "he or she can access the timeline page"
        to TimelinePage, "phil"
    }
    private login(String username, String password) {
        to LoginPage
        loginIdField = username
        passwordField = password
        signInButton.click()
    }
}
