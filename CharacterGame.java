class Persona {
    String name;
    int attack;
    int defence;
    int lifePoints;
    Weapon weapon;
    boolean choiceDefence;
}

class Weapon {
    int damage = 0;
    int defence = 0;

    Weapon(int atk, int def) {
        damage = atk;
        defence = def;
    }
}

class Guerreiro extends Persona {
    public Guerreiro(String charName, int weaponAttack, int weaponDefence) {
        name = charName;
        attack = 30;
        defence = 20;
        lifePoints = 180;
        weapon = new Weapon(weaponAttack, weaponDefence);
    }
}

class Mago extends Persona {

    public Mago(String charName, int weaponAttack, int weaponDefence) {
        name = charName;
        attack = 20;
        defence = 10;
        lifePoints = 200;
        weapon = new Weapon(weaponAttack, weaponDefence);

    }
}

class Arqueiro extends Persona {
    public Arqueiro(String charName, int weaponAttack, int weaponDefence) {
        name = charName;
        attack = 20;
        defence = 30;
        lifePoints = 160;
        weapon = new Weapon(weaponAttack, weaponDefence);
    }
}
