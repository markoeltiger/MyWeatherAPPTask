package com.mark.data.homeDomain.dataSource

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.mark.data.homeDomain.dataSource.datastoreutil.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CityPreferenceDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val CITY_KEY = stringPreferencesKey("last_city")

    suspend fun saveCity(city: String) {
        context.dataStore.edit { prefs ->
            prefs[CITY_KEY] = city
        }
    }

    val getLastCity: Flow<String?> = context.dataStore.data
        .map { prefs -> prefs[CITY_KEY] }
}
