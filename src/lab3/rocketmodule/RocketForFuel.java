package lab3.rocketmodule;

import lab3.moonstone.Moonstone;

import java.util.Objects;

public class RocketForFuel{
    public double volume;
    public double fuelmas;

    public RocketForFuel(double volume, double fuelmas){
        this.volume = volume;
        this.fuelmas = fuelmas;
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if ( getClass () != otherObject.getClass () )
            return false;
        RocketForFuel other = (RocketForFuel) otherObject;
        return volume == other.volume && fuelmas == other.fuelmas;
    }
    @Override
    public int hashCode() {
        return Objects.hash(volume, fuelmas);
    }
    @Override
    public String toString(){
        return "RocketForFuel[volume=" + volume
                + ", fuelmas=" + fuelmas + "]";
    }
}
