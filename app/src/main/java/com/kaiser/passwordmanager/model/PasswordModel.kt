package com.kaiser.passwordmanager.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "PasswordTable")
data class PasswordModel(
        @PrimaryKey(autoGenerate = true) var id: Long,
        var website: String,
        var username: String,
        var password: String,
        var security_ques_1: String,
        var security_ans_1: String,
        var security_ques_2: String,
        var security_ans_2: String,
        var remarks: String
) {
    constructor():this(0,"",
            "","",
            "","",
            "","",
            "")
}