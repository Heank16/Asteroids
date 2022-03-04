package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

import static java.lang.Math.PI;

public class AsteroidPlugin implements IGamePluginService {
    private Entity asteroid;

    @Override
    public void start(GameData gameData, World world) {
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData) {
        float radians = (float) PI / 2 + (float) Math.random();
        float x = new Random().nextFloat() * gameData.getDisplayWidth();
        float y = new Random().nextFloat() * gameData.getDisplayHeight();

        int radNum = new Random().nextInt(150) % 3; // get random number between 0 and 2

        Asteroid asteroid = new Asteroid(AsteroidType.values()[radNum]);

        asteroid.setRadius(asteroid.getSize());
        asteroid.add(new MovingPart(0, asteroid.getSpeed(), asteroid.getSpeed(), 0));
        asteroid.add(new LifePart(asteroid.getLife()));
        asteroid.add(new PositionPart(x, y, radians));

        return asteroid;
    }
}
