package com.example.aclass

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReadRecyclerAdapter( val context: Context, val bookList: ArrayList<Book>) :
    RecyclerView.Adapter<ReadRecyclerAdapter.ReadViewHolder>() {

    class ReadViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bookName: TextView = view.findViewById(R.id.txtBookName)
        val bookAuthor: TextView = view.findViewById(R.id.txtBookAuthor)
        val bookPrice: TextView = view.findViewById(R.id.txtBookPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_book_item, parent, false)
        return ReadViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReadViewHolder, position: Int) {

        holder.bookName.text = bookList[position].bookName
        holder.bookAuthor.text = bookList[position].bookAuthor
        holder.bookPrice.text = bookList[position].bookPrice
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}
