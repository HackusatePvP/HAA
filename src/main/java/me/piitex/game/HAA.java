package me.piitex.game;

import me.piitex.game.listeners.CheatListener;
import me.piitex.renjava.addons.Addon;

/**
 * Unlike a RenJava game, an addon implements the framework differently. Addons can use the api the same way the actual game can.
 */
public class HAA extends Addon {
    private static HAA instance;

    public HAA() {
        super("Cheat Addon");
    }

    @Override
    public void onLoad() {
        instance = this;
        // Called when the framework starts this addon.

        // For this example I'm just going to make this addon give the player money.
        // First setup a key listener.
        registerListener(new CheatListener());

        // You can also do A LOT more with addons. You can create additional stories and characters. This is effectively a way to implement DLCS
    }

    @Override
    public void onDisable() {
        // Called when the application exists or unfortunately crashes.
    }

    public static HAA getInstance() {
        return instance;
    }
}
