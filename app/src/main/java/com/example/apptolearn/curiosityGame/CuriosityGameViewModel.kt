package com.example.apptolearn.curiosityGame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


internal class CuriosityGameViewModel : ViewModel() {

    private var questionData: MutableList<QuestionGame> = CuriosityGameData().loadQuentions()
    private var iteratorQuestions: MutableListIterator<QuestionGame> = questionData.listIterator()

    // The current score
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    private val _question = MutableLiveData<QuestionGame>()
    val question : LiveData<QuestionGame> = _question

    private val _answer = MutableLiveData<String>()
    private val answer: LiveData<String> = _answer

    private val _eventGameFinished = MutableLiveData<Boolean>()
    val eventGameFinished: LiveData<Boolean> = _eventGameFinished


    init {
        nextQuestion()
        _score.value = 0
        _eventGameFinished.value = false
    }

    fun nextQuestion() {
        if(iteratorQuestions.hasNext()){
            _question.value = iteratorQuestions.next()
        }
        else{
            _eventGameFinished.value = true
        }
    }

    fun setAnswer(answer: String?){
        this._answer.value = answer
    }

    fun checkAnswer(){
        if (this._question.value!!.right_answer == this._answer.value) {
            _score.value = (_score.value)?.plus(this.question.value!!.points)
        }
        nextQuestion()
    }

}
