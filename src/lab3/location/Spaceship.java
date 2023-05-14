package lab3.location;

import java.util.ArrayList;
import java.util.Objects;
import lab3.characters.*;
import lab3.moonstone.Moonstone;
import lab3.rocketmodule.RocketForFuel;
import lab3.rocketmodule.RocketForThings;


public class Spaceship implements Location, FromTo{
    private Conditions conditions;
    protected ArrayList<RocketForFuel> rocketForFuels = new ArrayList<>(3);
    final private RocketForThings rocketForThings;
    final private String name;


    public enum Conditions {
        ATTRACHED("attract to the Earth"), WEIGHTLESSNESS("weightlessness");
        private String state;

        private Conditions(String phrase) {
            state = phrase;
        }
    }

    public Spaceship(String name, RocketForThings rocketForThings, RocketForFuel... rocketForFuels){
        this.name = name;
        this.rocketForThings = rocketForThings;
        for(RocketForFuel rocketForFuel : rocketForFuels)
            this.rocketForFuels.add(rocketForFuel);
    }

    @Override
    public void removePassengeres(ArrayList<People> pep) {
        this.rocketForThings.removePassengeres(pep);
    }

    @Override
    public void addPassengeres(People... passengeres) {
        rocketForThings.addPassengeres(passengeres);
    }
    @Override
    public void removePassengeres(People... passengeres) {
        rocketForThings.removePassengeres(passengeres);
    }
    @Override
    public void removePassenger(People people) {
        rocketForThings.removePassenger(people);
    }
    public void setWeightlessnessmodule(boolean weightlessnessmodule) {
        this.rocketForThings.setWeightlessnessmodule(weightlessnessmodule);
    }
    public void deleteRocketForFuel(RocketForFuel rocketForFuel){
        this.rocketForFuels.remove(rocketForFuel);
        System.out.println((3-rocketForFuels.size()) + " propellant rocket disconnected");
    }
    public void addMoonstone(Moonstone moonstone){
        rocketForThings.addBaggageforstone(moonstone);
    }
    public double getWeightofstone(){
        return rocketForThings.getWeightofstone();
    }

    public boolean isWeightlessnessmodule() {
        return rocketForThings.isWeightlessnessmodule();
    }
    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }
    public Conditions getConditions() {
        return conditions;
    }
    public String getState() {
        return conditions.state;
    }
    @Override
    public void FromEarthToMoon(Moon moon){
        System.out.println("The rocket starts to take off from Earth");
        for(People passenger : rocketForThings.getPassengeres()){
            System.out.print(passenger.getName() + " ");
        }
        System.out.print("fly to the moon\nSpaceship is " + conditions.state + "\n");
        deleteRocketForFuel(rocketForFuels.get(0));
        System.out.println("The ship take off into outer space");
        deleteRocketForFuel(rocketForFuels.get(0));
        conditions = Conditions.WEIGHTLESSNESS;
        System.out.println("Spaceship is " + conditions.state);
        deleteRocketForFuel(rocketForFuels.get(0));
        System.out.println("The ship land on the Moon\n" +
                "Quantity value g = " + moon.getG() + " is very small\n" +
                "therefore spaceship is " + conditions.state);
    }
    @Override
    public void FromMoonToEarth(Earth earth){
        System.out.println("Guys board to ship\nThe rocket starts to take off from Moon");
        for(People passenger : rocketForThings.getPassengeres()){
            System.out.print(passenger.getName() + " ");
        }
        System.out.print("come back to Earth\nSpaceship is " + conditions.state
                + "\nThe ship enters the atmosphere\n");
        conditions = Conditions.ATTRACHED;
        System.out.println("Spaceship is " + conditions.state + "\nThe ship land on the Earth\n" +
                "Everyone is happy that the flight was a success");
    }
    public String getName(){
        return name;
    }
    public ArrayList<People> getPassengeres() {
        return rocketForThings.getPassengeres();
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if ( getClass () != otherObject.getClass () )
            return false;
        Spaceship other = (Spaceship) otherObject;
        return Objects.equals(name, other.name)
                && Objects.equals(conditions, other.conditions)
                && Objects.equals(rocketForFuels, other.rocketForFuels)
                && Objects.equals(rocketForThings, other.rocketForThings);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, conditions, rocketForFuels,
                rocketForThings);
    }
    @Override
    public String toString(){
        return "Planet[name=" + name
                + ", conditions=" + conditions
                + ", rocketForFuels=" + rocketForFuels
                + ", rocketForThings=" + rocketForThings + "]";
    }
}
