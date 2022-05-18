package com.a1.task.ui.cycles.home_cycle.fragment.result.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a1.domain.entities.Operations
import com.a1.task.databinding.ItemOperationBinding

class OperationsAdapter :
    RecyclerView.Adapter<OperationsAdapter.ViewHolder>() {

    private var _operationsList: MutableList<Operations> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemOperationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val operation: Operations = _operationsList[position]

        with(holder.itemBinding) {
            tvFromCode.text = operation.from
            tvFromValue.text = operation.fromValue.toString()
            tvToCode.text = operation.to
            tvToValue.text = operation.toValue.toString()
        }
    }

    fun insertData(questionsList: MutableList<Operations>) {
        _operationsList = questionsList
        notifyItemRangeInserted(0, questionsList.size)
    }

    override fun getItemCount(): Int = _operationsList.size

    class ViewHolder(val itemBinding: ItemOperationBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}