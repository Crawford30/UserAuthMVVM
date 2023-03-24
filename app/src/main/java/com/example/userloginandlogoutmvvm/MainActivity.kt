package com.example.userloginandlogoutmvvm


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.example.userloginandlogoutmvvm.data.responses.user.UserPreferences
import com.example.userloginandlogoutmvvm.ui.auth.AuthActivity
import com.example.userloginandlogoutmvvm.ui.home.HomeActivity
import com.example.userloginandlogoutmvvm.ui.startNewActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userPreferences = UserPreferences(this)

        userPreferences.authToken.asLiveData().observe(this, Observer {
            val activity = if (it == null) AuthActivity::class.java else HomeActivity::class.java
            startNewActivity(activity)
        })

//        userPreferences.authToken.asLiveData.observe(this, Observer {
//            Toast.makeText(this,it ?: "Token is null", Toast.LENGTH_LONG).show()
//        })


    }
}