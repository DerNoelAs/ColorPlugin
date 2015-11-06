# ColorPlugin
package de.dernoelas.color;


	import java.io.File;
	import java.io.IOException;
	import org.bukkit.ChatColor;
	import org.bukkit.command.Command;
	import org.bukkit.command.CommandSender;
	import org.bukkit.configuration.file.YamlConfiguration;
	import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.EventPriority;
	import org.bukkit.event.Listener;
	import org.bukkit.event.block.SignChangeEvent;
	import org.bukkit.event.player.AsyncPlayerChatEvent;
	import org.bukkit.plugin.java.JavaPlugin;
	 
	 public class main
	extends JavaPlugin
	implements Listener 
		{
		 		private File file = new File("plugins/Lobby", "messages.yml");
		 		private YamlConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);
		 		private String nopermission;
  
		 		private void save() {
	try {
	 this.cfg.save(this.file);  }
    catch (IOException e) {
	       e.printStackTrace();
	    }
	   }
	   
	   private void setDefaults()
	   {
	     this.cfg.addDefault("messages.nopermission", "§e[§6Lobby§e] §7Dafür hast du keine Rechte.");
	     this.cfg.options().copyDefaults(true);
	     save();
	   }
	   
	   private void initMessages()
	   {
	     this.nopermission = this.cfg.getString("messages.nopermission").replace("&", "Â§");
	   }
	   
	   public void onEnable()
	   {
	     getLogger().info("§e[§6Lobby§e] §7Plugin gestartet!");
	     getServer().getPluginManager().registerEvents(this, this);
	     setDefaults();
	     initMessages();
	}   
	   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	   {
	     if (cmd.getName().equalsIgnoreCase("color")) {
	       if ((sender.isOp()) || (sender.hasPermission("lobby.color")))
	       {
	         sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD.toString() + "=================§e[§6Lobby-§cC§bo§el§fo§ar§e]=================");
	         
	         sender.sendMessage(ChatColor.DARK_BLUE + "&1 Dunkel Blau               " + ChatColor.DARK_GREEN + "&2 Dunkel Grün           " + ChatColor.BLUE + "&9 Blau");
	         sender.sendMessage(ChatColor.DARK_AQUA + "&3  Aqua                      " + ChatColor.DARK_RED + "&4 Dunkel Rot             " + ChatColor.GRAY + "&7 Grau");
	         sender.sendMessage(ChatColor.DARK_PURPLE + "&5 Dunkel lila                " + ChatColor.GOLD + "&6 Gold                     " + ChatColor.AQUA + "&b Aqua");
	         sender.sendMessage(ChatColor.BLACK + "&0 Schwartz                 " + ChatColor.GREEN + "&a Grün                    " + ChatColor.YELLOW + "&e Gelb");
	         sender.sendMessage(ChatColor.RED + "&c Rot                        " + ChatColor.LIGHT_PURPLE + "&d Pink                     " + ChatColor.WHITE + "&f Weiss");
	         sender.sendMessage(ChatColor.RESET + "&k " + ChatColor.MAGIC + "m" + ChatColor.RESET + "                          " + ChatColor.RESET + 
	           "&l " + ChatColor.BOLD + "Bold                 " + ChatColor.RESET + "&o" + ChatColor.ITALIC + " Italics");
	         sender.sendMessage("&n " + ChatColor.UNDERLINE + "Underline" + ChatColor.RESET + "               " + "&m " + ChatColor.STRIKETHROUGH + "Strikethrough" + ChatColor.RESET + 
	           "          " + ChatColor.RESET + "&r Reset");
	         
	         sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD.toString() + "=================§e[§6Lobby-§cC§bo§el§fo§ar§e]=================");

	       }
	       else
	       {
	         sender.sendMessage(this.nopermission);
	       }
	     }
	     return true;
	   }
	   
	   @EventHandler(priority=EventPriority.HIGHEST)
	   public void onChat(AsyncPlayerChatEvent e)
	   {
	     Player p = e.getPlayer();
	     if ((p.isOp()) || (p.hasPermission("lobby.chatcolor")))
	     {
	       String msg = e.getMessage();
	       e.setMessage(ChatColor.translateAlternateColorCodes('&', msg));
	     }
	   }
	   
	   @EventHandler(priority=EventPriority.HIGHEST)
	   public void onSignChange(SignChangeEvent e)
	   {
	     Player p = e.getPlayer();
	     if ((p.isOp()) || (p.hasPermission("lobby.signcolor")))
	     {
	       String line0 = e.getLine(0);
	       String line1 = e.getLine(1);
	       String line2 = e.getLine(2);
	       String line3 = e.getLine(3);
	       e.setLine(0, ChatColor.translateAlternateColorCodes('&', line0));
	       e.setLine(1, ChatColor.translateAlternateColorCodes('&', line1));
	       e.setLine(2, ChatColor.translateAlternateColorCodes('&', line2));
	       e.setLine(3, ChatColor.translateAlternateColorCodes('&', line3));
	     }
	   }
		}
