package com.wolf.functional.pages

import geb.Page
class TimelinePage extends Page {
    static url = "users"
    static content = {
        whatHeading { $("#bd h1") }
        newPostContent { $("#postContent") }
        submitPostButton { $("#newPost").find("input", type: "button") }
        posts { content ->
            if (content) $("div.postText", text: content).parent()
            else $("div.postEntry")
        }
    }
    static at = {
        title.contains("Timeline for")
        $("#allPosts")
    }
}