package com.example.facebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(var posts:List<SettingPost>): RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.activity_post,parent,false)
                return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post=posts[position]
        post.profileId?.let { holder.profileId.setImageResource(it) }
        holder.username.setText(post.username)
        holder.textPost.setText(post.textPost)
        //holder.linkPost.setText(post.linkPost)

        if (post.post_image!=null)
            holder.post_image.setImageResource(post.post_image)

        if (onItemClickListener!=null){
            holder.itemView.setOnClickListener({
                onItemClickListener?.onItemClick(position,post)
            })
        }

        if (onImageClickListener!=null){
            holder.post_image.setOnClickListener({
                onImageClickListener?.onItemClick(position,post)
            })
        }
    }

    override fun getItemCount(): Int {
       return posts.size
    }

    var onItemClickListener:OnItemClickListener?=null;
    var onImageClickListener:OnItemClickListener?=null;

    interface OnItemClickListener{
        fun onItemClick(pos: Int,item: SettingPost)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileId:ImageView=itemView.findViewById(R.id.profile_screen)
        val username:TextView=itemView.findViewById(R.id.username)
        val textPost:TextView=itemView.findViewById(R.id.post_text)
        //val linkPost:TextView=itemView.findViewById(R.id.post_link)
        val post_image:ImageView=itemView.findViewById(R.id.post_screen)
        //val share:ImageView=itemView.findViewById(R.id.share)
        //val like:ImageView=itemView.findViewById(R.id.likes)

    }
}