package lab3.move;

import lab3.characters.*;
import lab3.location.*;

import java.util.ArrayList;

public class MoveOnEarth extends MoveTo{
    public void device(Spaceship spaceship, ArrayList<People> pep){
        for (People pr : pep)
            System.out.print(pr.getName() + " ");
        System.out.println("designed a spaceship and called it " + spaceship.getName());
    }
    @Override
    public void move(Location fir, Location sec, ArrayList<People> pep){
        for(People people : pep){
            sec.addPassengeres(people);
        }
        fir.removePassengeres(pep);
    }
}
