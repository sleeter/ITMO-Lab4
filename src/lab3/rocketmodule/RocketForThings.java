package lab3.rocketmodule;

import lab3.characters.People;
import lab3.location.Location;
import lab3.moonstone.Moonstone;

import java.util.ArrayList;
import java.util.Objects;

public class RocketForThings implements Location {
    final private double volume;
    final private double fuelmas;
    private int countofpassengers = 0;
    protected ArrayList<Moonstone> baggageforstone = new ArrayList<>();
    private double weightofstone = 0.0;
    private boolean weightlessnessmodule = false;
    protected ArrayList<People> passengeres = new ArrayList<>(12);

    public RocketForThings(double volume, double fuelmas){
        this.volume = volume;
        this.fuelmas = fuelmas;
    }

    public void setWeightlessnessmodule(boolean weightlessnessmodule) {
        this.weightlessnessmodule = weightlessnessmodule;
    }

    public boolean isWeightlessnessmodule() {
        return weightlessnessmodule;
    }

    public void addBaggageforstone(Moonstone moonstonestone) {
        this.baggageforstone.add(moonstonestone);
        weightofstone += moonstonestone.getWeight();
    }

    public ArrayList<People> getPassengeres() {
        return passengeres;
    }

    @Override
    public void addPassengeres(People... passengeres) {
        class OvercrowdingExeption extends RuntimeException{
            public OvercrowdingExeption(){
                super("Вы не можете добавить этого пассажира в ракету. Колличество мест ограничено.");
            }
        }
        for (People passenger : passengeres) {
            if (countofpassengers < 12)
                this.passengeres.add(passenger);
            else throw new OvercrowdingExeption();
        }
    }
    @Override
    public void removePassengeres(People... passengeres) {
        for (People passenger : passengeres) {
            this.passengeres.remove(passenger);
        }
    }
    @Override
    public void removePassengeres(ArrayList<People> pep){
        this.passengeres.clear();
    }
    @Override
    public void removePassenger(People people) {
        this.passengeres.remove(people);
    }

    public double getWeightofstone() {
        return weightofstone;
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if ( getClass () != otherObject.getClass () )
            return false;
        RocketForThings other = (RocketForThings) otherObject;
        return volume == other.volume && fuelmas == other.fuelmas
                && Objects.equals(baggageforstone, other.baggageforstone)
                && weightofstone == other.weightofstone
                && weightlessnessmodule == other.weightlessnessmodule
                && Objects.equals(passengeres, other.passengeres);
    }
    @Override
    public int hashCode() {
        return Objects.hash(volume, fuelmas, baggageforstone, weightofstone, weightlessnessmodule, passengeres);
    }
    @Override
    public String toString(){
        return "RocketForThings[volume=" + volume
                + ", fuelmas=" + fuelmas
                +", baggageforstone=" + baggageforstone
                +", weightofstone=" + weightofstone
                +", weightlessnessmodule=" + weightlessnessmodule
                +", passengeres=" + passengeres + "]";
    }
}
