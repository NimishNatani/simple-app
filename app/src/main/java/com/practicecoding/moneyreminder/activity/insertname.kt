package com.practicecoding.moneyreminder.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.practicecoding.moneyreminder.R
import com.practicecoding.moneyreminder.ui.Myviewmodelone
import com.practicecoding.moneyreminder.ui.adapter
import com.practicecoding.moneyreminder.ui.myfactory1
import com.practicecoding.moneyreminder.databinding.ActivityInsertnameBinding
import com.practicecoding.moneyreminder.room.Namedatabase
import com.practicecoding.moneyreminder.room.Nameentity
import com.practicecoding.moneyreminder.room.namerepo

class insertname : AppCompatActivity() {
    private lateinit var binding1:ActivityInsertnameBinding
    private lateinit var nameviewmodel:Myviewmodelone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
binding1=DataBindingUtil.setContentView(this,R.layout.activity_insertname)
    val dao=Namedatabase.getInstance(application).storeDao
    val repository=namerepo(dao)
    val factory = myfactory1(repository)
    nameviewmodel = ViewModelProvider(this,factory).get(Myviewmodelone::class.java)
    binding1.myview=nameviewmodel

    binding1.lifecycleOwner=this
    initRecycleview()}
    private fun initRecycleview(){
        binding1.recycleview1.layoutManager=LinearLayoutManager(this)
        Displayuserlist()
    }
    private fun Displayuserlist(){
        nameviewmodel.users.observe(this, Observer {
            binding1.recycleview1.adapter = adapter(it,{selectedItem: Nameentity->listItemClicked(selectedItem)})
        })
    }
    private fun listItemClicked(selectedItem:Nameentity){
        Toast.makeText(this,
        "Selected name is ${selectedItem.name}",
        Toast.LENGTH_LONG).show()
        nameviewmodel.initupdateanddelete(selectedItem)
    }
}