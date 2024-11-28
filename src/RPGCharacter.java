import java.util.ArrayList;
import java.util.List;

public interface RPGCharacter {
    void attack();
    void equipAccessories(Accessories accessory);
    void levelUp();
    int getDamage();
    int getDefense();
    int getLevel();
    void castSpell(String spell);
}





