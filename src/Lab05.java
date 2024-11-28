import java.util.Scanner;

public class Lab05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // เลือกบ้าน
        System.out.println("Choose your house: ");
        System.out.println("1. Gryffindor");
        System.out.println("2. Hufflepuff");
        System.out.println("3. Ravenclaw");
        System.out.println("4. Slytherin");
        int houseChoice = scanner.nextInt();
        String house = "";
        int damage = 0;

        switch (houseChoice) {
            case 1:
                house = "Gryffindor";
                damage = 70;
                break;
            case 2:
                house = "Hufflepuff";
                damage = 50;
                break;
            case 3:
                house = "Ravenclaw";
                damage = 50;
                break;
            case 4:
                house = "Slytherin";
                damage = 40;
                break;
        }
        System.out.println("You chose " + house + " with base damage " + damage + ".");

        // สร้างตัวละคร Wizard
        Wizard player = new Wizard("Player", house, damage);

        // แสดงค่าระดับและสถานะก่อนการ LevelUp
        System.out.println("\n--- Before Level Up ---");
        System.out.println("Level: " + player.getLevel());
        System.out.println("Damage: " + player.getDamage());
        System.out.println("Defense: " + player.getDefense());

        // เรียก levelUp เพื่ออัพเกรดระดับ
        player.levelUp();

        // แสดงค่าหลังการ LevelUp
        System.out.println("\n--- After Level Up ---");
        System.out.println("Level: " + player.getLevel());
        System.out.println("Damage: " + player.getDamage());
        System.out.println("Defense: " + player.getDefense());


        // เลือกอุปกรณ์เสริม
        System.out.println("Choose your accessories (Enter numbers separated by spaces, e.g., 1 2 3): ");
        System.out.println("1. Wand");
        System.out.println("2. Broomstick");
        System.out.println("3. Boots");
        System.out.println("4. Robe");
        scanner.nextLine(); // Consume newline
        String[] choices = scanner.nextLine().split(" ");
        if (choices.length == 0 || choices[0].isEmpty()) {
            System.out.println("No accessories chosen.");
        } else {
            for (String choice : choices) {
                switch (choice) {
                    case "1":
                        player.equipAccessories(new Wand());
                        break;
                    case "2":
                        player.equipAccessories(new Broomstick());
                        break;
                    case "3":
                        player.equipAccessories(new Boots());
                        break;
                    case "4":
                        player.equipAccessories(new Robe());
                        break;
                    default:
                        System.out.println("Invalid accessory choice: " + choice);
                }
            }
        }

        // เลือกคาถา
        System.out.println("\nChoose your spell: *(Choose Only 1)*");
        System.out.println("1. Confringo (Increases damage by 30)");
        System.out.println("2. Impervius (Increases defense by 25)");
        String spellChoice = scanner.nextLine();
        while (!spellChoice.equals("1") && !spellChoice.equals("2")) {
            System.out.println("Invalid choice. Please choose again: ");
            spellChoice = scanner.nextLine();
        }

        if (spellChoice.equals("1")) {
            player.castSpell("Confringo");
        } else {
            player.castSpell("Impervius");
        }

        // สร้าง Fighter (Thanos)
        Fighter thanos = new Fighter();

        // การโจมตี
        System.out.println("\n--- Battle Starts! ---");
        player.attack();
        thanos.attack();

        // สรุปผล
        System.out.println("\n--- Results ---");
        int finalPlayerDamage = player.getDamage() - thanos.getDefense();
        int finalThanosDamage = thanos.getDamage() - player.getDefense();

        System.out.println("Player dealt " + Math.max(finalPlayerDamage, 0) + " damage to Thanos.");
        System.out.println("Thanos dealt " + Math.max(finalThanosDamage, 0) + " damage to Player.");
        if (finalPlayerDamage > finalThanosDamage) {
            System.out.println("Player wins!");
        } else if (finalPlayerDamage < finalThanosDamage) {
            System.out.println("Thanos wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
