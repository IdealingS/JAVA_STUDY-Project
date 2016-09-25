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
        this.getLogger().info(TextFormat.WHITE + "로딩되었습니다.");
    }

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + "활성화 되었습니다.");

        this.getLogger().info(String.valueOf(this.getDataFolder().mkdirs()));

        //이벤트 리스너 등록
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);

        //플러그인 테스크
        this.getServer().getScheduler().scheduleRepeatingTask(new BroadcastPluginTask(this), 200);

        //리소스 저장
        this.saveResource("string.txt");

        //Config 읽기/쓰기
        Config config = new Config(
                new File(this.getDataFolder(), "config.yml"),
                Config.YAML,
                //기본 config값
                new LinkedHashMap<String, Object>() {
                    {
                        put("this-is-a-key", "Hello! Config!");
                        put("another-key", true); //다른 키를 넣을수도 있습니다.
                    }
                });
        //여기서 값을 읽고 씁니다. 만약 기본값이 없다면 만들어 냅니다.
        this.getLogger().info(String.valueOf(config.get("this-is-a-key", "this-is-default-value")));
        //저장도 해야죠.
        config.save();
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "비활성화 되었습니다.");
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
