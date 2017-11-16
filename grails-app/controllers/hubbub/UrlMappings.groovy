package hubbub

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/users/$id" {
            controller = "post"
            action = "timeline"
        }

        "/timeline/$id" {
            controller = "post"
            action = "timeline"
        }

        "/timeline" {
            controller = "post"
            action = "personal"
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }


}
