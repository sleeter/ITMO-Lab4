package lab3.moonstone;

import lab3.location.Spaceship;

import java.util.Objects;

public class Moonstone {
    final private double x;
    final private double y;
    final private double weight;

    public Moonstone(){
        x = (Math.random() * 10) - 5;
        y = (Math.random() * 10) - 5;
        weight = Math.random() * 10;
    }

    public double getWeight() {
        return weight;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if ( getClass () != otherObject.getClass () )
            return false;
        Moonstone other = (Moonstone) otherObject;
        return weight == other.weight && x == other.x && y == other.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(weight, x, y);
    }
    @Override
    public String toString(){
        return "Moonstone[weight=" + weight
                + ", x=" + x
                + ", y=" + y + "]";
    }
}
