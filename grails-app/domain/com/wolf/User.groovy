package com.wolf

class User {
    String loginId
    String password
    String homepage
    Date dateCreated // Naming Date variable as "dateCreated" provides special support: Grails will automatically store the timestamp in it.
    // Date lastUpdated // Like said, also this name provides special support: Grails will automatically store last update time on it.

    static constraints = {
        loginId size: 3..20, unique: true, nullable: false
        password size: 6..8, blank: false, validator: { passwd, user -> passwd != user.loginId }
        homepage url: true, nullable: false
    }
}