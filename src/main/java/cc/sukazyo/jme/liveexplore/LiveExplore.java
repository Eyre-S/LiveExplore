package cc.sukazyo.jme.liveexplore;

import cc.sukazyo.jme.liveexplore.jme.App;
import cc.sukazyo.jme.liveexplore.setting.Setting;

public class LiveExplore {
	
	public static final String NAME = "LiveExplore";
	public static final String VERSION = "0.1-debug1";
	
	public static final int BUILD_VERSION = 1;
	
	public static final boolean DEBUG = true;
	
	private static App application = null;
	
	public static void main(String[] args) {
		application = new App();
		
		application.setSettings(Setting.init());
		debugInit();
		
		application.start();
	}
	
	private static void debugInit() {
		if (DEBUG) {
			application.setShowSettings(true);
		} else {
			application.setShowSettings(false);
		}
	}
	
}
