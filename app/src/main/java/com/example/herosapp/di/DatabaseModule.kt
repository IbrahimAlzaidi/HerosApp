package com.example.herosapp.di

import android.content.Context
import androidx.room.Room
import com.example.herosapp.data.local.HeroDatabase
import com.example.herosapp.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        HeroDatabase::class.java,
        DATABASE_NAME
    ).build()
}