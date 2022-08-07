package com.aplicacion.tunicapp.admin

import com.aplicacion.tunicapp.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Noticias : NavigationItem("noticias", R.drawable.ic_article_24, "Noticias")
    object Añadir : NavigationItem("añadir", R.drawable.ic_post_add_24, "Añadir")
    object Hermanos : NavigationItem("hermanos", R.drawable.ic_people_24, "Hermanos")
    object Salida : NavigationItem("salida", R.drawable.ic_watch_24, "Salida")
}
