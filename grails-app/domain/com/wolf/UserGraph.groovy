package com.wolf

class UserGraph {

    static mapWith = "neo4j"

    String loginId

    static hasMany = [ following: User ]

    static constraints = {
        loginId blank: false
    }
}
