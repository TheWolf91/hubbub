package com.wolf

import grails.plugin.cache.CacheEvict
import grails.plugin.cache.Cacheable

class PostController {
    static scaffold = Post
    def postService
    def springSecurityService

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
        def user = springSecurityService.currentUser
        render view: "timeline", model: [ user : user ]
    }

    def addPost(String content) {
        def user = springSecurityService.currentUser
        try {
            def newPost = postService.createPost(user.loginId, content)
            flash.message = "Added new post: ${newPost.content}"
        } catch (PostException pe) {
            flash.message = pe.message
        }
        redirect(action: 'timeline', id: user.loginId)
    }

    @CacheEvict(value = 'userTimeline', allEntries = true)
    def addPostAjax(String content) {
        def user = springSecurityService.currentUser
        try {
            def newPost = postService.createPost(user.loginId, content)
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

    @Cacheable('globalTimeline')
    def global() {
        [posts : Post.list(params), postCount : Post.count()]
    }

    def singlepage() {
        def user = params.id ? User.findByLoginId(params.id) : springSecurityService.currentUser
        if (!user) {
            response.sendError(404)
        } else {
            [ user : user ]
        }
    }

}
