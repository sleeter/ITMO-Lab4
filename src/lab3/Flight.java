package lab3;

import lab3.characters.*;
import lab3.location.*;
import lab3.move.MoveOnEarth;
import lab3.move.MoveOnMoon;
import java.util.ArrayList;

public class Flight {
    public void flight(Earth earth, Moon moon, Spaceship IlonMusk, People Znayka,
                       People Neznayka, People Zvezdochkin, People Seledochka,
                       People Ponchik, People Fuksiya, ArrayList<People> pep,
                       MoveOnMoon MoveMoon, MoveOnEarth MoveEarth){
        MoveEarth.device(IlonMusk, pep);
        MoveEarth.move(earth, IlonMusk, earth.getPassengeres());

        IlonMusk.FromEarthToMoon(moon);

        MoveMoon.move(IlonMusk, moon, IlonMusk.getPassengeres());

        MoveMoon.findMoonStone(IlonMusk, moon);
        MoveMoon.device(IlonMusk, pep);
        try {
            MoveMoon.findPeople(IlonMusk, pep, Neznayka, Ponchik);
        }catch (Exception e){
            System.out.println("Without weightlessness module they can't find friends");
            MoveMoon.device(IlonMusk, pep);
        }

        MoveMoon.move(moon, IlonMusk, moon.getPassengeres());

        IlonMusk.FromMoonToEarth(earth);

        MoveEarth.move(IlonMusk, earth, IlonMusk.getPassengeres());
    }
}
