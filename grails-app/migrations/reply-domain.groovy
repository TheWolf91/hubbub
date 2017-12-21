databaseChangeLog = {

    changeSet(author: "The_Wolf (generated)", id: "1513269065406-1") {
        createTable(tableName: "reply") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "replyPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "post_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "in_reply_to_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "The_Wolf (generated)", id: "1513269065406-2") {
        addForeignKeyConstraint(baseColumnNames: "in_reply_to_id", baseTableName: "reply", constraintName: "FK896l2ok5wka3uvu9iq34y14mj", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }

    changeSet(author: "The_Wolf (generated)", id: "1513269065406-3") {
        addForeignKeyConstraint(baseColumnNames: "post_id", baseTableName: "reply", constraintName: "FKnpyg5e6pqr2v1y4y6pacte11q", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "post")
    }
}
