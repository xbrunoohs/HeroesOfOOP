import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    public String userName;
    public List<Persona> characters = new ArrayList<Persona>();

    void startGameLayout() {
        System.out.println(
                "HHH    HH EEEEEE  RRRRRRRRR         OOOOO       EEEEEEE       SSSSSS    OOOOOOOOO      PPppppppp");
        System.out.println(
                "HHH    HH EEEEEE  RRRR     RR    OO  (I)  OO    EEEEEEE     SSSSSSS     OO  OO0OO000OO PP    pppp");
        System.out.println(
                "HHHHHHHHH EE      RRRR     RRR  OOO  (I)   OOO  EEE       SSSSSS        OO  OO OO   OO PP    ppp");
        System.out.println(
                "HHHHHHHHH EEEEER  RRRRR    RR   OOO  (I)   OOO  EEEEEEE SSSSS           OO  OO OO   OO PP   pp");
        System.out.println(
                "HHHHHHHHH EEEEER  RRRRR   R     OOO  (I)   OOO  EEEEEEE  SSSSS          OO  OO OO   OO PP pp");
        System.out.println("HHHHHHHHH EE      RRRRRRR        OO  (I)  OO    EE         SSSSS        OO  OO OO   OO PP");
        System.out.println("HHH    HH EEEEEEEEEEEE  RRR       OO (I) OO     EEEEEE   SSSSS          OO  OO00OO00OO PP");
        System.out.println("HHH    HH EEEEEEEEEEEE   RRRR        OOO         EEEEEE SSSS            OOOOOOOOO      PP");

        System.out.println("\n\n");

        mainMenu();

    }

    private void mainMenu() {
        //Menu inicial
        String gameStatus = "0";
        Scanner scanner = new Scanner(System.in);

        while (Integer.parseInt(gameStatus) != 3) {
            System.out.println("Personagens criados atualmente: " + characters.size());
            for (Persona object : characters) {
                System.out.println(object.getClass());
                System.out.println("Nome: " + object.name);
                System.out.println("Pontos de vida: " + object.lifePoints);
                System.out.println("Ataque (padrao e arma): " + (object.attack + object.weapon.damage));
                System.out.println("Defesa (padrao e arma): " + (object.defence + object.weapon.defence));
                System.out.println("------>");
            }

            System.out.println("\nQual opcao voce vai seguir?");
            System.out.println("1-Iniciar aventura");
            System.out.println("2-Criar personagem");
            System.out.println("3-Sair jogo");
            System.out.println("");
            gameStatus = scanner.next();
            switch (Integer.parseInt(gameStatus)) {
            case 1:
                System.out.println("Iniciar jogo");
                gameplay();
                break;
            case 2:
                System.out.println("\nCriacao de personagem");
                createCharacter();
                break;
            case 3:
                System.out.println("Sair da aventura");
                return;

            default:
                System.out.println("Nao existe essa opcao nesse mundo, tente outra vez por favor\n");
                break;
            }
        }
    }

    private void createCharacter() {
        Scanner scanner = new Scanner(System.in);
        int classe = -1;
        int arma = -1;
        String charName = "NomePadrao";
        System.out.println("\n");
        System.out.println("1-Guerreiro");
        System.out.println("2-Mago");
        System.out.println("3-Arqueiro");

        classe = getClass(scanner, classe);
        System.out.println("\n");
        arma = getWeapon(scanner, classe, arma);
        System.out.println("\n");
        charName = getName(scanner);
        System.out.println("\n");

        switch (classe) {
        case 1:
            if (arma == 1) {
                //Espada
                characters.add(new Guerreiro(charName, 10, 15));
            } else {
                //Machado
                characters.add(new Guerreiro(charName, 17, 8));
            }
            break;
        case 2:
            System.out.println("Mago");
            if (arma == 1) {
                //Varinha
                characters.add(new Mago(charName, 16, 9));
            } else {
                //Cajado
                characters.add(new Mago(charName, 13, 12));
            }
            break;
        case 3:
            System.out.println("Arqueiro");
            if (arma == 1) {
                //Arco longo
                characters.add(new Arqueiro(charName, 12, 13));
            } else {
                //Balestra
                characters.add(new Arqueiro(charName, 15, 10));
            }
            break;
        }

    }

    private String getName(Scanner scanner) {
        String charName;
        System.out.print("Qual o nome do seu heroi: ");
        charName = scanner.next();
        return charName;
    }

    private int getWeapon(Scanner scanner, int classe, int arma) {
        switch (classe) {
        case 1:
            System.out.println("1-Espada");
            System.out.println("2-Machado");
            break;
        case 2:
            System.out.println("1-Varinha");
            System.out.println("2-Cajado");
            break;

        case 3:
            System.out.println("1-Arco longo");
            System.out.println("2-Belastra");
            break;

        }

        System.out.print("Arma escolhida: ");
        while (arma > 3 || arma < 0) {
            arma = scanner.nextInt();
        }
        return arma;
    }

    private int getClass(Scanner scanner, int classe) {
        while (classe > 3 || classe < 0) {
            System.out.print("Classe escolhida: ");
            classe = scanner.nextInt();
        }
        return classe;
    }

    private void gameplay() {
        if (characters.size() <= 0) {
            System.out.println("Voce nao possui herois para comecar uma aventura!\n");
            return;
        }

        GamePlay gamePlay = new GamePlay();
        gamePlay.startGame(characters);
    }
}
