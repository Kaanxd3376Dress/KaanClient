
package com.kaan.client;

import java.util.ArrayList;
import java.util.List;

public class ClientModules {
    public static List<Module> modules = new ArrayList<>();

    public static void init() {
        modules.add(new Module("Storage ESP") {});
        modules.add(new Module("Player ESP") {});
        modules.add(new Module("Block ESP") {});
        modules.add(new Module("Chunk Finder / NewChunks") {});
        modules.add(new Module("Prime Chunk Finder") {});
        modules.add(new Module("Base Finder") {});
        modules.add(new Module("Freecam") {});
        modules.add(new Module("Hitbox Expander") {});
        modules.add(new Module("Fling") {});
    }
}
