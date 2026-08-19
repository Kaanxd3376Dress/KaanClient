
package com.kaan.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class KaanClickGui extends Screen {

    public KaanClickGui() {
        super(Text.literal("Kaan Client GUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        
        context.drawCenteredTextWithShadow(this.textRenderer, "=== KAAN CLIENT v1.21.11 ===", this.width / 2, 15, 0xFF0000);
        context.drawCenteredTextWithShadow(this.textRenderer, "Sol Tık: Aç/Kapat | Sağ Tık: Modül Ayarları", this.width / 2, 30, 0xAAAAAA);

        int y = 50;
        for (Module mod : ClientModules.modules) {
            int color = mod.isToggled() ? 0xFF00FF00 : 0xFFFF0000;
            context.fill(50, y, 260, y + 20, 0x90000000);
            context.drawTextWithShadow(this.textRenderer, mod.getName(), 60, y + 6, color);
            y += 24;
        }

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int y = 50;
        for (Module mod : ClientModules.modules) {
            if (mouseX >= 50 && mouseX <= 260 && mouseY >= y && mouseY <= y + 20) {
                if (button == 0) { 
                    mod.toggle();
                } else if (button == 1) { 
                    mod.openRightClickSettings();
                }
                return true;
            }
            y += 24;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
