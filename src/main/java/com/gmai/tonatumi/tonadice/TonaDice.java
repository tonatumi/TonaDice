package com.gmai.tonatumi.tonadice;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Random;

public final class TonaDice extends JavaPlugin implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player)){
            return false;
        }else{
            Player player = (Player) sender;
            Random rdm = new Random();
            int num;
            try {
                num = Integer.parseInt(args[0]);
                int result = rdm.nextInt(num)+1;
                Bukkit.getServer().broadcastMessage("§8[§6となダイス§8]" + "§e§l" + player.getDisplayName() + "§9は"+ "§e§l" + args[0] + "§9§l面ダイスを振り" + "§e§l" + result + "§9§lが出た。");
            }catch (NumberFormatException e) {
                player.sendMessage("数字が正しくありません");
            }

            return true;
        }
        }

    @Override
    public void onEnable() {
        getLogger().info("onEnableメソッドが呼び出されたよ！");
        getCommand("tdice").setExecutor(this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        getLogger().info("onDisableメソッドが呼び出されたよ！");
        // Plugin shutdown logic
    }
}
