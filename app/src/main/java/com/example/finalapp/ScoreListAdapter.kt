package com.example.finalapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ScoreListAdapter : ListAdapter<Score, ScoreListAdapter.ScoreViewHolder>(ScoreComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        return ScoreViewHolder.create(parent)
    }

    override  fun onBindViewHolder(holder: ScoreViewHolder, position: Int){
        val current = getItem(position)
        holder.bind(current.score)
    }

    class ScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val scoreItemView: TextView = itemView.findViewById(R.id.textView)
        fun bind(text: String?){
            scoreItemView.text = text
        }
        companion object{
            fun create(parent: ViewGroup): ScoreViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.score_item, parent, false)
                return ScoreViewHolder(view)
            }
        }
    }

    class ScoreComparator : DiffUtil.ItemCallback<Score>(){
        override fun areItemsTheSame(oldItem: Score, newItem: Score): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Score, newItem: Score): Boolean {
            return oldItem.score == newItem.score
        }
    }
}