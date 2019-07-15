package com.example.dblapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dblapp.adapter.RecyclerViewAdapter
import com.example.dblapp.databinding.ActivityEquipListBindingImpl
import com.example.dblapp.model.EquipUnit
import com.example.dblapp.model.Equipment
import kotlinx.android.synthetic.main.equip_listitem.view.*

class EquipListActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityEquipListBindingImpl

    private var mEquips: ArrayList<EquipUnit> = ArrayList()

    private lateinit var mEquipment: Equipment
    private var mEquipsNumber: Int = 0

    private lateinit var mAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_equip_list)

        setSupportActionBar(mBinding.toolbar as Toolbar)
        supportActionBar?.title = getString(R.string.equip_register_title)

        mBinding.view = this

        val intent = intent
        this.mEquipment = intent.getSerializableExtra(MainActivity.EQUIPAMENT) as Equipment
        this.mEquipsNumber = intent.getIntExtra(MainActivity.EQUIPS_NUMBER, 1)

        for (x in 0 until mEquipsNumber){
            mEquips.add(EquipUnit(this.mEquipment))
        }

        initRecyclerView()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.fab_calculate -> onCalculateButton()
        }
    }

    //Métodos de Botões
    private fun onCalculateButton() {
        if(!validateFields()){
            return
        }

        for(x in mEquips){
            x.calculateScore()
        }

        mAdapter.notifyDataSetChanged()
    }

    //Métodos de Validação
    private fun validateFields(): Boolean{
        return true
    }

    private fun initRecyclerView(){
        val recyclerView = mBinding.rvEquipList
        mAdapter = RecyclerViewAdapter(this, mEquips)
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}
