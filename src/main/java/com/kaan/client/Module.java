
package com.kaan.client;

public abstract class Module {
    private final String name;
    private boolean toggled;

    public Module(String name) {
        this.name = name;
    }

    public void toggle() {
        this.toggled = !this.toggled;
        if (toggled) onEnable();
        else onDisable();
    }

    public void onEnable() {}
    public void onDisable() {}
    public void onTick() {}
    public void onRender3D() {}
    
    public void openRightClickSettings() {
        System.out.println(name + " modülünün sağ tık ayarları açıldı.");
    }

    public String getName() { return name; }
    public boolean isToggled() { return toggled; }
}
