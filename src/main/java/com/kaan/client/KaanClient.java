
package com.kaan.client;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KaanClient implements ModInitializer {
    public static KeyBinding guiKey;

    @Override
    public void onInitialize() {
        ClientModules.init();

        guiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.kaanclient.open_gui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_SHIFT,
                "category.kaanclient"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (guiKey.wasPressed()) {
                client.setScreen(new KaanClickGui());
            }
        });
    }
}
