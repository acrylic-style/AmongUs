package xyz.acrylicstyle.amongUs

import org.bukkit.plugin.java.JavaPlugin
import xyz.acrylicstyle.amongUs.commands.StartCommand
import xyz.acrylicstyle.amongUs.locales.Locale
import xyz.acrylicstyle.amongUs.locales.Locale_en_US
import xyz.acrylicstyle.amongUs.locales.Locale_ja_JP
import xyz.acrylicstyle.amongUs.locales.UserLocale
import xyz.acrylicstyle.amongUs.util.CaseInsensitiveWritableRegistry
import xyz.acrylicstyle.amongUs.util.Registry
import xyz.acrylicstyle.amongUs.util.SimpleReadonlyRegistry
import xyz.acrylicstyle.amongUs.util.WritableRegistry
import xyz.acrylicstyle.tomeito_api.TomeitoAPI
import xyz.acrylicstyle.tomeito_api.providers.ConfigProvider
import xyz.acrylicstyle.tomeito_api.utils.Log

class AmongUsPlugin: JavaPlugin() {
    init {
        instance = this
    }

    companion object {
        lateinit var instance: AmongUsPlugin
        val log = Log.with("AmongUs")
        var localeRegistry: Registry<String, Locale> = CaseInsensitiveWritableRegistry()
        val config = ConfigProvider("./plugins/AmongUs/config.yml")
    }

    override fun onEnable() {
        // Register locales before using them
        Locale_en_US
        Locale_ja_JP
        UserLocale
        localeRegistry = SimpleReadonlyRegistry(localeRegistry.copy())
        // Available locales: en_US, ja_JP, user (messages.yml)
        Locale.setLocale(AmongUsPlugin.config.getString("locale", "ja_JP"))
        log.info("Locale: ${Locale.getLocale().name}")
        TomeitoAPI.registerCommand("start", StartCommand())
        log.info("Enabled AmongUs")
    }
}
