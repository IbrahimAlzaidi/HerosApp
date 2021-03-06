package com.example.herosapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.herosapp.data.local.dao.HeroDao
import com.example.herosapp.data.local.dao.HeroRemoteKeysDao
import com.example.herosapp.domain.model.Hero
import com.example.herosapp.domain.model.HeroRemoteKeys


@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class HeroDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao

}