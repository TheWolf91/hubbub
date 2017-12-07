package com.wolf.functional.pages

import geb.Page

class GlobalTimelinePage extends Page {
    static url = "post/global"

    static content = {
        allPosts { $("#allPosts") }
        posts { content ->
            if (content) $("div.postText", text: content).parent()
            else $("div.postEntry")
        }
    }

    static at = {
        title.contains("Global Timeline")
        $("#allPosts")
    }
}