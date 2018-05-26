package com.kaiser.passwordmanager.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "PasswordTable")
data class PasswordModel(
        @PrimaryKey(autoGenerate = true) var id: Long=0,
        var title: String="NIL",
        var username: String="NIL",
        var password: String="NIL",
        var security_ques_1: String="NIL",
        var security_ans_1: String="NIL",
        var security_ques_2: String="NIL",
        var security_ans_2: String="NIL",
        var remarks: String="NIL"
)