package PocketBot;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.Listener;
import cn.nukkit.utils.Config;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.Command;

import java.io.File;
import java.util.LinkedHashMap;

import cn.nukkit.Player;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase implements Listener {
	private Config $config;
	public void $config() {
	}
    public void onLoad() {
		this.getLogger().info ( TextFormat.GRAY + "PocketBot Plugin being prepared..." );
		this.getLogger().info ( TextFormat.GRAY + "PocketBot Plugin prepared." );
        Config config = new Config(
                new File(this.getDataFolder(), "config.yml"),
                Config.YAML,
                new LinkedHashMap<String, Object>() {
                    {
                    	put("난갤럭시가좋던데", "true");
                    	put("ㅎㅇ", "true");
                    	put("노래틀어줘!", "true");
                    }
                });
		this.$config.getAll();
	}
	public void onEnable() {
		this.getLogger().info( TextFormat.GRAY + "Plugin enabled." );
		this.getLogger().info( TextFormat.RED + "This plugin's license is GNU V3.0." );
		this.getServer().getPluginManager().registerEvents( this, this );
	}
	public void onDisable() {
		this.$config.save ();
	}
	public boolean onCommand(CommandSender $sender, Command $command, String $label, String[] $args) {
		if (strtolower ( $command.getName () ) == "포켓봇") {
			if (! $sender.hasPermission ( "포켓봇" ))
				return false;
			if (! isset ($args [0])) {
				this.onHelp($sender);
				return true;
			}
			switch (strtolower ( $args [0] )) {
				case "ㅎㅇ":
					$sender.sendMessage( TextFormat.DARK_AQUA + "[포켓봇]" + TextFormat.YELLOW + " 좋은 날입니다! 주인님!" );
					break;
				case "노래틀어줘":
					$sender.sendMessage( TextFormat.DARK_AQUA + "[포켓봇]" + TextFormat.YELLOW + " 노래틀기는 아직 지원하지 않습니다 ㅜ" );
					break;
				case "난갤럭시가좋던데":
					$sender.sendMessage( TextFormat.DARK_AQUA + "[포켓봇]" + TextFormat.YELLOW + " 칫! 저 삐졌어요 흥!" );
					break;
				
				default :
					this.onHelp ( $sender );
					break;
			}
			return true;
		}
		return false;
	}
	private boolean isset(String string) {
		return false;
	}
	private String strtolower(String name) {
		return null;
	}
	public void onHelp(CommandSender $sender) {
		if (((Player) $sender).isOnline ()) {
			
			$sender.sendMessage( TextFormat.GREEN + "----------" + TextFormat.LIGHT_PURPLE + "포켓봇의 도움말 " + TextFormat.GREEN + "----------" );
			$sender.sendMessage( TextFormat.DARK_AQUA + "/포켓봇 ㅎㅇ " );
			$sender.sendMessage( TextFormat.DARK_AQUA + "/포켓봇 노래 틀어줘" );
			$sender.sendMessage( TextFormat.DARK_AQUA + "/포켓봇 난 갤럭시가 좋던데" );
		}
	}
}
