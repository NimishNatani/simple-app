package com.practicecoding.moneyreminder.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.practicecoding.moneyreminder.R
import com.practicecoding.moneyreminder.databinding.CardItemBinding
import com.practicecoding.moneyreminder.room.Nameentity

class adapter(private val NameList:List<Nameentity>,
    private val clicklistener:(Nameentity)->Unit):RecyclerView.Adapter<Myviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val layoutinflater=LayoutInflater.from(parent.context)
        val binding:CardItemBinding=DataBindingUtil.
        inflate(layoutinflater, R.layout.card_item,parent,false)
        return Myviewholder(binding)
    }

    override fun getItemCount(): Int {
return NameList.size    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
holder.bind(NameList[position],clicklistener)    }
}
class Myviewholder(val binding:CardItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(entity: Nameentity,clicklistener: (Nameentity)->Unit){
        binding.text1.text = entity.name
        binding.text2.text = entity.amount.toString()
        binding.constraint2.setOnClickListener{
            clicklistener(entity)
        }
    }
}