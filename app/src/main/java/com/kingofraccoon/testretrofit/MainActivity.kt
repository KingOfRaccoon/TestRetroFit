package com.kingofraccoon.testretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var retrofit: ApiPlaceHolder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofit = RetroFitClient.instanse()!!
        var postAdapter = PostAdapter(mutableListOf())
        button.setOnClickListener {
            retrofit.getPosts().enqueue(object : Callback<MutableList<Post>> {
                override fun onResponse(call: Call<MutableList<Post>>, response: Response<MutableList<Post>>) {
                    postAdapter.updatePosts(response.body()!!)
                }

                override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = postAdapter
        recycler.layoutManager = LinearLayoutManager(this)
    }
}