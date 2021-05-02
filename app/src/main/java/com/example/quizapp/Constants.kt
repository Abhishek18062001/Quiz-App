package com.example.quizapp


object Constants{
    const val Username :String="username"
    const val TotalQuestion :String ="total_question"
    const val correctanswers:String="correctanswers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()


        val que1=Question(1,"Predict the Output ",
            R.drawable.q1,"INFINTE","0","7","CAN'T BE DETERMINE",1)
        questionsList.add(que1)
        // que2
        val que2=Question(2,"Predict the Output ",
            R.drawable.q2,"INFINTE","Compiler Dependent","-1","1",2)
        questionsList.add(que2)
        //qu3
        val que3=Question(3,"Predict the Output ",
            R.drawable.q3,"%s Geeks For Geeks Geeks For Geeks","Geeks Geeks ","NO Output","CAN'T BE DETERMINE",1)
        questionsList.add(que3)
        //que4
        val que4=Question(4,"Predict the Output ",
            R.drawable.q4,"INFINTE","Compiler Dependent","-1","1",4)
        questionsList.add(que4)
        //ques5
        val que5=Question(5,"Predict the Output ",
            R.drawable.q5,"Nice test strings","Nice test for","Nice test for strings","No Output",3)
        questionsList.add(que5)
        //que6
        val que6=Question(6,"Predict the Output ",
            R.drawable.q6,"Garbage Value","0","Int min","Int max",1)
        questionsList.add(que6)
        //ques7
        val que7=Question(7,"Predict the Output ",
            R.drawable.q7,"0 0 0 0","1 1 1 1","1 2 3 4","4 3 2 1",1)
        questionsList.add(que7)
        //que8
        val que8=Question(8,"Predict the Output ",
            R.drawable.q8,"1 2 3 4 5","0 0 0 0 0","5 4 3 2 1","1 0 1 0 1",3)
        questionsList.add(que8)
        //ques9
        val que9=Question(9,"Predict the Output ",
            R.drawable.q9,"Garbage Value","0","-1","1",4)
        questionsList.add(que9)
        //ques10
        val que10=Question(10,"Predict the Output ",
            R.drawable.q10,"16 16","16 21","21 16","21 21",2)
        questionsList.add(que10)








        return questionsList
    }
}