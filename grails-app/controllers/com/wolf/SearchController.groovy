package com.wolf

class SearchController {
    def search() {
        def query = params.q
        if (!query) {
            return [:]
        }
        try {
            def searchResult = Post.search(query)
            return [searchResult: searchResult]
        } catch (e) {
            return [searchError: true]
        }
    }
}
