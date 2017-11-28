package com.wolf.functional

import com.wolf.functional.pages.*
import grails.testing.mixin.integration.Integration
import grails.transaction.*

import geb.spock.*

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class TimelineFunctionalSpec extends GebSpec {
    def "Check that timeline loads for user 'phil'"() {
        when: "we load phil's timeline"
        to TimelinePage, "phil"



        then: "the page displays Phil's full name"
        whatHeading.text() == "Timeline for Phil Potts"
    }

    def "Submitting a new post"() {
        given: "I log in and start at my timeline page"
        login "frankie", "testing"
        to TimelinePage, "phil"

        when: "I enter a new message and post it"
        newPostContent.value("This is a test post from Geb")
        submitPostButton.click()

        then: "I see the new post in the timeline"
        waitFor { !posts("This is a test post from Geb").empty }
    }

    private login(String username, String password) {
        to LoginPage
        loginIdField = "loginId"
        passwordField = "password"
        signInButton.click()
    }
}
