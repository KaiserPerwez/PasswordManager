package com.qtechie.passwordmanager.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by WorkPlace on 3/1/2018.
 */

@Entity
public class PasswordModel {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String category;
    public String title;
    public String username;
    public String password;
    public String security_ques1;
    public String security_ques2;
    public String security_ans1;
    public String security_ans2;

    public PasswordModel(String category, String title, String username, String password, String security_ques1, String security_ques2, String security_ans1, String security_ans2) {
        this.category = category;
        this.title = title;
        this.username = username;
        this.password = password;
        this.security_ques1 = security_ques1;
        this.security_ques2 = security_ques2;
        this.security_ans1 = security_ans1;
        this.security_ans2 = security_ans2;
    }
}
