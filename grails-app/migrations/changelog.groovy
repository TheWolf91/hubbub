databaseChangeLog = {

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-1") {
        createTable(tableName: "post") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "postPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "content", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-2") {
        createTable(tableName: "post_tags") {
            column(name: "post_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "tag_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-3") {
        createTable(tableName: "profile") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "profilePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "jabber_address", type: "VARCHAR(255)")

            column(name: "homepage", type: "VARCHAR(255)")

            column(name: "bio", type: "VARCHAR(1000)")

            column(name: "photo", type: "BLOB(2097152)")

            column(name: "skin", type: "VARCHAR(9)")

            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "country", type: "VARCHAR(255)")

            column(name: "full_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "timezone", type: "VARCHAR(255)")

            column(name: "email", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-4") {
        createTable(tableName: "role") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "rolePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-5") {
        createTable(tableName: "tag") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "tagPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-6") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "password_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "login_id", type: "VARCHAR(20)") {
                constraints(nullable: "false")
            }

            column(name: "password_hash", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "BOOLEAN") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-7") {
        createTable(tableName: "user_role") {
            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-8") {
        createTable(tableName: "user_user") {
            column(name: "user_following_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "BIGINT")
        }
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-9") {
        addPrimaryKey(columnNames: "post_id, tag_id", tableName: "post_tags")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-10") {
        addPrimaryKey(columnNames: "user_id, role_id", constraintName: "user_rolePK", tableName: "user_role")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-11") {
        addUniqueConstraint(columnNames: "authority", constraintName: "UC_ROLEAUTHORITY_COL", tableName: "role")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-12") {
        addUniqueConstraint(columnNames: "login_id", constraintName: "UC_USERLOGIN_ID_COL", tableName: "user")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-13") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "post", constraintName: "FK72mt33dhhs48hf9gcqrq4fxte", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-14") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK859n2jvi8ivhui0rl0esws6o", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-15") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FKa68196081fvovjhkek5m97n3y", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-16") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "profile", constraintName: "FKawh070wpue34wqvytjqr4hj5e", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-17") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_user", constraintName: "FKewu8a78thkqv37l3ww3e94oqv", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-18") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "tag", constraintName: "FKld85w5kr7ky5w4wda3nrdo0p8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-19") {
        addForeignKeyConstraint(baseColumnNames: "post_id", baseTableName: "post_tags", constraintName: "FKmmtgl185ka210lj8kenewllt1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "post")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-20") {
        addForeignKeyConstraint(baseColumnNames: "user_following_id", baseTableName: "user_user", constraintName: "FKmp45owdb8og1vvegb87csnfxm", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }

    changeSet(author: "The_Wolf (generated)", id: "1512491615228-21") {
        addForeignKeyConstraint(baseColumnNames: "tag_id", baseTableName: "post_tags", constraintName: "FKp7cfgjsujc2vl3p88qfqkpws6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tag")
    }
    include file: 'reply-domain.groovy'
}
