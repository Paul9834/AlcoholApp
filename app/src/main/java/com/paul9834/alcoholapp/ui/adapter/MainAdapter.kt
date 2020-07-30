package com.paul9834.alcoholapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.paul9834.alcoholapp.R
import com.paul9834.alcoholapp.base.BaseViewHolder
import com.paul9834.alcoholapp.data.model.Drink
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.tragos_row.view.*

class MainAdapter
    (private val context: Context,

     private val drinks:List<Drink>, private val itemClickListener:onTragoClickListener): RecyclerView.Adapter<BaseViewHolder<*>>(){


    interface onTragoClickListener {
        fun onTragoClick (drink: Drink)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
       return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.tragos_row, parent, false))
    }

    override fun getItemCount(): Int {
       return drinks.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
           is MainViewHolder -> holder.bind(drinks[position], position)
       }
    }

    inner class MainViewHolder(itemView: View) :BaseViewHolder<Drink> (itemView) {
        override fun bind(item: Drink, position: Int) {

            Glide.with(context).load(item.imagen).into(itemView.img_trago)
            itemView.txt_titulo.text = item.nombre
            itemView.txt_description.text = item.descripcion

            itemView.card.setOnClickListener{
                itemClickListener.onTragoClick(item) }
        }

    }

}