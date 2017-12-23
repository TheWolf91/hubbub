package com.wolf

class AuditService {
    static transactional = false

    def springSecurityService

    def onNewPost(Post newPost){
        log.error "New Post from: ${newPost.user.loginId} : ${newPost.shortContent}"
        def auditEntry = new AuditEntry(message: "New Post: ${newPost.shortContent}", userId: newPost.user.loginId)
        auditEntry.details = newPost.properties['userId', 'shortContent', 'dateCreated']
        auditEntry.machineName = InetAddress.localHost.hostName
        def dynamicProps = [
                "os-name": System.getProperty("os.name"),
                "os-version": System.getProperty("os.version"),
                "os-java": System.getProperty("java.version")
        ]
        dynamicProps.each { key, value ->
            auditEntry[key] = value
        }
        auditEntry.save(failOnError: true)
    }
}
