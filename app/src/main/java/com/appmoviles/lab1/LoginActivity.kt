package com.appmoviles.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            attemptLogin()
        }
    }

    private fun attemptLogin() {
        val mailTxt = mail.text.toString()
        val passTxt = password.text.toString()

        if (TextUtils.isEmpty(passTxt) || TextUtils.isEmpty(mailTxt)) {
            var toast = Toast.makeText(this, R.string.empty_fields, Toast.LENGTH_SHORT)
            toast.show()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(mailTxt).matches()){
            var toast2 = Toast.makeText(this, R.string.invalid_mail, Toast.LENGTH_SHORT)
            toast2.show()
        } else {
            // Go to main activity
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(EXTRA_LOGIN_PASS, passTxt)
            intent.putExtra(EXTRA_LOGIN_MAIL, mailTxt)
            startActivity(intent, null)
        }
    }
}
