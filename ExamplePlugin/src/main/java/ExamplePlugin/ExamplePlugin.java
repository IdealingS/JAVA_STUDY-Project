/**
 * ù��° ���� ��Ŷ  ����
 *  @version 0.1 2016-09-23
 *  @author ī����(Kims)
*/

package ExamplePlugin;

import cn.nukkit.plugin.PluginBase;

public class ExamplePlugin extends PluginBase {
	@Override
	//�÷����� Ȱ��ȭ
	public void onEnable(){
		this.getLogger().info("Ȱ��ȭ �Ǿ����ϴ�.");
	}
	//�÷����� ��Ȱ��ȭ
	public void onDisable(){
	this.getLogger().info("��Ȱ��ȭ �Ǿ����ϴ�.");
	}
}