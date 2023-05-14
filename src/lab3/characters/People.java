package lab3.characters;

import java.util.Objects;

public class People implements Character {
    final private String name;
    private boolean canmakemodule = false;

    public People(String name){
        this.name = name;
    }
    @Override
    public void say(String text){
        System.out.println(name + " says \"" + text + "\"");
    }
    public void exclaimed(String text){
        System.out.println(name + " exclaims \"" + text + "\"");
    }
    public String getName() {
        return name;
    }

    public void setCanmakemodule(boolean canmakemodule) {
        this.canmakemodule = canmakemodule;
    }

    public boolean isCanmakemodule() {
        return canmakemodule;
    }

    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if ( getClass () != otherObject.getClass () )
            return false;
        People other = (People) otherObject;
        return Objects.equals(name, other.name) && canmakemodule == other.canmakemodule;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, canmakemodule);
    }
    @Override
    public String toString(){
        return "People[name=" + name
                + ", canmakemodule=" + canmakemodule + "]";
    }
}