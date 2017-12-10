package com.wolf

class ErrorController {

    def internalServer() {
        def ex = request.exception.cause
        def body = new ErrorDetails(
                type: ex.class.name,
                message: ex.message)
        respond body, view: "/error"

    }

    class ErrorDetails {
        String type
        String message
    }
}
