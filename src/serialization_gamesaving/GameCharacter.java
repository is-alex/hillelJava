package serialization_gamesaving;


import java.io.Serializable;
import java.util.Arrays;

public class GameCharacter implements Serializable {
    private static final long serialVersionUID = 1L;
    private int power;
    private String name;
    private CharacterType type;
    private String[] weapons;
    private int mana;

    public GameCharacter(int power, String name, CharacterType type, String[] weapons, int mana) {
        this.power = power;
        this.name = name;
        this.type = type;
        this.weapons = weapons;
        this.mana = mana;
    }

//    public GameCharacter(int power, String name, CharacterType type, String[] weapons) {
//        this.power = power;
//        this.name = name;
//        this.type = type;
//        this.weapons = weapons;
//    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public CharacterType getType() {
        return type;
    }
    public void setType(CharacterType type) {
        this.type = type;
    }
    public String[] getWeapons() {
        return weapons;
    }
    public void setWeapons(String[] weapons) {
        this.weapons = weapons;
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "power=" + power +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", weapons=" + Arrays.toString(weapons) +
                ", mana=" + mana +
                '}';
    }
}