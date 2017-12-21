package com.wolf

import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.Specification

@Integration
@Rollback
class JabberServiceIntegrationSpec extends Specification {
    def jabberService
    def jmsService

    def jmsOutputQueue = "jabberOutQ"

    static transactional = false

    def "Send message to the jabber queue"() {
        given: "Some sample queue data"
        def post = [user: [userId: 'chuck_norris'],
                    content: 'is backstroking across the atlantic']
        def jabberIds = ["glen@grailsinaction.com",
                         "peter@grailsinaction.com" ]
        def msgListBeforeSend =
                jmsService.browse(jabberService.sendQueue)
        when:
        jabberService.sendMessage(post, jabberIds)
        then:
        jmsService.browse(jabberService.sendQueue).size() ==
                msgListBeforeSend.size() + 1
    }
}
