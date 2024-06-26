package com.example.testingpourposema

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class login : AppCompatActivity() {
    private lateinit var username:EditText
    private lateinit var password:EditText
    private lateinit var login:Button
    private lateinit var loglay: ConstraintLayout
    private lateinit var loading: ProgressBar
    private lateinit var txtin:TextView
    private lateinit var creat: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        username=findViewById(R.id.username)
        password=findViewById(R.id.password)
        login=findViewById(R.id.login)
        loglay=findViewById(R.id.loglay)
        loading = findViewById(R.id.loading)
        txtin = findViewById(R.id.txtin)
        creat = findViewById(R.id.creat)

        creat.setOnClickListener {
            val intgf = Intent(this,singup::class.java)
            intgf.putExtra("gotup","Create Account Now")
            startActivity(intgf)
        }

//        getIntent().getStringExtra("this is 1s string")
        txtin.setText(getIntent().getStringExtra("this is 1s string"))


        login.setOnClickListener {
            loading.visibility = View.VISIBLE

            val Username = username.text.toString()
            val Password = password.text.toString()

            val nam= "Siyam"
            val pas= "1234"

            if (Username==nam && Password == pas){
                val snackbar = Snackbar.make(loglay,"Log in Success",Snackbar.LENGTH_LONG)
                snackbar.show()
            }else{

                val snackbar = Snackbar.make(loglay,"Error", Snackbar.LENGTH_LONG).setAction("Retry"){
                    val snackbar = Snackbar.make(loglay,"Create Account", Snackbar.LENGTH_LONG)
                    snackbar.setActionTextColor(Color.BLUE)
                    snackbar.show()
                }
                snackbar.show()
            }



        }

    }
}