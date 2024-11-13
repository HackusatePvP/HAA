package me.piitex.game.listeners;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import me.piitex.game.HeroAdventure;
import me.piitex.renjava.events.EventListener;
import me.piitex.renjava.events.Listener;
import me.piitex.renjava.events.types.ButtonClickEvent;
import me.piitex.renjava.events.types.SideMenuBuildEvent;
import me.piitex.renjava.gui.Container;
import me.piitex.renjava.gui.layouts.VerticalLayout;
import me.piitex.renjava.gui.overlays.ButtonOverlay;

public class MenuModifierListener implements EventListener {
    private final HeroAdventure instance = HeroAdventure.getInstance();

    // Modify the main menu to include a DLC button
    @Listener
    public void onMainMenuModify(SideMenuBuildEvent event) {
        Container container = event.getContainer();
        VerticalLayout layout = (VerticalLayout) container.getLayouts().stream().filter(layout1 -> layout1 instanceof VerticalLayout).findAny().orElse(null);
        if (layout != null) {
            ButtonOverlay dlcButton = new ButtonOverlay("menu-dlc-button", "DLC", Color.BLACK, instance.getConfiguration().getUiFont(), Color.TRANSPARENT, Color.TRANSPARENT, instance.getConfiguration().getHoverColor());
            layout.addOverlay(dlcButton);
        }
    }

    @Listener
    public void onDLCClick(ButtonClickEvent event) {
        Button button = event.getButton();
        if (button.getId().equalsIgnoreCase("menu-dlc-button")) {
            // Open a new menu which shows DLC options???
        }
    }

}
