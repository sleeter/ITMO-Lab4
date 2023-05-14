package lab3.move;

import java.util.ArrayList;
import lab3.characters.*;
import lab3.location.*;
import lab3.moonstone.Moonstone;

import java.lang.Math;

public class MoveOnMoon extends MoveTo{
    class MissingThingExeption extends Exception{
        public MissingThingExeption(String message){
            super(message);
        }
    }
    public void findPeople(Spaceship spaceship, ArrayList<People> pep, People first, People second) throws MissingThingExeption{
            if (!spaceship.isWeightlessnessmodule()) {
                throw new MissingThingExeption("They don't have a weigthlessness module");
            } else {
                System.out.println("The guys start to find " + first.getName() + " and " + second.getName());
                int sun = (int) Math.round((Math.random() * 1.3) + 0.2);
                if (sun == 0) {
                    System.out.println("There are electromagnetic storms in the sun today, so they can't go to find their friends");
                }
                int fir = (int) Math.round((Math.random() * 4) - 0.5);
                pep.get(fir).exclaimed("I find " + first.getName() + "!");
                int sec = (int) Math.round((Math.random() * 4) - 0.5);
                while (sec == fir) {
                    sec = (int) Math.round((Math.random() * 4) - 0.5);
                }
                pep.get(sec).exclaimed("I find " + second.getName() + " too!");
            }
    }
    public void findMoonStone(Spaceship spaceship, Moon moon){
        System.out.println("Heroes go to the cave to the moonstone");
        int Day = 1;
        double needstone = 0.5 * moon.getWeigthofstoneonmoon();
        do {
            for(Moonstone moonstone : moon.getMoonstones()){
                if((Math.pow(moonstone.getX(), 2) + Math.pow(moonstone.getY(), 2) < Math.pow(Day, 2))
                && (Math.pow(moonstone.getX(), 2) + Math.pow(moonstone.getY(), 2) > Math.pow(Day - 1, 2))) {
                    spaceship.addMoonstone(moonstone);
                }
            }
            System.out.println("In " + Day + " day people collected " +
                    (spaceship.getWeightofstone()*100/needstone) + "% of the required stone");
            Day++;
        }while (spaceship.getWeightofstone() < needstone);
    }
    @Override
    public void device(Spaceship spaceship, ArrayList<People> pep){
                boolean mod = false;
                People whomakemodule = null;
                for (People people : pep) {
                    if (people.isCanmakemodule()) {
                        mod = true;
                        whomakemodule = people;
                    }
                }
                    if (mod && whomakemodule != null) {
                        System.out.println(whomakemodule.getName() + " create a weightlessness module to spaceship");
                        int i = (int) Math.round((Math.random() * 4) - 0.5);
                        int k = (int) Math.round((Math.random() * 4) - 0.5);
                        while (i == k) {
                            k = (int) Math.round((Math.random() * 4) - 0.5);
                        }
                        System.out.println(pep.get(i).getName() + " and " + pep.get(k).getName() + " install the module to spaceship");
                        spaceship.setWeightlessnessmodule(true);
                        System.out.println("Now they can try to find their friend");
            }
    }
    @Override
    public void move(Location fir, Location sec, ArrayList<People> pep){
        for(People people : pep){
            sec.addPassengeres(people);
        }
        fir.removePassengeres(pep);
    }

}
