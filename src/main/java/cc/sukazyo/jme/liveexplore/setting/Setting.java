package cc.sukazyo.jme.liveexplore.setting;

import cc.sukazyo.jme.liveexplore.LiveExplore;
import cc.sukazyo.jme.liveexplore.jme.App;
import com.jme3.system.AppSettings;

public class Setting {
	
	private static AppSettings setting = new AppSettings(true);
	
	public static AppSettings init () {
		setting.setTitle(LiveExplore.NAME);
		setting.setResolution(800, 600);
		setting.setResizable(true);
		
		return setting;
	}
	
}
