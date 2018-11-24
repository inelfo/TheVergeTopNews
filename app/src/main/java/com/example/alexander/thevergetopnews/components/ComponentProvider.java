package com.example.alexander.thevergetopnews.components;

import android.app.Application;

import com.example.alexander.thevergetopnews.components.network.INetwork;
import com.example.alexander.thevergetopnews.components.network.NetworkImpl;

public class ComponentProvider implements IComponentProvider{
    private final INetwork network = new NetworkImpl();

    private final Application app;

    public ComponentProvider(Application app) {
        this.app = app;
    }

    @Override
    public INetwork getNetwork() {
        return network;
    }
}
