package lab3.move;

import lab3.characters.People;
import lab3.location.*;

import java.util.ArrayList;

public abstract class MoveTo {
    public abstract void device(Spaceship spaceship, ArrayList<People> pep);
    public abstract void move(Location fir, Location sec, ArrayList<People> pep);
}
