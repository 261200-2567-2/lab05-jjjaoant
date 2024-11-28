import java.util.ArrayList;
import java.util.List;

public class Wizard implements RPGCharacter {
    private String name;
    private String house;
    private int damage;
    private int hp;
    private int mana;
    private int speed;
    private int defense;
    private int level = 1;
    private List<Accessories> accessories = new ArrayList<>();

    public Wizard(String name, String house, int damage) {
        this.name = name;
        this.house = house;
        this.damage = damage;
        this.hp = 100;
        this.mana = 100;
        this.speed = 50;
        this.defense = 30;
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with " + damage + " damage!");
    }

    @Override
    public void equipAccessories(Accessories accessory) {
        accessories.add(accessory);
        System.out.println(name + " equips " + accessory.getName() + ". Effect: " + accessory.getEffect());
        applyAccessoriesEffect(accessory);
    }

    private void applyAccessoriesEffect(Accessories accessory) {
        switch (accessory.getName()) {
            case "Broomstick":
                speed += 30;
                break;
            case "Wand":
                damage += 20;
                break;
            case "Boots":
                speed += 10;
                break;
            case "Robe":
                defense += 20;
                break;
        }
    }

    @Override
    public void levelUp() {
        level++;
        hp += 20;
        mana += 20;
        speed += 5;
        defense += 5;
        damage += 10;
        System.out.println(name + " levels up to level " + level + "!");
        System.out.println("New stats -> HP: " + hp + ", Mana: " + mana + ", Speed: " + speed + ", Defense: " + defense + ", Damage: " + damage);
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
        switch (spell) {
            case "Confringo":
                damage += 30;
                System.out.println(name + " casts Confringo! Damage increased to " + damage + ".");
                break;
            case "Impervius":
                defense += 25;
                System.out.println(name + " casts Impervius! Defense increased to " + defense + ".");
                break;
        }
    }
}
