package com.wolf

class PostController {
    static scaffold = Post
    def postService

    def home() {
        if (!params.id) {
            params.id = "chuck_norris"
        }
        redirect(action: 'timeline', params: params)
    }

    def timeline() {
        def user = User.findByLoginId(params.id)
        if (!user) {
            response.sendError(404)
        } else {
            [ user : user]
        }
    }

    def personal() {
        def user = User.findByLoginId('chuck_norris')
        redirect(action: 'timeline', id: user.loginId)
    }

    def addPost(String id, String content) {
        try {
            def newPost = postService.createPost(id, content)
            flash.message = "Added new post: ${newPost.content}"
        } catch (PostException pe) {
            flash.message = pe.message
        }
        redirect(action: 'timeline', id: id)
    }

    def addPostAjax(String id, String content) {
       def user = User.findByLoginId(id)
        try {
            def newPost = postService.createPost(id, content)
            def recentPosts = Post.findAllByUser(user,
                    [sort: 'dateCreated', order: 'desc', max: 20])
            render template: 'postEntry',
                    collection: recentPosts,
                    var: 'post'
        } catch (PostException pe) {
            render {
                div(class:"errors", pe.message)
            }
        }
    }

    def tinyUrl(String fullUrl) {
        def origUrl = URLEncoder.encode(fullUrl)
        def tinyUrl = new URL("http://tinyurl.com/api-create.php?url=${origUrl}").text
        render(contentType:"application/json") {
            urls(small: tinyUrl, full:fullUrl)
        }
    }

    def global() {
        [posts : Post.list(params), postCount : Post.count()]
    }

}
