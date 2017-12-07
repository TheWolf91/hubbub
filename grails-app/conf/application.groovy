greenmail.disabled = false
grails.mail.port = com.icegreen.greenmail.util.ServerSetupTest.SMTP.port
grails.serverURL = "http://localhost:8080/"

grails.cache.config = {
    defaultCache {
        maxElementsInMemory 10000
        eternal false
        timeToIdleSeconds 120
        timeToLiveSeconds 120
        overflowToDisk true
        maxElementsOnDisk 10000000
        diskPersistent false
        diskExpiryThreadIntervalSeconds 120
        memoryStoreEvictionPolicy 'LRU'
    }
    cache {
        name 'myDailyCache'
        timeToLiveSeconds 60*60*24
    }
}

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.wolf.User'
grails.plugin.springsecurity.userLookup.usernamePropertyName = "loginId"
grails.plugin.springsecurity.userLookup.passwordPropertyName = "passwordHash"
grails.plugin.springsecurity.auth.loginFormUrl = "/login/form"
grails.plugin.springsecurity.failureHandler.defaultFailureUrl = "/login/form"
grails.plugin.springsecurity.successHandler.defaultTargetUrl = "/timeline"
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.wolf.UserRole'
grails.plugin.springsecurity.authority.className = 'com.wolf.Role'
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
        [pattern: '/',               access: ['permitAll']],
        [pattern: '/post/global',    access: ['permitAll']],
        [pattern: '/user/**',        access: ['permitAll']],
        [pattern: '/login/**',     access: ['permitAll']],
        [pattern: '/logout/**',     access: ['permitAll']],
        [pattern: '/assets/**',      access: ['permitAll']],
        [pattern: '/**/js/**',       access: ['permitAll']],
        [pattern: '/**/css/**',      access: ['permitAll']],
        [pattern: '/**/images/**',   access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/**', access: ['isAuthenticated()']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

