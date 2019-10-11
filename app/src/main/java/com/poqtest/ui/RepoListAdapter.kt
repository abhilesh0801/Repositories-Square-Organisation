package com.poqtest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.poqtest.R
import com.poqtest.data.model.Repo
import com.poqtest.utils.Constants

class RepoListAdapter() : RecyclerView.Adapter<RepoListAdapter.RepoViewHolder>() {

    private lateinit var repoList: List<Repo>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_repo_list, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = repoList.get(position)

        holder.tvName.text = repo.name
        holder.tvDescription.text = repo.description ?: Constants.DESCRIPTION_UNAVAILABLE
    }

    override fun getItemCount(): Int {
        return if(::repoList.isInitialized) repoList.size else 0
    }

    fun updateRepoList(repoList: List<Repo>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDesc)
    }
}