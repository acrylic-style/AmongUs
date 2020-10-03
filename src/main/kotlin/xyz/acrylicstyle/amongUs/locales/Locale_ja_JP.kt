package xyz.acrylicstyle.amongUs.locales

import org.bukkit.ChatColor

@Suppress("ClassName")
class Locale_ja_JP: Locale("ja_JP") {
    override val name = "日本語"
    override val noPermission = "${ChatColor.RED}権限がありません。"
    override val startingIn = "${ChatColor.YELLOW}ゲーム開始まで${ChatColor.RED}%d${ChatColor.YELLOW}秒前"
}
