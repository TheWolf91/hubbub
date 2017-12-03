databaseChangeLog = {

    changeSet(author: "The_Wolf (generated)", id: "1512067069071-1") {
        dropColumn(columnName: "TWITTER_NAME", tableName: "PROFILE")
    }
}
