package lab3.location;

import lab3.characters.*;

import java.util.ArrayList;

public interface Location {
    void addPassengeres(People ... passengeres);
    void removePassengeres(People ... passengeres);
    void removePassenger(People people);
    void removePassengeres(ArrayList<People> pep);
}
