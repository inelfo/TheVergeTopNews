package com.example.alexander.thevergetopnews.Components;

import java.lang.ref.WeakReference;

public class ComponentProvider implements IComponentProvider{


    @Override
    public INetwork getNetwork() {
        return new MainRepository();
    }
}
