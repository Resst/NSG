package com.studio.nsg;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.IntMap;
import com.studio.nsg.Tools.ResourceManager;
import com.studio.nsg.components.AnimationComponent;
import com.studio.nsg.components.TextureComponent;
import com.studio.nsg.components.TransformComponent;
import com.studio.nsg.ui.screens.GameScreen;
import com.studio.nsg.utils.AnimationStateList;


public class GameClass extends Game {
	private GameEngine engine;

	ResourceManager rm;
	
	@Override
	public void create () {
		rm = new ResourceManager();
		engine = new GameEngine();
		setScreen(new GameScreen(this));
		/* Тестовый объекст с анимацией на экране
		TransformComponent transformComponent = new TransformComponent();
		transformComponent.position = new Vector2(10f,10f);
		transformComponent.scale = new Vector2(0.2f,0.2f);
		transformComponent.rotation = 0f;
		AnimationComponent animationComponent = new AnimationComponent();
		animationComponent.state = 0;
		animationComponent.animation = new IntMap<Animation<TextureRegion>>();
		animationComponent.animation.put(AnimationStateList.IDLE,rm.getAnimation("Big Demon","idle",0.5f, Animation.PlayMode.LOOP));
		TextureComponent textureComponent = new TextureComponent();
		textureComponent.sprite = new Sprite(rm.getTextureRegion("TestHui"));
		Entity entity = new Entity();
		entity.add(transformComponent).add(textureComponent).add(animationComponent);
		engine.addEntity(entity);
		*/
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
	}
	public GameEngine getEngine(){
		return engine;
	}
}
