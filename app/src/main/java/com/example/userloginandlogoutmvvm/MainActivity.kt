package com.example.userloginandlogoutmvvm


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.userloginandlogoutmvvm.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        finish()


       val intent = Intent(this, AuthActivity::class.java)

        //val intent = Intent(AuthActivity::class.java)

        startActivity(intent)
    }
}