package ExamplePlugin;

import cn.nukkit.scheduler.PluginTask;

/**
 * author: Kims(Translate)
 * ExamplePlugin Project
 */
public class BroadcastPluginTask extends PluginTask<MainClass> {

    public BroadcastPluginTask(MainClass owner) {
        super(owner);
    }

    @Override
    public void onRun(int currentTick) {
        this.getOwner().getLogger().info("ƽ ��ȣ '" + currentTick + "' ���� �÷����� �۵���.");
    }
}
