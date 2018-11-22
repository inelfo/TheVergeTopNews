package com.example.alexander.thevergetopnews.Components;

import java.lang.ref.WeakReference;

// todo Dan: clean: unused imports, modifiers etc
public class ComponentProvider implements IComponentProvider{

    @Override
    public INetwork getNetwork() {
        return new MainRepository();
    }
}
