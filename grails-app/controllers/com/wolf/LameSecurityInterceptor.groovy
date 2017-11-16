package com.wolf


class LameSecurityInterceptor {

    LameSecurityInterceptor() {
        match(controller: 'post', action: ~/(addPost|deletePost)/)
    }

    boolean before() {
        if (params.impersonatedId) {
            session.user = User.findByLoginId(params.impersonatedId)
        }
        if (!session.user) {
            redirect(controller: 'login', action: 'form')
            return false
        }
    }

    boolean after() {
        model
    }

    void afterView() {
        log.debug("Finished running ${controllerName}")
    }
}
