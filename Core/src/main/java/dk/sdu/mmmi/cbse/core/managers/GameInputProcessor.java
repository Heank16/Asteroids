package dk.sdu.mmmi.cbse.core.managers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;

public class GameInputProcessor extends InputAdapter {

    private final GameData gameData;

    public GameInputProcessor(GameData gameData) {
        this.gameData = gameData;
    }

    public boolean keyDown(int k) {
        if (k == Keys.UP) {
            gameData.getKeys().setKey(GameKeys.UP, true);
        } else if (k == Keys.LEFT) {
            gameData.getKeys().setKey(GameKeys.LEFT, true);
        } else if (k == Keys.DOWN) {
            gameData.getKeys().setKey(GameKeys.DOWN, true);
        } else if (k == Keys.RIGHT) {
            gameData.getKeys().setKey(GameKeys.RIGHT, true);
        } else if (k == Keys.ENTER) {
            gameData.getKeys().setKey(GameKeys.ENTER, true);
        } else if (k == Keys.ESCAPE) {
            gameData.getKeys().setKey(GameKeys.ESCAPE, true);
        } else if (k == Keys.SPACE) {
            gameData.getKeys().setKey(GameKeys.SPACE, true);
        } else if (k == Keys.SHIFT_LEFT || k == Keys.SHIFT_RIGHT) {
            gameData.getKeys().setKey(GameKeys.SHIFT, true);
        }
        return true;
    }

    public boolean keyUp(int k) {
        if (k == Keys.UP) {
            gameData.getKeys().setKey(GameKeys.UP, false);
        } else if (k == Keys.LEFT) {
            gameData.getKeys().setKey(GameKeys.LEFT, false);
        } else if (k == Keys.DOWN) {
            gameData.getKeys().setKey(GameKeys.DOWN, false);
        } else if (k == Keys.RIGHT) {
            gameData.getKeys().setKey(GameKeys.RIGHT, false);
        } else if (k == Keys.ENTER) {
            gameData.getKeys().setKey(GameKeys.ENTER, false);
        } else if (k == Keys.ESCAPE) {
            gameData.getKeys().setKey(GameKeys.ESCAPE, false);
        } else if (k == Keys.SPACE) {
            gameData.getKeys().setKey(GameKeys.SPACE, false);
        } else if (k == Keys.SHIFT_LEFT || k == Keys.SHIFT_RIGHT) {
            gameData.getKeys().setKey(GameKeys.SHIFT, false);
        }
        return true;
    }

}








