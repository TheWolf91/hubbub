package com.wolf

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

@TestFor(PostRestController)
@Mock([User, Post])
@Secured('ROLE_ADMIN')
class PostRestControllerSpec extends Specification {


    void "GET a list of posts as JSON"() {
        given: "A set of posts"
        initialiseUsersAndPosts()

        when: "I invoke the index action"
        controller.index()

        then: "I get the expected posts as JSON list"
        response.json*.content.sort() == [
                "A first post",
                "A second post",
                "Preparing for battle",
                "Soaking up the sun"
        ]
    }

    void "GET a list of posts as XML"() {
        given: "A set of posts"
        initialiseUsersAndPosts()

        when: "I invoke the show action without an ID and requesting XML"
        response.format = "xml"
        controller.index()

        then: "I get the expected posts as an XML document"
        response.xml.post.content*.text().sort() == [
                "A first post",
                "A second post",
                "Preparing for battle",
                "Soaking up the sun"
        ]
    }

//    void "POST a single post as JSON"() {
//        given: "A set of existing posts"
//        def userId = initialiseUsersAndPosts()
//
//        when: "I invoke the save action with a JSON packet"
//        request.json = '{"content":"A new post!","user":{"id":' + userId + '}}'
//        controller.save()
//
//        then: "I get a 201 JSON response with the ID of the new post"
//        response.status == 201
//        response.json.id != null
//    }

    private initialiseUsersAndPosts() {
        def chuck = new User(loginId: "chuck_norris", passwordHash: "secret")
        chuck.addToPosts(content: "A first post")
        chuck.addToPosts(content: "A second post")
        chuck.save(failOnError: true)

        def bruce = new User(loginId: "bruce_lee", passwordHash: "iknowkungfu")
        bruce.addToPosts(content: "Soaking up the sun")
        bruce.addToPosts(content: "Preparing for battle")
        bruce.save(failOnError: true, flush: true)

        return chuck.id
    }
}
