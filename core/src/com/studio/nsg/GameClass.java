package com.studio.nsg;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.utils.IntMap;
import com.studio.nsg.Tools.ResourceManager;
import com.studio.nsg.components.AnimationComponent;
import com.studio.nsg.components.BodyComponent;
import com.studio.nsg.components.TextureComponent;
import com.studio.nsg.components.TransformComponent;
import com.studio.nsg.entities.Player;
import com.studio.nsg.ui.screens.GameScreen;
import com.studio.nsg.utils.AnimationStateList;
import com.studio.nsg.utils.FixtureBits.FixtureCategoryBits;

import java.awt.*;
import java.awt.geom.RectangularShape;


public class GameClass extends Game {
	private GameEngine engine;
	
	@Override
	public void create () {
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
