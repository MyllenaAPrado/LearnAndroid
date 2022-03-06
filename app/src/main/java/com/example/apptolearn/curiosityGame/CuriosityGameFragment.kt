package com.example.apptolearn.curiosityGame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apptolearn.R
import com.example.apptolearn.databinding.GameCuriosityBinding

internal class CuriosityGameFragment : Fragment(R.layout.game_curiosity) {

    private lateinit var viewModel: CuriosityGameViewModel
    private lateinit var binding: GameCuriosityBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = GameCuriosityBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(CuriosityGameViewModel::class.java)
        viewModel.question.observe(viewLifecycleOwner, ::updateUi)
        viewModel.score.observe(viewLifecycleOwner, ::updateScore)

        viewModel.eventGameFinished.observe(viewLifecycleOwner, Observer { hasFinished ->
            if(hasFinished){
             Toast.makeText(this.activity, "Finished Game", Toast.LENGTH_SHORT).show()
            }

        })

        binding.buttonChoose.setOnClickListener{
            viewModel.checkAnswer()
        }


        binding.radioGroup.setOnCheckedChangeListener{ _, checkedId ->
            when(checkedId){
                binding.option1.id->{
                    viewModel.setAnswer(viewModel.question.value?.option1)
                }
                binding.option2.id->{
                    viewModel.setAnswer(viewModel.question.value?.option2)
                }
                binding.option3.id->{
                    viewModel.setAnswer(viewModel.question.value?.option3)
                }
                binding.option4.id->{
                    viewModel.setAnswer(viewModel.question.value?.option4)
                }
            }

        }

        binding.buttonSkip.setOnClickListener{
            viewModel.nextQuestion()
        }

        binding.buttonBack.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    private fun updateScore(value: Int?) {
        binding.pointText.setText("Points: $value")

    }

    private fun updateUi(questionGame: QuestionGame) = binding.run {
        questionText.text = questionGame.question
        option1.text = questionGame.option1
        option2.text = questionGame.option2
        option3.text = questionGame.option3
        option4.text = questionGame.option4
    }

    companion object {
        fun newInstance(): CuriosityGameFragment {
            return CuriosityGameFragment()
        }
    }

}



