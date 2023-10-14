package edu.farmingdale.who_wants_to_be_a_millionaire

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    //Initialize
    private lateinit var moneyTextView: TextView
    private lateinit var questionTextView: TextView
    private lateinit var answersRadioGroup: RadioGroup
    private lateinit var answer1RadioButton: RadioButton
    private lateinit var answer2RadioButton: RadioButton
    private lateinit var answer3RadioButton: RadioButton
    private lateinit var answer4RadioButton: RadioButton
    private lateinit var confirmButton: Button
    private var currentQuestionIndex = 0
    private var totalMoney = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize with UI
        moneyTextView = findViewById(R.id.tvTotalMoney)
        questionTextView = findViewById(R.id.tvQuestion)
        answersRadioGroup = findViewById(R.id.rgAnswersGroup)
        answer1RadioButton = findViewById(R.id.rbAnswer1)
        answer2RadioButton = findViewById(R.id.rbAnswer2)
        answer3RadioButton = findViewById(R.id.rbAnswer3)
        answer4RadioButton = findViewById(R.id.rbAnswer4)
        confirmButton = findViewById(R.id.bnConfirm)

        //Calls method to show questions
        setQuestion()

        confirmButton.setOnClickListener {
            //Checks for if no answer was selected
            if (answersRadioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show()
            } else {
                //checks if answer is correct or wrong
                checkAnswer()
                //Moves to next question
                currentQuestionIndex++
                //Show next question
                setQuestion()
            }
        }
    }

    private fun setQuestion() {
        //If question isn't at 7, show next question
        if (currentQuestionIndex < QuestionAnswer.question.size) {
            questionTextView.text = QuestionAnswer.question[currentQuestionIndex]
            answer1RadioButton.text = QuestionAnswer.choices[currentQuestionIndex][0]
            answer2RadioButton.text = QuestionAnswer.choices[currentQuestionIndex][1]
            answer3RadioButton.text = QuestionAnswer.choices[currentQuestionIndex][2]
            answer4RadioButton.text = QuestionAnswer.choices[currentQuestionIndex][3]
        } else {
            //Calls method to show statistics
            finishQuiz()
        }
    }

    private fun finishQuiz() {
        val totalQuestions = QuestionAnswer.question.size
        val correctAnswers = totalMoney / 100
        val percentage = (correctAnswers.toFloat() / totalQuestions) * 100

        val message = StringBuilder()
        message.append("Number Of Questions Correct: $correctAnswers out of $totalQuestions\n")
        message.append("Accuracy: ${String.format("%.2f", percentage)}%\n")
        message.append("Total Money Earned: $$totalMoney")

        AlertDialog.Builder(this)
            .setTitle("Statistics")
            .setMessage(message.toString())
            .setPositiveButton("Restart", fun(_: DialogInterface, _: Int) {
                totalMoney = 0
                currentQuestionIndex = 0
                updateMoneyEarned()
                setQuestion()
            })
            .setCancelable(false)
            .show()
    }

    private fun checkAnswer() {
        val selectedAnswerID = answersRadioGroup.checkedRadioButtonId
        val selectedAnswer = findViewById<RadioButton>(selectedAnswerID)

        if (selectedAnswer.text == QuestionAnswer.correctAnswers[currentQuestionIndex]) {
            //$100 for each correct answer
            totalMoney += 100
            updateMoneyEarned()
            Toast.makeText(this, "This is the CORRECT answer! You earned $${totalMoney}", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "This is the WRONG answer! You earned $0", Toast.LENGTH_SHORT).show()
        }
        //Clear selected radio button for next question
        answersRadioGroup.clearCheck()
    }

    //Method for updating money upon each correct answer
    private fun updateMoneyEarned() {
        "You Earned : $${totalMoney}".also { moneyTextView.text = it }
    }
}