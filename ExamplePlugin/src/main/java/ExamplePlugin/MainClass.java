package ExamplePlugin;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * author: MagicDroidX(Translate by Kims)
 * NukkitExamplePlugin Project
 */
public class MainClass extends PluginBase {

    @Override
    public void onLoad() {
        this.getLogger().info(TextFormat.WHITE + "�ε��Ǿ����ϴ�.");
    }

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + "Ȱ��ȭ �Ǿ����ϴ�.");

        this.getLogger().info(String.valueOf(this.getDataFolder().mkdirs()));

        //�̺�Ʈ ������ ���
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);

        //�÷����� �׽�ũ
        this.getServer().getScheduler().scheduleRepeatingTask(new BroadcastPluginTask(this), 200);

        //���ҽ� ����
        this.saveResource("string.txt");

        //Config �б�/����
        Config config = new Config(
                new File(this.getDataFolder(), "config.yml"),
                Config.YAML,
                //�⺻ config��
                new LinkedHashMap<String, Object>() {
                    {
                        put("this-is-a-key", "Hello! Config!");
                        put("another-key", true); //�ٸ� Ű�� �������� �ֽ��ϴ�.
                    }
                });
        //���⼭ ���� �а� ���ϴ�. ���� �⺻���� ���ٸ� ����� ���ϴ�.
        this.getLogger().info(String.valueOf(config.get("this-is-a-key", "this-is-default-value")));
        //���嵵 �ؾ���.
        config.save();
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "��Ȱ��ȭ �Ǿ����ϴ�.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getName()) {
            case "example":
                try {
                    this.getLogger().info(Utils.readFile(new File(this.getDataFolder(), "string.txt")) + " " + sender.getName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        return true;
    }

}
