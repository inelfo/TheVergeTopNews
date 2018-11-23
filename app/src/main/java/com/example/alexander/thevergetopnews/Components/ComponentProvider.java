package com.example.alexander.thevergetopnews.Components;


import com.example.alexander.thevergetopnews.Components.network.INetwork;

// todo Dan: clean: unused imports, modifiers etc
public class ComponentProvider implements IComponentProvider{

    @Override
    public INetwork getNetwork() {
        return new MainRepository();
    }
}
