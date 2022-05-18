package com.a1.task.ui.cycles.home_cycle.fragment.result.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a1.domain.entities.CurrenciesResponse
import com.a1.domain.entities.SingleCurrencyModel
import com.a1.task.databinding.ItemLastCurrencyBinding

class LastCurrenciesAdapter :
    RecyclerView.Adapter<LastCurrenciesAdapter.ViewHolder>() {

    private var _currenciesList: MutableList<SingleCurrencyModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemLastCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currency: SingleCurrencyModel = _currenciesList[position]

        with(holder.itemBinding) {
            tvCode.text = currency.name
            tvValue.text = currency.amount
        }
    }

    fun insertData(questionsList: MutableList<SingleCurrencyModel>) {
        _currenciesList = questionsList
        notifyItemRangeInserted(0, questionsList.size)
    }

    override fun getItemCount(): Int = _currenciesList.size

    class ViewHolder(val itemBinding: ItemLastCurrencyBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}