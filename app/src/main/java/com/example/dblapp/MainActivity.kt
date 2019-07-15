package com.example.dblapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.dblapp.databinding.ActivityMainBindingImpl
import com.example.dblapp.model.Equipment


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityMainBindingImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(mBinding.toolbar as Toolbar)
        supportActionBar?.title = getString(R.string.equip_register_title)

        mBinding.view = this
        mBinding.equipment = Equipment()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.bt_confirmar -> onConfirmarButton()
            R.id.bt_verify_avg -> onVerifyAvgButton()
        }
    }

    //Métodos de Botões
    private fun onConfirmarButton() {
        if(!validateNumeroEquipamentos()){
            return
        }

        onVerifyAvgButton()

        navigate()
    }

    private fun onVerifyAvgButton() {
        if(!validateMinMaxSlots()){
            return
        }

        fillAvg(mBinding.equipment?.firstSlotAvg, mBinding.equipment?.secondSlotAvg, mBinding.equipment?.thirdSlotAvg)
    }

    //Métodos de Validação
    private fun validateMinMaxSlots(): Boolean{
        if(mBinding.etFirstSlotMin.text.isNullOrEmpty() || mBinding.etFirstSlotMax.text.isNullOrEmpty()
            || mBinding.etSecondSlotMin.text.isNullOrEmpty() || mBinding.etSecondSlotMax.text.isNullOrEmpty()
            || mBinding.etThirdSlotMin.text.isNullOrEmpty() || mBinding.etThirdSlotMax.text.isNullOrEmpty()){
            return false
        }
        if(mBinding.etFirstSlotMin.text.toString().toDouble() >= mBinding.etFirstSlotMax.text.toString().toDouble()
            || mBinding.etSecondSlotMin.text.toString().toDouble() >= mBinding.etSecondSlotMax.text.toString().toDouble()
            || mBinding.etThirdSlotMin.text.toString().toDouble() >= mBinding.etThirdSlotMax.text.toString().toDouble()){
            return false
        }
        return true
    }

    private fun validateNumeroEquipamentos(): Boolean{
        if(mBinding.etNumeroEquips.text.isNullOrEmpty()){
            return false
        }
        return true
    }

    //Métodos de Tela
    private fun fillAvg(firstSlotAvg: Double?, secondSlotAvg: Double?, thirdSlotAvg: Double?) {
        mBinding.tvFirstAvg.text = firstSlotAvg.toString()
        mBinding.tvSecondAvg.text = secondSlotAvg.toString()
        mBinding.tvThirdAvg.text = thirdSlotAvg.toString()
    }

    //Métodos de Navegação
    private fun navigate(){
        val intent = Intent(this, EquipListActivity::class.java)
        intent.putExtra(EQUIPAMENT, mBinding.equipment)
        intent.putExtra(EQUIPS_NUMBER, mBinding.etNumeroEquips.text.toString().toInt())
        startActivity(intent)
    }

    companion object {
        const val EQUIPAMENT = "Equipment"
        const val EQUIPS_NUMBER = "Number"
    }

}
