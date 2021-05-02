package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import java.lang.NullPointerException

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mcurrentPos : Int = 1
    private var mquestionList : ArrayList<Question>?= null
     private var mSelectedoption : Int = 0
    private  var mCorrectanswers: Int = 0
    private var mUsername:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUsername=intent.getStringExtra(Constants.Username)

        val tv_option1=findViewById<TextView>(R.id.tv_option1) as TextView
        val tv_option2=findViewById<TextView>(R.id.tv_option2) as TextView
        val tv_option3=findViewById<TextView>(R.id.tv_option3) as TextView
        val tv_option4=findViewById<TextView>(R.id.tv_option4) as TextView
        val btn1=findViewById<Button>(R.id.btn1) as Button
        mquestionList=Constants.getQuestions()
        Setquestion()

        tv_option1.setOnClickListener(this)
        tv_option2.setOnClickListener(this)
        tv_option3.setOnClickListener(this)
        tv_option4.setOnClickListener(this)
        btn1.setOnClickListener (this)


    }



    private fun Setquestion(){
        val  progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
        val  tv_progress=findViewById<TextView>(R.id.tv_progress) as TextView
        val tv_question=findViewById<TextView>(R.id.tv_questions) as TextView
        val iv_image=findViewById<ImageView>(R.id.q1) as ImageView
        val tv_option1=findViewById<TextView>(R.id.tv_option1) as TextView
        val tv_option2=findViewById<TextView>(R.id.tv_option2) as TextView
        val tv_option3=findViewById<TextView>(R.id.tv_option3) as TextView
        val tv_option4=findViewById<TextView>(R.id.tv_option4) as TextView
        val btn1=findViewById<Button>(R.id.btn1) as Button

        val question=mquestionList!![mcurrentPos-1]
        defaultoption()
        if(mcurrentPos == mquestionList!!.size){
            btn1.text="FINISH"
        }else{
            btn1.text="SUBMIT"
        }
        progressBar.progress=mcurrentPos;
        tv_progress.text = "$mcurrentPos"+"/"+progressBar.max
        tv_question.text= question!!.question
        iv_image.setImageResource(question.image)
        tv_option1.text= question.option1
        tv_option2.text= question.option2
        tv_option3.text= question.option3
        tv_option4.text= question.option4


    }

    private fun defaultoption(){
        val tv_option1=findViewById<TextView>(R.id.tv_option1) as TextView
        val tv_option2=findViewById<TextView>(R.id.tv_option2) as TextView
        val tv_option3=findViewById<TextView>(R.id.tv_option3) as TextView
        val tv_option4=findViewById<TextView>(R.id.tv_option4) as TextView
        val options=ArrayList<TextView>()
        options.add(0,tv_option1)
        options.add(1,tv_option2)
        options.add(2,tv_option3)
        options.add(3,tv_option4)
        for(option in options)
        {

            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.default_coloring
            )
        }
    }

    override fun onClick(v: View?) {
        val tv_option1=findViewById<TextView>(R.id.tv_option1) as TextView
        val tv_option2=findViewById<TextView>(R.id.tv_option2) as TextView
        val tv_option3=findViewById<TextView>(R.id.tv_option3) as TextView
        val tv_option4=findViewById<TextView>(R.id.tv_option4) as TextView
        val btn1=findViewById<Button>(R.id.btn1) as Button
        when(v?.id){
            R.id.tv_option1 ->{
                selectedoptionview(tv_option1,1)

            }
            R.id.tv_option2 ->{
            selectedoptionview(tv_option2,2)

            }
            R.id.tv_option3 ->{
            selectedoptionview(tv_option3,3)

            }
            R.id.tv_option4 ->{
            selectedoptionview(tv_option4,4)

            }
            R.id.btn1 ->{
                if(mSelectedoption==0){
                    mcurrentPos++

                    when{
                        mcurrentPos <=mquestionList!!.size ->{
                            Setquestion()
                        }else ->{
                        val intent= Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.Username,mUsername)
                        intent.putExtra(Constants.correctanswers,mCorrectanswers)
                        intent.putExtra(Constants.TotalQuestion,mquestionList!!.size)
                        startActivity(intent)
                    }
                    }
                }else{
                    val question=mquestionList?.get(mcurrentPos-1)
                    if(question!!.correct !=mSelectedoption ){
                        AnswerView(mSelectedoption,R.drawable.wrongoptionbg)

                    }else{
                        mCorrectanswers++
                    }
                    AnswerView(question.correct,R.drawable.correctoptionbg)
                    if(mcurrentPos ==mquestionList!!.size){
                        btn1.text ="FINISH"
                    }else {
                        btn1.text="GO TO NEXT QUESTION"
                    }
                    mSelectedoption =0
                }


            }
        }

    }
    private fun AnswerView(answer: Int,drawableView:Int) {
        val tv_option1=findViewById<TextView>(R.id.tv_option1) as TextView
        val tv_option2=findViewById<TextView>(R.id.tv_option2) as TextView
        val tv_option3=findViewById<TextView>(R.id.tv_option3) as TextView
        val tv_option4=findViewById<TextView>(R.id.tv_option4) as TextView
        when(answer){
         1->{
             tv_option1.background= ContextCompat.getDrawable(
                     this,drawableView
             )
         }
         2->{
             tv_option2.background= ContextCompat.getDrawable(
                     this,drawableView
             )
         }
         3->{
             tv_option3.background= ContextCompat.getDrawable(
                     this,drawableView
             )
         }
         4->{
             tv_option4.background= ContextCompat.getDrawable(
                     this,drawableView
             )
         }
        }
    }


    private fun selectedoptionview(tv: TextView, selectedOptionNum: Int){
        defaultoption()
        mSelectedoption= selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)

        tv.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_coloring
        )
    }


}