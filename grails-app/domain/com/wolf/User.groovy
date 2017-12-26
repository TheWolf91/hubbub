package com.wolf
import grails.compiler.GrailsCompileStatic

class User implements Serializable {

    String loginId
    String passwordHash
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    Date dateCreated

    static transients = ['springSecurityService']
    static hasOne = [ profile: Profile ]
    static hasMany = [ posts: Post, tags: Tag, following: User ]

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        loginId size: 3..20, unique: true, blank: false
        tags()
        posts()
        profile nullable: true
    }

    static mapping = {
        posts sort: "dateCreated", order: "desc"
    }

    String toString() { return "User $loginId (id: $id)" }
    String getDisplayString() { return loginId }
}
