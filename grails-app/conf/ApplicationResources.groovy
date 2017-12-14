modules = {
    application {
        resource url:'js/application.js'
    }
    angularjs {
        resource url:'js/angular-1.6.6.js', disposition: 'head'
    }
    restangular {
        dependsOn 'angularjs'
        resource url:'js/restangular-1.6.1.js'
    }
    lodashjs {
        resource url:'js/lodash-4.17.4.js'
    }
    baseCss {
        resource url:'/css/main.css'
        resource url:'/css/hubbub.css'
    }
    core {
        dependsOn 'baseCss'
        dependsOn 'restangular,lodashjs,application'
        resource url: '/js/hubbub.js'
    }
}