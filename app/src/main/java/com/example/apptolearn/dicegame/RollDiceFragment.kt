package com.example.apptolearn.dicegame

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.apptolearn.R
import java.util.*

internal class RollDiceFragment : Fragment(R.layout.roll_dice) {
    lateinit var diceImage: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rollButton: Button = view.findViewById<Button>(R.id.button_roll_dice)
        rollButton.text = "Roll"
        rollButton.setOnClickListener {
            rollDice()
            Log.d(TAG, "Roll dice!!")
        }
        diceImage = view.findViewById(R.id.dice_view)

        val button = view.findViewById<Button>(R.id.button_back_dice)
        button.setOnClickListener {
            parentFragmentManager.popBackStack()

        }
    }


    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }

    companion object {

        val TAG = "RollDiceFragment"

        fun newInstance(): RollDiceFragment {
            return RollDiceFragment()
        }
    }



}