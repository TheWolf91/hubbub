package com.wolf

class PostRestController {
    def postService
    def springSecurityService

    def index() {
        respond Post.list()
    }

    def save(PostDetails post) {
        if (!post.hasErrors()) {
            def user = springSecurityService.currentUser
            def newPost = postService.createPost(user.loginId, post.message)
            respond newPost, status: 201
        }
        else {
            respond post
        }
    }

    def show(Integer id) {
        respond Post.get(id)
    }

    def update() {

    }

    def delete() {

    }

    class PostDetails {
        String message

        static constraints = {
            message blank: false, nullable: false
        }
    }
}
