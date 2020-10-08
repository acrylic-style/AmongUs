package xyz.acrylicstyle.amongUs.locales

import org.bukkit.ChatColor

@Suppress("ClassName")
object Locale_en_US: Locale("en_US") {
    override val name = "English"
    override val noPermission = "${ChatColor.RED}You don't have permission to do that."
    override val startingIn = "${ChatColor.YELLOW}Game starting in ${ChatColor.RED}%d${ChatColor.YELLOW} seconds"
}
