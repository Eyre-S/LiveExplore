package cc.sukazyo.jme.liveexplore.jme.debugging;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Quad;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;

public class DebugingAppState extends BaseAppState {
	
	private Node guiNode = new Node("InGameGui");
	private Node worldNode = new Node("DebugingWorld");
	
	private AssetManager assetManager;
	
	@Override
	protected void initialize(Application app) {
		
		// 配置基础程序
		SimpleApplication mainApp = (SimpleApplication) app;
		assetManager = app.getAssetManager();
		
		// 添加十字光标
		Spatial cross = getGameCross();
		guiNode.attachChild(cross);
		cross.setLocalTranslation(
				0.5f * (mainApp.getCamera().getWidth() - 32),
				0.5f * (mainApp.getCamera().getHeight() - 32),
				1000);
		
		// 添加小球物块
		addUnshadedSphere();
		
		// 加入至主场景
		mainApp.getGuiNode().attachChild(guiNode);
		mainApp.getRootNode().attachChild(worldNode);
		
	}
	
	@Override
	protected void cleanup(Application app) {
	
	}
	
	@Override
	protected void onEnable() {
	
	}
	
	@Override
	protected void onDisable() {
	
	}
	
	private Geometry getGameCross() {
		Quad quad = new Quad(32, 32);
		Geometry geom = new Geometry("Picture", quad);
		
		Texture tex = assetManager.loadTexture("assets/liveexplore/gui/cross.png");
		Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat.setTexture("ColorMap", tex);
		
		geom.setMaterial(mat);
		
//		// 将材质的混色模式设置为：BlendMode.Alpha
		mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);// 重要!
//		// 将Geometry的渲染序列设置为Transparent，这将使它在其他不透明物体绘制后再绘制。
//		geom.setQueueBucket(RenderQueue.Bucket.Transparent);
		
		return geom;
	}
	
//	private Geometry
	private void addUnshadedSphere() {
		// #1 加载一个无光材质
		Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat.getAdditionalRenderState().setWireframe(true);
		
		// #2 设置参数
		mat.setColor("Color", ColorRGBA.Red);// 小球的颜色。
		
		// #3 创造1个球体，应用此材质。
		Geometry geom = new Geometry("普通球体", new Sphere(20, 40, 1));
		geom.setMaterial(mat);
		
		geom.move(4, 3, 0);
		worldNode.attachChild(geom);
	}
}
