package com.poqtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Repo {
    @SerializedName("id")
    @Expose
    val id: Int? = null
    @SerializedName("node_id")
    @Expose
    val nodeId: String? = null
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("full_name")
    @Expose
    val fullName: String? = null
    @SerializedName("html_url")
    @Expose
    val htmlUrl: String? = null
    @SerializedName("description")
    @Expose
    val description: String? = null
    @SerializedName("git_url")
    @Expose
    val gitUrl: String? = null
    @SerializedName("homepage")
    @Expose
    val homepage: String? = null
    @SerializedName("size")
    @Expose
    val size: Int? = null
}
