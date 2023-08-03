package com.dfg.roomusertest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dfg.roomusertest.bean.Book

/*
* Create by KUTAI1 on 2023/8/3
*/
@Dao
interface BookDao {
    @Insert
    fun insertBook(book: Book): Long
    @Query("select * from Book")
    fun loadAllBooks(): List<Book>
}
