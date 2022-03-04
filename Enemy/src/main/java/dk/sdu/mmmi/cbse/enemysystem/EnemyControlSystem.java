package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;

import static java.lang.Math.PI;

/**
 *
 * @author jcs
 */
public class EnemyControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity enemy : world.getEntities(Enemy.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);
            LifePart lifePart = enemy.getPart(LifePart.class);

            float rnd = new Random().nextFloat();
            movingPart.setUp(rnd > 0.2f && rnd < 0.8f);
            movingPart.setLeft(rnd < 0.2f);
            movingPart.setRight(rnd > 0.9f);

            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);
            lifePart.process(gameData, enemy);

            updateShape(enemy);
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
