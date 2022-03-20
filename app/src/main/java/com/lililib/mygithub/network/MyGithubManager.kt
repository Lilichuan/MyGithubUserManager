package com.lililib.mygithub.network

import com.android.volley.*
import com.google.gson.Gson

class MyGithubManager (){
    val USER_NAME = "Lilichuan"
    val USER_PSW = "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"
    var gson : Gson = Gson()

    fun test(){
        val clazz : Class<GitUserItem> = GitUserItem
        var url = "https://api.github.com/user"
        //var map = Map<String, String>()
        val map : java.util.HashMap<String, String> = java.util.HashMap<String, String>()
        map.put("accept", "application/vnd.github.v3+json")
        var response = Response.Listener<GitUserItem>().onResponse()
        //var gsonRequest = GsonRequest<GitUserItem>(gson, url,map, );
    }


}

private fun <GitUserItem> Response.Listener<com.lililib.mygithub.network.GitUserItem>.onResponse() {

    TODO("Not yet implemented")
}
