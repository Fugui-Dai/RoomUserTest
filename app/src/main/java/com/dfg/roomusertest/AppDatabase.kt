package com.dfg.roomusertest

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dfg.roomusertest.bean.Book
import com.dfg.roomusertest.bean.User
import com.dfg.roomusertest.dao.BookDao
import com.dfg.roomusertest.dao.UserDao

/*
* Create by KUTAI1 on 2023/8/3
*/
//entities：该数据库有哪些表
//version：数据库的版本号
//exportSchema：是否导出数据库信息的json串，建议设为false，若设为true还需指定json文件的保存路径
@Database(entities = [User::class, Book::class],version = 3,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // 获取该数据库中某张表的持久化对象
    abstract fun UserDao(): UserDao?

    //提供了一个bookDao()方法用于获取BookDao的实例。
    abstract fun bookDao(): BookDao
}