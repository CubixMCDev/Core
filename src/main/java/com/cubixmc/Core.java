package com.cubixmc;

import dev.waterdog.waterdogpe.event.defaults.ServerTransferEvent;
import dev.waterdog.waterdogpe.plugin.Plugin;

public class Core extends Plugin {
    public void onEnable() {
        saveResource("config.yml");

        getProxy().getEventManager().subscribe(ServerTransferEvent.class, event -> {
            loadConfig();
            event.setTransferScreenAllowed(getConfig().getBoolean("enable-transfer-screen", Boolean.valueOf(true)).booleanValue());
        });
    }
}