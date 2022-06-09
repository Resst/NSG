package com.studio.nsg.Tools;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class ResourceManager {
    private static final String MAPS_FOLDER = "Maps/";
    private static final String ATLAS_FOLDER = "Atlases/";
    private static final String[] ATLAS_NAMES = {"Test"};
    private static final String[] MAP_NAMES = {"Test"};
    private final AssetManager assetManager;
    public ResourceManager(){
        assetManager = new AssetManager();
        assetManager.setLoader(TiledMap.class, new TmxMapLoader());
        for (String atlas_name:
             ATLAS_NAMES) {
            assetManager.load(ATLAS_FOLDER + atlas_name + "/" + atlas_name + ".atlas", TextureAtlas.class);
        }
        for (String map_name:
                MAP_NAMES) {
            assetManager.load(MAPS_FOLDER + map_name + "/" + map_name + ".tmx", TiledMap.class);
        }
        assetManager.finishLoading();
    }
    public Animation<TextureRegion> getAnimation(String entity_name, String animation_type, float frameDuration, Animation.PlayMode mode) {
        TextureAtlas atlas = assetManager.get(ATLAS_FOLDER + ATLAS_NAMES[0] + "/" + ATLAS_NAMES[0] + ".atlas",TextureAtlas.class);
       return new Animation<>(frameDuration,atlas.findRegions(entity_name + "/" + animation_type+ "/" + animation_type), mode);
    }
    public Texture getTexture(String entity_name){
        TextureAtlas atlas = assetManager.get(ATLAS_FOLDER + ATLAS_NAMES[0]+".atlas",TextureAtlas.class);
        return atlas.findRegion(entity_name).getTexture();
    }
    public TiledMap getMap(String map_name){
        return assetManager.get(MAPS_FOLDER + map_name + "/" + map_name + ".tmx", TiledMap.class);
    }
    public void dispose(){
        assetManager.dispose();
    }

}
