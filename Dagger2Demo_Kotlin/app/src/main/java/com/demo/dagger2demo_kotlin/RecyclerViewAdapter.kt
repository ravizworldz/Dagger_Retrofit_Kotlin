package com.demo.dagger2demo_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.demo.dagger2demo_kotlin.model.RecyclerData
import kotlinx.android.synthetic.main.recycler_view_list_row.view.*

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<RecyclerData>? = null

    fun setUpdatedData(listData: List<RecyclerData>) {
        this.listData = listData
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView = view.imageView
        val textviewName = view.textviewName
        val textviewDescription = view.textviewDescription

        fun bind(data: RecyclerData) {
            textviewName.setText(data.name)
            textviewDescription.setText(data.description)

            Glide.with(imageView)
                .load(data.owner?.avatar_url)
                .apply(RequestOptions.centerCropTransform())
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(listData == null)return 0
        else return listData?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }
}