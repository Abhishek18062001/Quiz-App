package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility =View.SYSTEM_UI_FLAG_FULLSCREEN
        val tv_name=findViewById<TextView>(R.id.tv_name) as TextView
        val tv_score=findViewById<TextView>(R.id.tv_score) as TextView
        val btn2=findViewById<Button>(R.id.btn2) as Button
        val username=intent.getStringExtra(Constants.Username)
        tv_name.text= username
        val totalQuestions =intent.getIntExtra(Constants.TotalQuestion,0)
        val correctanswers=intent.getIntExtra(Constants.correctanswers,0)
        tv_score.text="Your score is $correctanswers out of $totalQuestions"
        btn2.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}