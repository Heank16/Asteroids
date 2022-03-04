package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.LEFT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.RIGHT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.UP;
import static java.lang.Math.PI;

import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

/**
 *
 * @author jcs
 */
public class PlayerControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity player : world.getEntities(Player.class)) {
            PositionPart positionPart = player.getPart(PositionPart.class);
            MovingPart movingPart = player.getPart(MovingPart.class);
            LifePart lifePart = player.getPart(LifePart.class);

            movingPart.setLeft(gameData.getKeys().isDown(LEFT));
            movingPart.setRight(gameData.getKeys().isDown(RIGHT));
            movingPart.setUp(gameData.getKeys().isDown(UP));

            movingPart.process(gameData, player);
            positionPart.process(gameData, player);
            lifePart.process(gameData, player);

            updateShape(player);
        }
    }

    private void updateShape(Entity entity) {
        float radius = entity.getRadius();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        float[] shapeX = new float[4], shapeY = new float[4];

        shapeX[0] = (float) (x + Math.cos(radians) * radius);
        shapeY[0] = (float) (y + Math.sin(radians) * radius);

        shapeX[1] = (float) (x + Math.cos(radians - 4 * PI / 5) * radius);
        shapeY[1] = (float) (y + Math.sin(radians - 4 * PI / 5) * radius);

        shapeX[2] = (float) (x + Math.cos(radians + PI) * radius * 0.625);
        shapeY[2] = (float) (y + Math.sin(radians + PI) * radius * 0.625);

        shapeX[3] = (float) (x + Math.cos(radians + 4 * PI / 5) * radius);
        shapeY[3] = (float) (y + Math.sin(radians + 4 * PI / 5) * radius);

        entity.setShapeX(shapeX);
        entity.setShapeY(shapeY);
    }

}
