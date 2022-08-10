package com.example.facebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var settingsAdapter: PostAdapter
    lateinit var itemList: MutableList<SettingPost>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.post_rv)
        layoutManager= LinearLayoutManager(this)
        creatSettingsItems()
        settingsAdapter= PostAdapter(itemList)
        settingsAdapter.onItemClickListener=object :PostAdapter.OnItemClickListener{
            override fun onItemClick(pos: Int, item: SettingPost) {
                //val intent= Intent(this@MainActivity,TimelineActivity::class.java)
                //startActivity(intent)
                Toast.makeText(this@MainActivity, " Hello from"+ pos, Toast.LENGTH_SHORT).show()
            }
        }
        settingsAdapter.onItemClickListener=object :PostAdapter.OnItemClickListener{
            override fun onItemClick(pos: Int, item: SettingPost) {
                Toast.makeText(this@MainActivity,item.username+ " "+ pos, Toast.LENGTH_SHORT).show()

            }

        }
        recyclerView.adapter=settingsAdapter
        recyclerView.layoutManager=layoutManager

    }
    //lateinit var itemList: List<SettingsItem> //immutable object
    private fun creatSettingsItems(){
        itemList= mutableListOf()// creat empty list
        //itemList.add(SettingPost(username = "Marwa Essam",profileId =R.drawable.profile,textPost = " hello ftyati",linkPost = "httb//jhgvfcfvbn.com",post_image = R.drawable.shoping,share = R.drawable.ic_share,like = R.drawable.lik))
        for (i in 0..1000 step 1){
            itemList.add(SettingPost(username = "Marwa ",profileId =R.drawable.profile,textPost = " hello ftyati",linkPost = " httb//jhgvfcfvbn.com",post_image = R.drawable.shoping,share = R.drawable.ic_share,like = R.drawable.lik))
            itemList.add(SettingPost(username = "Mariam",profileId =R.drawable.user1,textPost = " hello girle",linkPost = " httb//jhgvfcfvbn.com",post_image = R.drawable.user2,share = R.drawable.ic_share,like = R.drawable.lik))
            itemList.add(SettingPost(username = "fayrouz",profileId =R.drawable.monsters,textPost = " hello Monsters",linkPost = " httb//jhgvfcfvbn.com",post_image = R.drawable.yellow,share = R.drawable.ic_share,like = R.drawable.lik))

        }

    }
}