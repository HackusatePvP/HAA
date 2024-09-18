package me.piitex.game.listeners;


import javafx.scene.input.KeyCode;
import me.piitex.game.HAA;
import me.piitex.game.HeroAdventure;
import me.piitex.game.characters.YouCharacter;
import me.piitex.renjava.api.scenes.RenScene;
import me.piitex.renjava.events.EventListener;
import me.piitex.renjava.events.Listener;
import me.piitex.renjava.events.types.KeyPressEvent;

public class CheatListener implements EventListener {

    @Listener
    public void onCheatKey(KeyPressEvent event) {
        // First we need to check to make sure they are in the game not on the main menu.
        RenScene currentScene = HeroAdventure.getInstance().getPlayer().getCurrentScene();
        if (currentScene != null) {
            // When they push the 'h' key lets give the main character 10 gold.
            if (event.getEvent().getCode() == KeyCode.H) {
                YouCharacter youCharacter = (YouCharacter) HeroAdventure.getInstance().getCharacter("mc");
                youCharacter.setGold(youCharacter.getGold() + 10); // Easy peasy

                // Since there is no way to view this change in the game, lets print it with the addon logger.
                HAA.getInstance().getLogger().info("Gold: {}", youCharacter.getGold());
            }
        }
    }
}
