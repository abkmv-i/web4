package com.lab.server;

import com.lab.server.entities.Coordinates;
import org.springframework.stereotype.Service;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

@Service
public class AttemptValidator {

    public boolean hitCheck(Coordinates coordinates) {
        return (secondQuarterHitCheck(coordinates) || thirdQuarterHitCheck(coordinates)
                || fourQuarterHitCheck(coordinates));
    }

    private boolean secondQuarterHitCheck(Coordinates coordinates) {
        if (coordinates.getR() < 0) {
            double newX = -coordinates.getX();
            double newY = -coordinates.getY();
            return ((coordinates.getR()) <= newY && newX >= 0 && newY <= 0 && newX <= (-coordinates.getR() / 2));

        }
        return ((coordinates.getR()) >= coordinates.getY() && coordinates.getX() <= 0 && coordinates.getY() >= 0
                && coordinates.getX() >= (-coordinates.getR() / 2));
    }

    private boolean thirdQuarterHitCheck(Coordinates coordinates) {
        if (coordinates.getR() < 0) {
            double newX = -coordinates.getX();
            double newY = -coordinates.getY();
            return (newX <= 0 && newY <= 0 && newY >= (-newX / 2 + (coordinates.getR() / 2)));
        }
        return (coordinates.getX() >= 0 && coordinates.getY() >= 0
                && coordinates.getY() <= (-coordinates.getX() / 2 + (coordinates.getR() / 2)));
    }

    private boolean fourQuarterHitCheck(Coordinates coordinates) {
        if (coordinates.getR() < 0) {
            double newX = -coordinates.getX();
            double newY = -coordinates.getY();
            return ((pow(newX, 2) + pow(newY, 2) <= pow(coordinates.getR(),2) && newX <= 0 && newY >= 0));
        }
        return ((pow(coordinates.getX(), 2) + pow(coordinates.getY(), 2) <= pow(coordinates.getR(),2)
                && coordinates.getX() >= 0 && coordinates.getY() <= 0));
    }

}
