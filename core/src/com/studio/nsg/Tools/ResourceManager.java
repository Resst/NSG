package com.studio.nsg.Tools;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ResourceManager {
    //Папка, в которой хранятся атласы с текстурами
    private static final String ATLAS_FOLDER = "Atlas_Tests/Atlas/";
    //Список всех атласов (потом можно будет автоматизировать (или нет, их много не будет (скорее всего будет только один)))
    private static final String[] ATLAS_NAMES = {"Test.Atlas"};
    private AssetManager assetManager;
    public ResourceManager(){
        assetManager = new AssetManager();
        for (String atlas_name:
             ATLAS_NAMES) {
            assetManager.load(ATLAS_FOLDER + atlas_name, TextureAtlas.class);
        }
        assetManager.finishLoading();
    }
    public Animation getAnimation(String entity_name, String animation_type, float frameDuration, Animation.PlayMode mode)
    {
        TextureAtlas atlas = assetManager.get(ATLAS_FOLDER + "Test.atlas",TextureAtlas.class);
       return new Animation<TextureRegion>(frameDuration,atlas.findRegions(entity_name + "/" + animation_type+ "/" + animation_type), mode);
    }
    public Texture getTexture(String Entity_name){
        TextureAtlas atlas = assetManager.get(ATLAS_FOLDER + "Test.atlas",TextureAtlas.class);
        return atlas.findRegion(Entity_name).getTexture();
    }
    public void dispose(){
        assetManager.dispose();
    }

}
