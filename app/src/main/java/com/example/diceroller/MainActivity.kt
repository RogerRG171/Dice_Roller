package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

lateinit var diceImage : ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Creating a binding object for the main_activity.xml layout | gera automaticamente ActivityMainBinding
        val binding = ActivityMainBinding.inflate(layoutInflater)

        // Referencing a view with the ID roll_button | gera automaticamente rollButton
        binding.rollButton.setOnClickListener {
            rollDice(binding)
        }

        diceImage = binding.diceImage

        //seta view binding.root
        setContentView(binding.root)
    }

    private fun rollDice(binding: ActivityMainBinding) {

        val ramdomInt = Random.nextInt(6)+1

        val drawableResource = when(ramdomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }



       diceImage.setImageResource(drawableResource)

        Toast.makeText(this, ramdomInt.toString(), Toast.LENGTH_SHORT).show()

    }

}