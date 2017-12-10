package com.wolf

import grails.converters.JSON
import grails.converters.XML

import javax.annotation.PostConstruct
import java.text.SimpleDateFormat

class MarshallerRegistrar {
    def dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss")
    @PostConstruct
    void registerMarshallers() {
        JSON.registerObjectMarshaller(Post) { Post p ->
            return [id: p.id,
                    published: dateFormatter.format(p.dateCreated),
                    message: p.content,
                    user: p.user.loginId,
                    tags: p.tags.collect {it.name}
            ]
        }
        XML.registerObjectMarshaller(Post) { Post p, converter ->
            converter.attribute "id", p.id.toString()
            converter.attribute "published",
                    dateFormatter.format(p.dateCreated)
            converter.build {
                message p.content
                user p.user.loginId
                tags {
                    for (t in p.tags) {
                        tag t.name
                    }
                }
            }
        }
    }
}
