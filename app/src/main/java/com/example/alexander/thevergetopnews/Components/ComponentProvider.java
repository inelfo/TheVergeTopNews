package com.example.alexander.thevergetopnews.Components;

import com.example.alexander.thevergetopnews.Components.network.INetwork;
import com.example.alexander.thevergetopnews.Components.network.NetworkImpl;

public class ComponentProvider implements IComponentProvider{
    private final INetwork network = new NetworkImpl();

    @Override
    public INetwork getNetwork() {
        return network;
    }
}
