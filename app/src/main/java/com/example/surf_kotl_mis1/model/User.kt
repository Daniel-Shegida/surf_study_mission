package com.example.surf_kotl_mis1.model

import com.google.gson.annotations.SerializedName

data  class LoginPost (


    @SerializedName("accessToken")
    var accessToken : String,
    @SerializedName("userInfo")
    var userInfo : UserInfo




)