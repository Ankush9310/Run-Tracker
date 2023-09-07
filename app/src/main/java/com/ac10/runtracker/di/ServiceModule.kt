package com.ac10.runtracker.di

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.ac10.runtracker.R
import com.ac10.runtracker.others.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import com.ac10.runtracker.others.Constants.NOTIFICATION_CHANNEL_ID
import com.ac10.runtracker.ui.MainActivity
import com.google.android.gms.location.FusedLocationProviderApi
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped

@Module
@InstallIn(ServiceComponent::class)
object ServiceModule {

    @Provides
    @ServiceScoped
    fun provideFusedLocationProviderClient(
        @ApplicationContext appContext: Context
    ) = FusedLocationProviderClient(appContext)

    @Provides
    @ServiceScoped
    fun provideMainActivityPendingIntent(
        @ApplicationContext appContext: Context
    ) = PendingIntent.getActivity(
        appContext,
        0,
        Intent(appContext, MainActivity::class.java).also {
            it.action = ACTION_SHOW_TRACKING_FRAGMENT
        },
        PendingIntent.FLAG_UPDATE_CURRENT
    )


    @Provides
    @ServiceScoped
    fun provideBaseNotificationBuilder(
        @ApplicationContext app: Context,
        pendingIntent: PendingIntent
    ) = NotificationCompat.Builder(app, NOTIFICATION_CHANNEL_ID)
        .setAutoCancel(false)
        .setOngoing(true)
        .setSmallIcon(R.drawable.ic_directions_run_black_24dp)
        .setContentTitle("Running App")
        .setContentText("00:00:00")
        .setContentIntent(pendingIntent)











}