package xyz.acrylicstyle.amongUs.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.scheduler.BukkitRunnable
import xyz.acrylicstyle.amongUs.AmongUsPlugin
import xyz.acrylicstyle.amongUs.locales.Locale

class StartCommand: CommandExecutor {
    companion object {
        var startTimer = 10
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (!sender.hasPermission("amongus.start")) {
            sender.sendMessage(Locale.getLocale().noPermission)
            return true
        }
        AmongUsPlugin.log.info("Starting the game (by ${sender.name})")
        startTimer = 10
        object: BukkitRunnable() {
            override fun run() {
                if (startTimer == 0) {
                    this.cancel()
                    return
                }
                Bukkit.broadcastMessage(String.format(Locale.getLocale().startingIn, startTimer))
                startTimer--
            }
        }.runTaskTimer(AmongUsPlugin.instance, 20L, 20L)
        return true
    }
}
