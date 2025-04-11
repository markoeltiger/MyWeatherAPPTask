package com.mark.data.homeDomain.dataSource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import javax.inject.Inject

class CityPreferenceDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "weather_prefs")
    private val CITY_KEY = stringPreferencesKey("last_city")

    suspend fun saveCity(city: String) {
        context.dataStore.edit { prefs ->
            prefs[CITY_KEY] = city
        }
    }

    val getLastCity: Flow<String?> = context.dataStore.data
        .map { prefs -> prefs[CITY_KEY] }
}
