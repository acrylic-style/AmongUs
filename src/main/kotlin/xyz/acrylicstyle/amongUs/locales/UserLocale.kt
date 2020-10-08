package xyz.acrylicstyle.amongUs.locales

import org.bukkit.ChatColor
import xyz.acrylicstyle.tomeito_api.providers.ConfigProvider

object UserLocale: Locale("user") {
    private val config = ConfigProvider("./plugins/AmongUs/messages.yml")

    override val name: String = color(config.getString("name"))
    override val noPermission: String = color(config.getString("noPermission"))
    override val startingIn: String = color(config.getString("startingIn"))

    private fun color(text: String) = ChatColor.translateAlternateColorCodes('&', text)
}
