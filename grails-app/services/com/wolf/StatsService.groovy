package com.wolf

class StatsService {
    static transactional = false

    def redisService

    void onNewPost(Post newPost) {
        String dateToday = new Date().format("dd-MM-yy")
        String redisTotalsKey = "daily.stat.totalPosts.${dateToday}"

        log.debug "New Post from: ${newPost.user.loginId}"

        redisService.incr(redisTotalsKey)

        String redisTotalsByUserKey = "daily.stat.totalsByUser.${dateToday}"

        redisService.zincrby(redisTotalsByUserKey, 1, newPost.user.loginId)
        int usersPostsToday = redisService.zscore(redisTotalsByUserKey, newPost.user.loginId)
        log.debug "Incremented daily stat for ${newPost.user.loginId} to ${usersPostsToday}"
    }
}
