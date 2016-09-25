package ExamplePlugin;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.ServerCommandEvent;

/**
 * author: Kims(Translate)
 * NukkitExamplePlugin Project
 */
public class EventListener implements Listener {
    MainClass plugin;

    public EventListener(MainClass plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false) //@EventHandler 선언을 잊지 마세요.
    public void onServerCommand(ServerCommandEvent event) {
        this.plugin.getLogger().info("서버 커맨드 입력이 감지되었습니다.");
        //여기에 소스를 더 작성하세요.
    }
}
