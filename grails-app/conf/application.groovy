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