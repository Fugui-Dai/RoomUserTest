package com.dfg.roomusertest.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Create by KUTAI1 on 2023/8/3
*/
@Entity(tableName = "User") //(tableName = "User")可以省略
data class User(var firstName: String, var lastName: String, var age: Int) {
    //自增长
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}