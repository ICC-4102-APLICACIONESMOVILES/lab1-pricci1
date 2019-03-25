package com.appmoviles.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailValue: String? = intent.getStringExtra(EXTRA_LOGIN_MAIL)
        val passValue: String? = intent.getStringExtra(EXTRA_LOGIN_PASS)

        mail.text = emailValue?:""
        password.text = passValue?:""

        val activityIntent = Intent(this, LoginActivity::class.java)
        if (TextUtils.isEmpty(mail.text.toString())) {
            startActivity(activityIntent)
        }
        logOutButton.setOnClickListener {
            mail.text = ""
            password.text = ""
            startActivity(activityIntent)
        }
    }
}
