package com.wolf

import grails.converters.JSON
import grails.converters.XML

import javax.annotation.PostConstruct
import java.text.SimpleDateFormat

class MarshallerRegistrar {
    @PostConstruct
    void registerMarshallers() {
        println "Registering custom marshallers"
        def dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss")

            JSON.registerObjectMarshaller(Post) { Post p ->
                return [ published: dateFormatter.format(p.dateCreated),
                         message: p.content,
                         user: p.user.loginId,
                         tags: p.tags.collect { it.name } ]
            }


//            JSON.registerObjectMarshaller(Post) { Post p ->
//                return [ published: dateFormatter.format(p.dateCreated),
//                         message: p.content,
//                         user: [id: p.user.loginId,
//                                name: p.user.profile.fullName],
//                         tags: p.tags.collect { it.name } ]
//
//        }


        XML.registerObjectMarshaller(Post) { Post p, converter ->
            converter.attribute "id", p.id.toString()
            converter.attribute "published", dateFormatter.format(p.dateCreated)
            converter.build {
                message p.content
                user p.user.profile?.fullName
                tags {
                    for (t in p.tags) {
                        tag t.name
                    }
                }
            }
        }

        /*
        // Register an XML marshaller that returns a map rather than uses builder syntax.
        XML.registerObjectMarshaller(Post) { Post p ->
            return [ published: dateFormatter.format(p.dateCreated),
                    message: p.content,
                    user: p.user.profile.fullName,
                    tags: p.tags.collect { it.name } ]
        }
        */
    }
}
