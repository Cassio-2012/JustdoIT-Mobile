package com.example.just_do_it

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.just_do_it.service.model.PostModel

class PostAdapter : RecyclerView.Adapter<PostViewHolder>() {

     var items = listOf<PostModel>()
    fun updateItems(newItems: List<PostModel>) {
            items += newItems
        print("-------------------${items.size}-------------------------")

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.row_publicacoes, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
      holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}