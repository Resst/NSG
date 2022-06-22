package com.studio.nsg;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.studio.nsg.Tools.ResourceManager;
import com.studio.nsg.components.TextureComponent;
import com.studio.nsg.components.TransformComponent;
import com.studio.nsg.ui.screens.GameScreen;


public class GameClass extends Game {
	private GameEngine engine;

	ResourceManager rm;
	
	@Override
	public void create () {
		rm = new ResourceManager();
		engine = new GameEngine();
		setScreen(new GameScreen(this));
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
