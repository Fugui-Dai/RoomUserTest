package com.dfg.roomusertest

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/*
* Create by KUTAI1 on 2023/8/3
*/
class MainApplication : Application() {
    companion object {
        private const val TAG = "MainApplication"
        // 利用单例模式获取当前应用的唯一实例
        var instance : MainApplication? = null// 声明一个当前应用的静态实例
        private set

        //然后编写一个MIGRATION_2_3的升级逻辑并添加到addMigrations()方法中即可。
        val MIGRATION_2_3 = object : Migration(2, 3) {
            //由于我们要新增一张Book表，所以需要在migrate()方法中编写相应的建表语句
            override fun migrate(database: SupportSQLiteDatabase) {
                //Book表的建表语句必须和Book实体类中声明的结构完全一致，否则Room就会抛出异常。
                database.execSQL("alter table Book add column author text not null default 'unknown'")
            }
        }
    }

    private var appDatabase : AppDatabase? = null// 声明一个数据库对象

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
        instance = this // 在打开应用时对静态的应用实例赋值

        // 构建数据库的实例
        //最后在构建AppDatabase实例的时候，加入一个addMigrations()方法，并把 MIGRATION_1_2传入即可。
        appDatabase = Room.databaseBuilder(instance!!, AppDatabase::class.java, "app_database")
            //.addMigrations(MIGRATION_1_2,MIGRATION_2_3) // 允许迁移数据库（发生数据库变更时，Room默认删除原数据库再创建新数据库。如此一来原来的记录会丢失，故而要改为迁移方式以便保存原有记录）
            .addMigrations(MIGRATION_2_3) // 允许迁移数据库（发生数据库变更时，Room默认删除原数据库再创建新数据库。如此一来原来的记录会丢失，故而要改为迁移方式以便保存原有记录）
            .allowMainThreadQueries() // 允许在主线程中操作数据库（Room默认不能在主线程中操作数据库）
            .build()
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "onTerminate")
    }

    // 获取书籍数据库的实例
    fun getUserDB(): AppDatabase? {
        return appDatabase
    }
}