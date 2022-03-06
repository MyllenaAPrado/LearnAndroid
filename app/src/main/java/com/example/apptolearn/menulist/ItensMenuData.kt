package com.example.apptolearn.menulist

import com.example.apptolearn.R

class ItensMenuData {

    fun loadItems(): List<ItensMenu> = listOf(
        ItensMenu(
          image = R.drawable.ic_option_one,
          option = "Check Android",
        ),
        ItensMenu(
            image = R.drawable.dice_1,
            option = "Roll Dice",
        ),
        ItensMenu(
            image = R.mipmap.ic_about_dev,
            option = "About dev",
        ),
        ItensMenu(
            image = R.mipmap.ic_game_curiosity,
            option = "Game Curiosity",
        ),
        ItensMenu(
          image = R.mipmap.ic_calculator_foreground,
          option = "Calculator",
        ),
        ItensMenu(
        image = R.drawable.ic_baseline_arrow_back_24,
        option = "Back",
        ),

    )
}