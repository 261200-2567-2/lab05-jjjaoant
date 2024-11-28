import java.util.ArrayList;
import java.util.List;

public class Fighter implements RPGCharacter {
    private String name;
    private int damage;
    private int hp;
    private int mana;
    private int speed;
    private int defense;
    private int level = 1;
    private List<Accessories> accessories = new ArrayList<>();

    public Fighter() {
        this.name = "Thanos";
        this.damage = 80;
        this.hp = 150;
        this.mana = 0;
        this.speed = 40;
        this.defense = 50;
        System.out.println(name + " is fully equipped with Sword, Boots, and Cloak.");
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with " + damage + " damage!");
    }

    @Override
    public void equipAccessories(Accessories accessory) {
        System.out.println("Fighter is pre-equipped. No accessories can be added.");
    }

    @Override
    public void levelUp() {
        level++;
        hp += 20;
        speed += 5;
        defense += 5;
        damage += 10;
        System.out.println(name + " levels up to level " + level + "!");
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void castSpell(String spell) {
        System.out.println(name + " cannot cast spells!");
    }
}
