package com.kingofraccoon.testretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(var posts: MutableList<Post>): RecyclerView.Adapter<PostAdapter.Companion.PostViewHolder>() {

    fun updatePosts(posts: MutableList<Post>){
        this.posts = posts
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_post, parent,false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    companion object {
        class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val userId : TextView = view.findViewById(R.id.user_id)
            val id : TextView = view.findViewById(R.id.id)
            val title : TextView = view.findViewById(R.id.title)
            val body : TextView = view.findViewById(R.id.body)
            fun bind(post: Post){
                userId.text = post.userId.toString()
                id.text = post.id.toString()
                title.text = post.title
                body.text = post.body
            }
        }
    }
}