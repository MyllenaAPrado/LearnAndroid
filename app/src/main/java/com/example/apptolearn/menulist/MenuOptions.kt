package com.example.apptolearn.menulist

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apptolearn.R
import com.example.apptolearn.aboutdev.DevProfileFragment
import com.example.apptolearn.calculator.CalculatorFragment
import com.example.apptolearn.curiosityGame.CuriosityGameFragment
import com.example.apptolearn.dicegame.RollDiceFragment


internal class MenuOptions: Fragment(R.layout.menu_options) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val onClickListener = ItemClickListener {option->

            if (option.option == "Check Android"){
                val versionAPI = Build.VERSION.SDK_INT
                val versionRelease = Build.VERSION.RELEASE
                Toast.makeText(this.activity, "Android version: $versionAPI \n Release: $versionRelease", Toast.LENGTH_SHORT).show()
            }

            if (option.option == "Roll Dice") {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container_view, RollDiceFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }

            if (option.option == "About dev") {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container_view, DevProfileFragment.newInstance())
                    .addToBackStack(null)
                    .commit()

            }

            if (option.option == "Game Curiosity") {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container_view, CuriosityGameFragment.newInstance())
                    .addToBackStack(null)
                    .commit()

            }

            if (option.option == "Calculator"){
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container_view, CalculatorFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }


            if (option.option == "Back") {
                parentFragmentManager.popBackStack()
            }

        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_menu)
        val adapter = MenuoOptionsAdapter(ItensMenuData().loadItems(), onClickListener)
        val layoutManager = LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }

    companion object {
        fun newInstance(): MenuOptions {
            return MenuOptions()
        }
    }

}