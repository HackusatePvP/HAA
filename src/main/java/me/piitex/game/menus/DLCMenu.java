package me.piitex.game.menus;

import me.piitex.renjava.gui.DisplayOrder;
import me.piitex.renjava.gui.containers.EmptyContainer;

public class DLCMenu {
    private final EmptyContainer container;

    public DLCMenu(double x, double y, int width, int height, DisplayOrder order) {
        this.container = new EmptyContainer(x, y, width, height, order);
    }

    public void build() {
        //TODO: Render DLC menu which can be used to render different stories for the DLC
    }
}
