package com.example.infinitinews.ui.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.infinitinews.data.model.Article
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object ArticleNavType : NavType<Article>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Article? {
        return Json.decodeFromString(bundle.getString(key)?:return null)
    }

    override fun parseValue(value: String): Article {
        return Json.decodeFromString(Uri.decode(value))
    }

    override fun put(bundle: Bundle, key: String, value: Article) {
        bundle.putString(key, Json.encodeToString(value))
    }

    override fun serializeAsValue(value: Article): String = Uri.encode(Json.encodeToString(value))

}