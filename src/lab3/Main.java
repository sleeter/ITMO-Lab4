package lab3;

import lab3.characters.*;
import lab3.location.*;
import lab3.move.*;
import lab3.rocketmodule.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var Znayka = new People("Znayka"){

            public void makemodule(){
                System.out.println("I'm(" + this.getName() + ") create a weightlessness module to spaceship");
            }
        };
        Znayka.setCanmakemodule(true);
        People Zvezdochkin = new People("Zvezdochkin");
        People Seledochka = new People("Seledochka");
        People Fuksiya = new People("Fuksiya");
        People Neznayka = new People("Neznayka");
        People Ponchik = new People("Ponchik");

        Earth earth = new Earth();
        earth.addPassengeres(Znayka, Zvezdochkin, Seledochka, Fuksiya);
        ArrayList<People> pep = (ArrayList<People>)earth.getPassengeres().clone();
        Moon moon = new Moon();
        moon.addPassengeres(Neznayka, Ponchik);

        RocketForFuel firstrocket = new RocketForFuel(3,900000);
        RocketForFuel secondrocket = new RocketForFuel(2,600000);
        RocketForFuel thirdrocket = new RocketForFuel(1,300000);
        Spaceship IlonMusk = new Spaceship("IlonMusk", new RocketForThings(1, 300000),
                firstrocket, secondrocket, thirdrocket);
        IlonMusk.setConditions(Spaceship.Conditions.ATTRACHED);
        MoveOnEarth MoveEarth = new MoveOnEarth();
        MoveOnMoon MoveMoon = new MoveOnMoon();
        Znayka.makemodule();
        Flight go = new Flight();
        go.flight(earth, moon, IlonMusk, Znayka, Neznayka,
                Zvezdochkin, Seledochka, Ponchik, Fuksiya, pep, MoveMoon, MoveEarth);
    }
}