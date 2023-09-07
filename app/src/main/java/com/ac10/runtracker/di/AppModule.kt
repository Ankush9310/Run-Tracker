package com.ac10.runtracker.di

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.ac10.runtracker.db.RunDatabase
import com.ac10.runtracker.others.Constants.KEY_FIRST_NAME_TOGGLE
import com.ac10.runtracker.others.Constants.KEY_NAME
import com.ac10.runtracker.others.Constants.KEY_WEIGHT
import com.ac10.runtracker.others.Constants.RUNNING_DATABASE_NAME
import com.ac10.runtracker.others.Constants.SHARED_PREFERENCE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRunningDatabase(
        @ApplicationContext appContext: Context
    ) = Room.databaseBuilder(
        appContext,
        RunDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideRunDao(runDatabase: RunDatabase) = runDatabase.getRunDAO()

    @Provides
    @Singleton
    fun provideSharedPreferences (@ApplicationContext appContext: Context) =
        appContext.getSharedPreferences(SHARED_PREFERENCE_NAME, MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideName (sharedPreferences: SharedPreferences) =
        sharedPreferences.getString(KEY_NAME, "") ?: ""

    @Provides
    @Singleton
    fun provideWeight (sharedPreferences: SharedPreferences) =
        sharedPreferences.getFloat(KEY_WEIGHT, 80f)

    @Provides
    @Singleton
    fun providesFirstNameToggle(sharedPreferences: SharedPreferences) =
        sharedPreferences.getBoolean(KEY_FIRST_NAME_TOGGLE, true)








}