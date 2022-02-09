package chaira.carlos.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var minValue = 0
    var maxValue = 100
    var num:Int = 0
    var won = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView = findViewById(R.id.guessings)
        val up: Button = findViewById(R.id.up)
        val down: Button = findViewById(R.id.down)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.guessed)

        generate.setOnClickListener{
            num = Random.nextInt(minValue, maxValue)
            guessings.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE

            up.setOnClickListener {
                minValue = num
                if(checkingLimits()){
                    num = Random.nextInt(minValue, maxValue)
                    guessings.setText(num.toString())
                }else{
                    guessings.setText("You have defeated me")
                }
            }

            down.setOnClickListener {
                maxValue = num
                if(checkingLimits()){
                    num = Random.nextInt(minValue, maxValue)
                    guessings.setText(num.toString())}
                else{
                    guessings.setText("You have defeated me")
                }
            }

            guessed.setOnClickListener {
                if(!won){
                    guessings.setText("I have defeated you, your number is "+num)
                    guessed.setText("Play again?")
                    won = true
                }else{
                    generate.visibility = View.VISIBLE
                    resetValues()
                    guessings.setText("Tap on Generate to Start")
                    guessed.setText("Guessed")
                    guessed.visibility =  View.GONE
                }

            }

        }
    }

    fun resetValues(){
        minValue=0
        maxValue=100
        var num:Int = 0
        won = false

    }

    fun checkingLimits() : Boolean {
        return minValue != maxValue
    }

}