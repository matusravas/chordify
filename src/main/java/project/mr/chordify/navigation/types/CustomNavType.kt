package project.mr.chordify.navigation.types

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import project.mr.chordify.model.api.SongDto

class CustomNavType: NavType<SongDto>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): SongDto? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): SongDto {
        return Gson().fromJson(value, SongDto::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: SongDto) {
        bundle.putParcelable(key, value)
    }
}