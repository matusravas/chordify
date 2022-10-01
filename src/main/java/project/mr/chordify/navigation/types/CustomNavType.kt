package project.mr.chordify.navigation.types

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import project.mr.chordify.model.Song

class CustomNavType: NavType<Song>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Song? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Song {
        return Gson().fromJson(value, Song::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Song) {
        bundle.putParcelable(key, value)
    }
}