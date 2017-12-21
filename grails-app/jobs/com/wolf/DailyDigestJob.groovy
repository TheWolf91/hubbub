package com.wolf

class DailyDigestJob {
    def dailyDigestService
    def volatility = false

    static triggers = {
      cron cronExpression: "0 0 1 ? * MON-FRI"
    }

    def execute() {
        log.debug "Starting the Daily Digest job."
        dailyDigestService.sendDailyDigests()
        log.debug "Finished the Daily Digest job."
    }
}
