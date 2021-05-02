package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN;

        val et_name = findViewById<EditText>(R.id.et_name)
        val btn= findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            if (et_name.text.toString().isEmpty())
            {
                Toast.makeText(this,"Please Enter your name",Toast.LENGTH_LONG).show();
            }
            else
            {
                val intent=Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constants.Username,et_name.text.toString())
                startActivity(intent);

                finish();

            }
        }


    }

    
}