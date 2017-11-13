package com.wolf

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

@TestFor(PostService)
@Mock([User, Post])
class PostServiceSpec extends Specification {

    def "Valid posts get saved and added to the user"() {
        given: "A new user in the db"
        User user = new User(loginId: 'chuck_norris', password: 'password').save(failOnError: true)

        when: "a new post is created by the service"
        def newPost = service.createPost(user.loginId, "First Post!")

        then: "the post returned and added to the user"
        newPost.content == "First Post!"
        User.findByLoginId(user.loginId).posts.size() == 1
    }

    def "Invalid posts generate exceptional outcomes"() {
        given: "A new user in the db"
        User user = new User(loginId: 'chuck_norris', password: 'password').save(failOnError: true)

        when: "an invalid post is attempted"
        def newPost = service.createPost(user.loginId, null)

        then: "an exception is thrown and no post is saved"
        thrown(PostException)
    }
}
