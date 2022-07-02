package com.studio.nsg.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class TextureComponent implements Component {
    public Sprite sprite = new Sprite();
    public int priority;
}
