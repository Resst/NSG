package com.studio.nsg.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.studio.nsg.components.PlayerComponent;
import com.studio.nsg.entities.Player;
import com.studio.nsg.utils.SystemPriorities;

public class PlayerControlSystem extends IteratingSystem {

    public PlayerControlSystem() {
        super(Family.all(PlayerComponent.class).get(), SystemPriorities.PLAYER_CONTROL);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        Player player = (Player) entity;

        Vector2 direction = new Vector2();

        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            direction.y += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            direction.y -= 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            direction.x += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            direction.x -= 1;
        }

        player.update();
        player.move(direction);

    }
}
