/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

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
 * @author Phillip O
 */
public class AsteroidControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);
            LifePart lifePart = asteroid.getPart(LifePart.class);

            movingPart.setUp(true);
            movingPart.setLeft(new Random().nextInt(10) > 7);

            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);
            lifePart.process(gameData, asteroid);

            updateShape(asteroid);
        }
    }

    private void updateShape(Entity entity) {
        Asteroid asteroid = (Asteroid) entity;

        int numPoints = asteroid.getPoints();
        float radius = asteroid.getRadius();
        float angle = asteroid.getAngle() - (float) Math.random() / 100;
        PositionPart positionPart = asteroid.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        float[] shapeX = new float[numPoints], shapeY = new float[numPoints];

        for (int i = 0; i < numPoints; i++) {

            shapeX[i] = x + (float) Math.cos(radians + angle) * radius;
            shapeY[i] = y + (float) Math.sin(radians + angle) * radius;

            angle += (2 * PI / numPoints);
        }

        asteroid.setAngle(angle);
        asteroid.setShapeX(shapeX);
        asteroid.setShapeY(shapeY);
    }

}
