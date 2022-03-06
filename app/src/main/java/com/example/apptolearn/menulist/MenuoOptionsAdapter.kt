package com.example.apptolearn.menulist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apptolearn.R

class MenuoOptionsAdapter (
    private val list: List<ItensMenu>,
    private val onItemClickListener: ItemClickListener
    ) : RecyclerView.Adapter<MenuoOptionsViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuoOptionsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuoOptionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuoOptionsViewHolder, position: Int) {
        val product = list[position]
        holder.bind(product, onItemClickListener)
    }

    override fun getItemCount(): Int = list.size
    }


    class MenuoOptionsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(option: ItensMenu, onItemClickListener: ItemClickListener) {
            view.apply {
                setOnClickListener { onItemClickListener.onClick(option) }
                findViewById<ImageView>(R.id.imageView_item_pic).setImageResource(option.image)
                findViewById<TextView>(R.id.textView_item_name).text = option.option
            }
        }
    }

    fun interface ItemClickListener {
        fun onClick(option: ItensMenu)
    }