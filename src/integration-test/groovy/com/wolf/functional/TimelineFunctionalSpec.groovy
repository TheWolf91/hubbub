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
    def "Does timeline load for user 'phil'"() {
        when:
        login "frankie", "testing"
        go "users/phil"

        then:
        $("#bd h1").text() == "Timeline for Phil Potts"
    }

    def "Submitting a new post"() {
        given: "I log in and start at my timeline page"
        login "frankie", "testing"
        go "timeline"

        when: "I enter a new message and post it"
        $("#postContent").value("This is a test post from Geb")
        $("#newPost").find("input", type: "button").click()

        then: "I see the new post in the timeline"
        waitFor { !$("div.postText", text: "This is a test post from Geb").empty }
    }

    private login(String username, String password) {
        go "login/form"
        $("input[name='username']").value(username)
        $("input[name='password']").value(password)
        $("input[type='submit']").click()
    }
}
