package com.qtechie.passwordmanager.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by WorkPlace on 3/1/2018.
 */

@Entity
class PasswordModel(var category: String, var title: String, var username: String, var password: String, var security_ques1: String, var security_ques2: String, var security_ans1: String, var security_ans2: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
