package com.kotlinseries.mysplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //step-Initialise your variable
        auth = Firebase.auth
    }
    //We sshall create a view
    //view is the the base class for widget
    fun register(view: View) {
        val email = findViewById<EditText>(R.id.signupemail)
        val password = findViewById<EditText>(R.id.signuppassword)
        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener{
            task->
            if (task.isSuccessful){
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener{exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()

        }
    }

    fun signin(view: View) {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)

    }


}