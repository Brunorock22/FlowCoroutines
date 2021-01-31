package com.example.flowstudying.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flowstudying.R
import com.example.flowstudying.data.model.NewsArticle
import com.example.flowstudying.utils.loadImage
import kotlinx.android.synthetic.main.item_list.view.*

class ListViewAdapter :
    RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {

    private val newsItems = arrayListOf<NewsArticle>()

    fun onAddNewsItem(item: NewsArticle) {
        newsItems.add(0, item)
        notifyItemInserted(0)
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = view.item_imageView
        private val author = view.item_title_text
        private val title = view.item_description_text

        fun bind(newsItem: NewsArticle) {
            imageView.loadImage(newsItem.urlToImage)
            author.text = newsItem.author
            title.text = newsItem.title
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsItems[position])
    }

    override fun getItemCount(): Int = newsItems.size
}