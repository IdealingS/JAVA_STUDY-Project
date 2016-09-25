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
                    	put("�������ð�������", "true");
                    	put("����", "true");
                    	put("�뷡Ʋ����!", "true");
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
		if (strtolower ( $command.getName () ) == "���Ϻ�") {
			if (! $sender.hasPermission ( "���Ϻ�" ))
				return false;
			if (! isset ($args [0])) {
				this.onHelp($sender);
				return true;
			}
			switch (strtolower ( $args [0] )) {
				case "����":
					$sender.sendMessage( TextFormat.DARK_AQUA + "[���Ϻ�]" + TextFormat.YELLOW + " ���� ���Դϴ�! ���δ�!" );
					break;
				case "�뷡Ʋ����":
					$sender.sendMessage( TextFormat.DARK_AQUA + "[���Ϻ�]" + TextFormat.YELLOW + " �뷡Ʋ��� ���� �������� �ʽ��ϴ� ��" );
					break;
				case "�������ð�������":
					$sender.sendMessage( TextFormat.DARK_AQUA + "[���Ϻ�]" + TextFormat.YELLOW + " ĩ! �� ������� ��!" );
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
			
			$sender.sendMessage( TextFormat.GREEN + "----------" + TextFormat.LIGHT_PURPLE + "���Ϻ��� ���� " + TextFormat.GREEN + "----------" );
			$sender.sendMessage( TextFormat.DARK_AQUA + "/���Ϻ� ���� " );
			$sender.sendMessage( TextFormat.DARK_AQUA + "/���Ϻ� �뷡 Ʋ����" );
			$sender.sendMessage( TextFormat.DARK_AQUA + "/���Ϻ� �� �����ð� ������" );
		}
	}
}
