package com.wolf

class JobAdminController {

    def jobManagerService

    def index = { redirect(action:"show") }

    def show() {
        def status = ''
        switch(params.operation) {
            case 'pause': jobManagerService.pauseJob("myServices", "com.wolf.ControllableJob")
                status = "Paused single Job"
                break
            case 'resume': jobManagerService.resumeJob("myServices", "com.wolf.ControllableJob")
                status = "Resumed single Job"
                break
            case 'pauseGroup': jobManagerService.pauseJobGroup("myServices")
                status = "Paused Job Group"
                break
            case 'resumeGroup': jobManagerService.resumeJobGroup("myServices")
                status = "Resumed Job Group"
                break
            case 'pauseAll': jobManagerService.pauseAll()
                status = "Paused all Jobs"
                break
            case 'resumeAll': jobManagerService.resumeAll()
                status = "Resumed all Jobs"
                break
        }
        return [status: status]
    }
}
