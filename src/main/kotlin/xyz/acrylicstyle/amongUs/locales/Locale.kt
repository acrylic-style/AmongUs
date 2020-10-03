package xyz.acrylicstyle.amongUs.locales

import xyz.acrylicstyle.amongUs.AmongUsPlugin

abstract class Locale(id: String) {
    init {
        AmongUsPlugin.localeRegistry.register(id, this)
    }

    companion object {
        private var currentLocale: Locale? = null

        fun getLocale() = currentLocale ?: throw NullPointerException("Locale is not yet set.")

        fun setLocale(locale: Locale) { currentLocale = locale }

        fun setLocale(localeId: String) = setLocale(AmongUsPlugin.localeRegistry.getOrThrow(localeId))
    }

    abstract val name: String
    abstract val noPermission: String
    abstract val startingIn: String
}
