package com.dfg.roomusertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dfg.roomusertest.bean.Book
import com.dfg.roomusertest.bean.User
import com.dfg.roomusertest.dao.BookDao
import com.dfg.roomusertest.dao.UserDao

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userDao: UserDao? = MainApplication.instance?.getUserDB()?.UserDao();
        var id=userDao?.insertOne(User("daifugui","fuguidai",18));
        Log.d("MainActivity","添加成功，id是${id}")

        var loadAllUsers = userDao?.loadAllUsers();
        if (loadAllUsers != null) {
            for (info in loadAllUsers){
                Log.d("MainActivity","id:${info.id},Name:${info.firstName},age:${info.age}")
            }
        }
        var bookDao: BookDao? = MainApplication.instance?.getUserDB()?.bookDao();
        bookDao?.insertBook(Book("红楼梦",1000,"曹雪芹"))
        var loadAllBooks = bookDao?.loadAllBooks()
        if (loadAllBooks != null) {
            for (info in loadAllBooks){
                Log.d("MainActivity","id:${info.id},Name:${info.name},page:${info.pages},author${info.author}")
            }
        }
    }
}