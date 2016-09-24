/**
 * 첫번째 예제 누킷  파일
 *  @version 0.1 2016-09-23
 *  @author 카이젠(Kims)
*/

package ExamplePlugin;

import cn.nukkit.plugin.PluginBase;

public class ExamplePlugin extends PluginBase {
	@Override
	//플러그인 활성화
	public void onEnable(){
		this.getLogger().info("활성화 되었습니다.");
	}
	//플러그인 비활성화
	public void onDisable(){
	this.getLogger().info("비활성화 되었습니다.");
	}
}