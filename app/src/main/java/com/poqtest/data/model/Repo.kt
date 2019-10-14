package com.poqtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Repo(val name: String?,
           @SerializedName("full_name")
           @Expose
           val fullName: String?,
           val description: String?)
