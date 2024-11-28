import java.util.ArrayList;
import java.util.List;

public abstract class RPGCharacter {
    protected String name;
    protected int damage;
    protected int hp;
    protected int mana;
    protected int speed;
    protected int defense;
    protected int level = 1;
    protected List<Accessories> accessories = new ArrayList<>();

    public RPGCharacter(String name, int damage, int hp, int mana, int speed, int defense) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
        this.mana = mana;
        this.speed = speed;
        this.defense = defense;
    }

    public void attack() {
        System.out.println(name + " attacks with " + damage + " damage!");
    }

    public void equipAccessories(Accessories accessory) {
        accessories.add(accessory);
        System.out.println(name + " equips " + accessory.getName() + ". Effect: " + accessory.getEffect());
        applyAccessoriesEffect(accessory);
    }

    protected abstract void applyAccessoriesEffect(Accessories accessory);

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

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public  int  getLevel() {
        return level;
    }

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

class Wizard extends RPGCharacter {
    private String house;

    public Wizard(String name, String house, int damage) {
        super(name, damage, 100, 100, 50, 30);
        this.house = house;
    }

    @Override
    protected void applyAccessoriesEffect(Accessories accessory) {
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
}

class Fighter extends RPGCharacter {
    public Fighter() {
        super("Thanos", 80, 150, 0, 40, 50);
        System.out.println(name + " is fully equipped with Sword, Boots, and Cloak.");
    }

    @Override
    protected void applyAccessoriesEffect(Accessories accessory) {
        // Fighter is pre-equipped
    }
}
