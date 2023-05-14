package lab3.location;

import java.util.ArrayList;
import java.util.Objects;
import lab3.characters.*;

public class Planet implements Location{
    protected ArrayList<People> passengeres = new ArrayList<>();

    public Planet(){
    }
    @Override
    public void addPassengeres(People... passengeres) {
        for (People passenger : passengeres) {
            this.passengeres.add(passenger);
        }
    }
    @Override
    public void removePassengeres(People... passengeres) {
        for (People passenger : passengeres) {
            this.passengeres.remove(passenger);
        }
    }
    @Override
    public void removePassenger(People people) {
        this.passengeres.remove(people);
    }
    @Override
    public void removePassengeres(ArrayList<People> pep){
        this.passengeres.clear();
    }

    public ArrayList<People> getPassengeres() {
        return passengeres;
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if ( getClass () != otherObject.getClass () )
            return false;
        Planet other = (Planet) otherObject;
        return Objects.equals(passengeres, other.passengeres);
    }
    @Override
    public int hashCode() {
        return Objects.hash(passengeres);
    }
    @Override
    public String toString(){
        return "Planet[passengers=" + passengeres + "]";
    }
}
