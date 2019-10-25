package cc.sukazyo.jme.liveexplore.jme;

import cc.sukazyo.jme.liveexplore.jme.debugging.DebugingAppState;
import com.jme3.app.SimpleApplication;
import com.jme3.math.ColorRGBA;

public class App extends SimpleApplication {
	
	@Override
	public void simpleInitApp() {
		
		// 加载场景
		stateManager.attach(new DebugingAppState());
		
		// 改变场景背景色
		viewPort.setBackgroundColor(new ColorRGBA(0.6f, 0.7f, 0.9f, 1));
		// 调整相机速度
		flyCam.setMoveSpeed(10f);
	}
	
	@Override
	public void simpleUpdate(float tpf) {
	
	}
	
}
