package com.dfg.roomusertest.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dfg.roomusertest.bean.User

/*
* Create by KUTAI1 on 2023/8/3
*/
@Dao
interface UserDao {
    //@Insert(onConflict = OnConflictStrategy.REPLACE)// 记录重复时替换原记录
    @Insert
    fun insertOne(user: User?):Long // 插入一条信息，插入成功自动返回id的值

    @Insert
    fun insertUserList(user: List<User?>?) // 插入多条信息,插入成功自动返回id的值

    @Update(onConflict = OnConflictStrategy.REPLACE)// 出现重复记录时替换原记录
    fun updateUserOne(newUser: User) //更新单条

    @Delete
    fun deleteUserOne(user: User)

    @Query("DELETE FROM User WHERE 1=1")// 设置删除语句
    fun deleteUserAll() // 删除所有书籍信息

    @Query("select * from User")// 设置查询语句
    fun loadAllUsers(): List<User>

    @Query("select * from User where age > :age") //非实体类参数来增删改数据
    fun loadUsersOlderThan(age: Int): List<User>

    @Query("delete from User where lastName = :lastName") // 非实体类参数来增删改数据
    fun deleteUserByLastName(lastName: String): Int
}

