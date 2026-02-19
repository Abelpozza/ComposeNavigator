package com.abel.jetpackprojeto.data.remote

import com.abel.jetpackprojeto.data.model.Post
import com.abel.jetpackprojeto.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject

class ApiService {

    private val client = OkHttpClient()

    suspend fun fetchUser(): List<User> = withContext(Dispatchers.IO) {

        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/users")
            .build()

        val response = client.newCall(request).execute()
        val responseBody = response.body()?.string()

        val userList = mutableListOf<User>()

        if (responseBody != null) {
            val jsonArray = JSONArray(responseBody)

            for (i in 0 until jsonArray.length()) {
                val item = jsonArray.getJSONObject(i)

                userList.add(
                    User(
                        id = item.getInt("id"),
                        name = item.getString("name"),
                        username = item.getString("username"),
                        email = item.getString("email")
                    )
                )
            }
        }

        userList
    }

    suspend fun fetchPosts(): List<Post> = withContext(Dispatchers.IO) {

        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts")
            .build()

        val response = client.newCall(request).execute()
        val responseBody = response.body()?.string()

        val postList = mutableListOf<Post>()

        if (responseBody != null) {
            val jsonArray = JSONArray(responseBody)

            for (i in 0 until jsonArray.length()) {
                val item = jsonArray.getJSONObject(i)

                postList.add(
                    Post(
                        userId = item.getInt("userId"),
                        id = item.getInt("id"),
                        title = item.getString("title"),
                        body = item.getString("body")
                    )
                )
            }
        }

        postList
    }

    suspend fun fetchPostById(postId: Int): Post? = withContext(Dispatchers.IO) {

        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts/$postId")
            .build()

        val response = client.newCall(request).execute()
        val responseBody = response.body()?.string()

        if (responseBody != null) {
            val jsonObject = JSONObject(responseBody)

            return@withContext Post(
                userId = jsonObject.getInt("userId"),
                id = jsonObject.getInt("id"),
                title = jsonObject.getString("title"),
                body = jsonObject.getString("body")
            )
        }

        null
    }
}
