package com.example.apptolearn.devRepositories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apptolearn.R
import com.example.apptolearn.R.layout.item_github

class DevGitHubAdapter(
    private val list: MutableList<Repository>,
    private val onItemClickListener: ItemClickListener
) : RecyclerView.Adapter<DevGitHubViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevGitHubViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(item_github, parent, false)
        return DevGitHubViewHolder(view)
    }

    override fun onBindViewHolder(holder: DevGitHubViewHolder, position: Int) {
        val repository = list[position]
        holder.bind(repository, onItemClickListener)
    }

    override fun getItemCount(): Int = list.size
}


class DevGitHubViewHolder(private val view: View): RecyclerView.ViewHolder(view){

    fun bind(option: Repository, onItemClickListener: ItemClickListener){
        view.apply{
            setOnClickListener {onItemClickListener.onClick(option)}
            findViewById<TextView>(R.id.text_repository_name).text = option.repositoryName
            findViewById<TextView>(R.id.text_repository_URL).text = option.repositoryURL
            findViewById<TextView>(R.id.text_repository_description).text = option.repositoryDesc

        }
    }
}



fun interface ItemClickListener {
    fun onClick(option: Repository)
}