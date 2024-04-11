package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArray : ArrayList<News>, var context : Activity) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private lateinit var myListener: onItemClickListener
    interface onItemClickListener {

        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    //to create a new view instance
    //when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
        return MyViewHolder(itemView,myListener)
    }

    //populate or fill item with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currItem = newsArray[position]
        holder.hTitle.text = currItem.head
        holder.imgID.setImageResource(currItem.image)

    }

    //how many list items are present in your array
    override fun getItemCount(): Int {
        return newsArray.size
    }

    //it holds the view so views are not created everytime, so memory is saved
    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val imgID = itemView.findViewById<ShapeableImageView>(com.google.android.material.R.id.image)
        val hTitle = itemView.findViewById<TextView>(R.id.head)

        init{
            itemView.setOnClickListener(){
                listener.onItemClick(adapterPosition)
            }
        }
    }

}