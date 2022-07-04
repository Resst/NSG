package com.studio.nsg.Tools.box2dBuilders;

import com.badlogic.gdx.physics.box2d.Filter;

public class FilterBuilder {
    private Filter filter;
    public FilterBuilder(){
        filter = new Filter();
    }
    public Filter build(){
        Filter filter1 = filter;
        filter = new Filter();
        return filter1;
    }
    public FilterBuilder setGroupIndex(short groupIndex){
        filter.groupIndex = groupIndex;
        return this;
    }
    public FilterBuilder setCategoryBits(short categoryBits){
        filter.categoryBits = categoryBits;
        return this;
    }
    public FilterBuilder setMaskBits(short maskBits){
        filter.maskBits = maskBits;
        return this;
    }

}
