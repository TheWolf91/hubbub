package com.wolf

import grails.rest.Resource

@Resource(uri="/posts")
class Post {
    String content
    Date dateCreated

    static belongsTo = [user : User]
    static hasMany = [tags : Tag]
//    static searchable = true

    static constraints = {
        content blank: false
    }
}
