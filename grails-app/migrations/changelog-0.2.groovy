databaseChangeLog = {

    changeSet(author: "The_Wolf (generated)", id: "1512066426680-1") {
        addColumn(tableName: "profile") {
            column(name: "twitter_id", type: "varchar(255)") {
                constraints(nullable: "true")
            }
        }
    }

    changeSet(author: "The_Wolf (by hand)", id: "1512066426680-2") {
        renameColumn(tableName: "profile", oldColumnName: 'twitter_id', newColumnName: 'twitter_name')
    }
}
