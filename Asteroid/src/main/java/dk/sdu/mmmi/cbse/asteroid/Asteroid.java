/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.util.Random;


/**
 * @author Phillip O
 */
public class Asteroid extends Entity {

    private final AsteroidType type;
    private final int extraPoints;
    private float angle;

    public Asteroid(AsteroidType type) {
        this.type = type;
        this.extraPoints = new Random().nextInt(3);
        this.angle = (float) Math.random() * (float) Math.random();
   }

    public int getSize() {
        return type.getSize();
    }

    public int getPoints() {
        return type.getPoints() + extraPoints;
    }

    public float getSpeed() {
        return type.getSpeed();
    }

    public int getLife() {
        return type.getLife();
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getAngle() {
        return angle;
    }
}
