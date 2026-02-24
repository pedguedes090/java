import java.util.Random;
// Interface kỹ năng
interface ISkill {
    void useUltimate(GameCharacter target);
}

// Lớp trừu tượng nhân vật
abstract class GameCharacter {
    protected String name;
    protected int hp;
    protected int attackPower;
    public static int count = 0;

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count++;
    }

    public abstract void attack(GameCharacter target);

    public void takeDamage(int damage) {
        int oldHp = hp;
        hp -= damage;
        if (hp < 0) hp = 0;

        int realDamage = oldHp - hp;
        System.out.println(name + " mất " + realDamage + " HP (còn " + hp + ")");

        if (hp == 0) {
            System.out.println(name + " đã bị hạ gục!");
        }
    }


    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }
}

// Warrior
class Warrior extends GameCharacter implements ISkill {
    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " tấn công " + target.getName());
        target.takeDamage(attackPower);
    }

    @Override
    public void takeDamage(int damage) {
        int realDamage = damage - armor;
        if (realDamage < 0) realDamage = 0;
        super.takeDamage(realDamage);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println(name + " dùng Đấm ngàn cân!");
        int damage = attackPower * 2;
        target.takeDamage(damage);

        int selfDamage = (int)(hp * 0.1);
        hp -= selfDamage;
    }

    public int getArmor() {
        return armor;
    }
}

// Mage
class Mage extends GameCharacter implements ISkill {
    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {
        int damage;
        if (mana >= 5) {
            damage = attackPower;
            mana -= 5;
        } else {
            damage = attackPower / 2;
        }

        System.out.println(name + " bắn phép vào " + target.getName());
        target.takeDamage(damage);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if (mana >= 50) {
            System.out.println(name + " tung Hỏa cầu!");
            mana -= 50;
            target.takeDamage(attackPower * 3);
        } else {
            System.out.println(name + " không đủ mana!");
        }
    }

    public int getMana() {
        return mana;
    }
}
// Assassin
class Assassin extends GameCharacter implements ISkill {
    private int critRate; // % chí mạng

    public Assassin(String name, int hp, int attackPower, int critRate) {
        super(name, hp, attackPower);
        this.critRate = critRate;
    }

    @Override
    public void attack(GameCharacter target) {
        int damage = attackPower;
        int random = (int)(Math.random() * 100);

        if (random < critRate) {
            damage *= 2;
            System.out.println(name + " chí mạng vào " + target.getName());
        } else {
            System.out.println(name + " ám sát " + target.getName());
        }

        target.takeDamage(damage);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println(name + " dùng Kết liễu!");
        target.takeDamage(attackPower * 3);
    }

    public int getCritRate() {
        return critRate;
    }
}

// Healer
class Healer extends GameCharacter implements ISkill {
    private int mana;

    public Healer(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " đánh nhẹ vào " + target.getName());
        target.takeDamage(attackPower);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if (mana >= 30) {
            int damage = attackPower * 2;
            mana -= 30;
            System.out.println(name + " tung Thánh Quang vào " + target.getName());
            target.takeDamage(damage);
        } else {
            System.out.println(name + " không đủ mana!");
        }
    }

    public int getMana() {
        return mana;
    }
}

// Main
public class Main {
    public static void main(String[] args) {

        GameCharacter[] characters = new GameCharacter[5];

        characters[0] = new Warrior("Thor", 100, 20, 5);
        characters[1] = new Mage("Merlin", 80, 25, 100);
        characters[2] = new Assassin("Shadow", 70, 30, 40);
        characters[3] = new Healer("Angela", 90, 10, 80);

        characters[4] = new GameCharacter("Goblin", 50, 0) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("Goblin cắn trộm " + target.getName());
                target.takeDamage(10);
            }
        };

        Random rand = new Random();

        System.out.println("=== BẮT ĐẦU TRẬN CHIẾN ===");
        while (countAlive(characters) > 1) {
            GameCharacter attacker;
            do {
                attacker = characters[rand.nextInt(characters.length)];
            } while (attacker.getHp() <= 0);

            GameCharacter target;
            do {
                target = characters[rand.nextInt(characters.length)];
            } while (target == attacker || target.getHp() <= 0);

            System.out.println("\n" + attacker.getName() + " -> " + target.getName());

            // 30% dùng Ultimate nếu có
            if (attacker instanceof ISkill && rand.nextInt(100) < 30) {
                ((ISkill) attacker).useUltimate(target);
            } else {
                attacker.attack(target);
            }
        }

        // Tìm người thắng
        System.out.println("\n=== KẾT THÚC ===");
        for (GameCharacter c : characters) {
            if (c.getHp() > 0) {
                System.out.println("Người chiến thắng: " + c.getName() +
                        " (HP: " + c.getHp() + ")");
            }
        }
    }

    // Đếm số người còn sống
    public static int countAlive(GameCharacter[] arr) {
        int count = 0;
        for (GameCharacter c : arr) {
            if (c.getHp() > 0) count++;
        }
        return count;
    }
}
