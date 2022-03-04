/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

/**
 *
 * @author Phillip O
 */
public enum AsteroidType {
    LARGE(6,25,10f, 8),
    MEDIUM(6,11,25f, 3),
    SMALL(5,5,50f, 1);

    private final int points;
    private final int size;
    private final float speed;
    private final int life;

    AsteroidType(int points, int size, float speed, int life) {
        this.points = points;
        this.size = size;
        this.speed = (float) Math.random() * 10f + speed;
        this.life = life;
    }

    public int getPoints() {
        return points;
    }

    public int getSize() {
        return size;
    }

    public float getSpeed() {
        return speed;
    }

    public int getLife() {
        return life;
    }
}
