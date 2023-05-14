package lab3.location;

import lab3.characters.People;

import java.util.ArrayList;
import java.util.Objects;

public class Earth extends Planet{
    protected static String name = "Earth";
    protected static double g = 9.8;
    public Earth(){}

    public static double getG() {
        return g;
    }

    public static String getName() {
        return name;
    }

    @Override
    public ArrayList<People> getPassengeres() {
        return super.getPassengeres();
    }

    @Override
    public void addPassengeres(People... passengeres) {
        super.addPassengeres(passengeres);
    }
    @Override
    public void removePassenger(People people) {
        super.removePassenger(people);
    }
    @Override
    public void removePassengeres(ArrayList<People> pep){
        super.removePassengeres(pep);
    }
    @Override
    public void removePassengeres(People... passengeres) {
        super.removePassengeres(passengeres);
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if ( getClass () != otherObject.getClass () )
            return false;
        if (!super.equals(otherObject)) return false;
        Earth other = (Earth) otherObject;
        return Objects.equals(name, other.name) && g == other.g;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, g, super.passengeres);
    }
    @Override
    public String toString(){
        return "Earth[name=" + name
                +", g=" + g
                +", passengeres=" + super.passengeres + "]";
    }
}
