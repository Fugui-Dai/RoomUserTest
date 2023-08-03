package com.dfg.roomusertest.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Create by KUTAI1 on 2023/8/3
*/
@Entity
data class Book(var name: String, var pages: Int, var author: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
