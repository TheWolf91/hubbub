package com.wolf

import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.Specification

@Integration
@Rollback
class UserIntegrationSpec extends Specification {

    def "Save our first user to the database"() {

        given: "brand new user"
        def joe = new User(loginId: 'joe', password: 'secret', homepage: 'http://www.hubbub.com/joe')

        when: "the user is saved"
        joe.save()

        then: "it saved successfully and can be found in the database"
        joe.errors.errorCount == 0
        joe.id != null
        User.get(joe.id).loginId == joe.loginId
    }

    def "Updating a saved user changes its properties"() {

        given: "An existing user"
        def existingUser = new User(loginId: 'joe', password: 'secret', homepage: 'http://www.hubbub.com/joe')
        existingUser.save(failOnError: true)

        when: "A property is changed"
        def foundUser = User.get(existingUser.id)
        foundUser.password = 'sesame'
        foundUser.save(failOnError: true)

        then: "The change is reflected in the database"
        User.get(existingUser.id).password == 'sesame'
    }

    def "Deleting an existing user removes it from the database"() {

        given: "An existing user"
        def user = new User(loginId: 'joe', password: 'secret', homepage: 'http://www.hubbub.com/joe')
        user.save(failOnError: true)

        when: "The user is deleted"
        def foundUser = User.get(user.id)
        foundUser.delete(flush: true)

        then: "The user is removed from the database"
        !User.exists(foundUser.id)
    }
}
