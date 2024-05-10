package com.abc.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.abc.recyclerviewexample.adapter.UsersAdapter
import com.abc.recyclerviewexample.databinding.ActivityMainBinding
import com.abc.recyclerviewexample.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsers.layoutManager = LinearLayoutManager(this)

        val users = listOf<User>(
            User("Ahmed Nasser", 50),
            User("Ahmed Nasser 1", 60),
            User("Ahmed Nasser 2", 40),
            User("Ahmed Nasser 3", 30),
            User("Ahmed Nasser 4", 25),
            User("Ahmed Nasser 5", 15),
            User("Ahmed Nasser 5", 15),
            User("Ahmed Nasser 5", 15),
            User("Ahmed Nasser 5", 15),
            User("Ahmed Nasser 5", 15),
            User("Ahmed Nasser 5", 15),
            User("Ahmed Nasser 5", 15),
        )

        val usersAdapter = UsersAdapter(users)
        usersAdapter.onClickItem = { position ->
            Toast.makeText(this, users[position].name, Toast.LENGTH_SHORT).show()
        }

        binding.rvUsers.adapter = usersAdapter
    }
}