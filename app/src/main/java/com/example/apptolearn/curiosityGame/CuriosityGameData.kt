package com.example.apptolearn.curiosityGame

class CuriosityGameData {

    fun loadQuentions() : MutableList<QuestionGame> = mutableListOf(
        QuestionGame(
            question = "Who is the best person?",
            option1 = "Maria",
            option2 = "João",
            option3 = "Chico",
            option4 = "Ana",
            right_answer = "Chico",
            points = 2,
        ),
        QuestionGame(
            question = "What is the big event today?",
            option1 = "Party",
            option2 = "Lunch",
            option3 = "Movie",
            option4 = "Sleep",
            right_answer = "Sleep",
            points = 5,
        ),
        QuestionGame(
            question = "What is the best music of ABBA?",
            option1 = "Honey, Honey",
            option2 = "Dancing Queen",
            option3 = "Mamma Mia",
            option4 = "Voulez-Vous",
            right_answer = "Honey, Honey",
            points = 3,
        ),

    )

}