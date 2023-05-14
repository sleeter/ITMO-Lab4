package lab3.location;

import lab3.characters.People;
import lab3.moonstone.Moonstone;

import java.util.ArrayList;
import java.util.Objects;

public class Moon extends Planet {
    protected static String name = "Moon";
    protected static double g = 1.62;
    private double weigthofstoneonmoon = 0.0;
    private ArrayList<Moonstone> moonstones = new ArrayList<>(100);
    public Moon(){
        for (int i=0; i<100; ++i){
            Moonstone st = new Moonstone();
            moonstones.add(st);
            weigthofstoneonmoon += st.getWeight();
        }
    }

    public static String getName() {
        return name;
    }

    public static double getG() {
        return g;
    }

    public ArrayList<Moonstone> getMoonstones() {
        return moonstones;
    }
    public void removeMoonstones(Moonstone moonstone){
        this.moonstones.remove(moonstone);
    }

    public double getWeigthofstoneonmoon() {
        return weigthofstoneonmoon;
    }
    @Override
    public void removePassengeres(ArrayList<People> pep){
        super.removePassengeres(pep);
    }
    @Override
    public ArrayList<People> getPassengeres() {
        return super.getPassengeres();
    }

    @Override
    public void removePassengeres(People... passengeres) {
        super.removePassengeres(passengeres);
    }
    @Override
    public void removePassenger(People people) {
        super.removePassenger(people);
    }
    @Override
    public void addPassengeres(People... passengeres) {
        super.addPassengeres(passengeres);
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if ( getClass () != otherObject.getClass () )
            return false;
        if (!super.equals(otherObject)) return false;
        Moon other = (Moon) otherObject;
        return Objects.equals(name, other.name) && g == other.g
                && weigthofstoneonmoon == other.weigthofstoneonmoon
                && Objects.equals(moonstones, other.moonstones);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, g, super.passengeres, weigthofstoneonmoon, moonstones);
    }
    @Override
    public String toString(){
        return "Moon[name=" + name
                +", g=" + g
                +", passengeres=" + super.passengeres
                +", weightofstoneofmoon=" + weigthofstoneonmoon
                +", moonstones=" + moonstones + "]";
    }
}
