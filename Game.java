import java.util.Random;
import java.util.Scanner;

/**
 * Game
 */
public class Game {
    Scanner scan = new Scanner(System.in);
    Player player;
    Bots bot1,bot2;
    Maps map1,map2,map3,map4,map5;
    // int race = 3;

    public void login(){
        System.out.println();
        System.out.println("Welcome to the race game!\n======================");
        System.out.print("To start the game, you have to enter your name.\nYour Name:");
        player = new Player(scan.nextLine());
        bot1 = new Bots("Bot 1");
        bot2 = new Bots("Bot 2");

        System.out.println("\n\n\n");
        System.out.println("Choose your car\n==============");
        System.out.println("1-Audi\t\tHorsepower: 450\tWinrate: 27%");
        System.out.println("2-BMW\t\tHorsepower: 470\tWinrate: 34%");
        System.out.println("3-Mercedes\tHorsepower: 490\tWinrate: 39%");
        System.out.print("Select your car:");
        int carselect = scan.nextInt();
        while (carselect > 3 || carselect < 1) {
            System.out.println("This car does not exist. Please enter a ID that exists");
            System.out.print("Select your car:");
            carselect = scan.nextInt();
        }
        switch (carselect) {
            case 1:
                player.importPlayer("Audi R8", 450, 27);
                bot1.importBot1("BMW M4", 470, 34);
                bot2.importBot2("AMG GTR", 490, 39);
                break;
            case 2:
                player.importPlayer("BMW M4", 470, 34);
                bot1.importBot1("Audi R8", 450, 27);
                bot2.importBot2("AMG GTR", 490, 39);
                break;
            case 3:
                player.importPlayer("AMG GTR", 490, 39);
                bot1.importBot1("Audi R8", 450, 27);
                bot2.importBot2("BMW M4", 470, 34);
                break;
            default:
                break;
        }
        System.out.println();
        System.out.println("=================================Racers==================================");
        player.ShowInfo();
        bot1.showBot1Info();
        bot2.showBot2Info();
        System.out.println("=========================================================================");

    }

    public void start() {
        map1 = new Maps("Germany");
        map2 = new Maps("USA");
        map3 = new Maps("England");
        map4 = new Maps("Turkey");
        map5 = new Maps("Canada");


        while(map1.isfinished != true || map2.isfinished != true || map3.isfinished != true || map4.isfinished != true || map5.isfinished != true){

        // System.out.println();
        System.out.println("===========Maps===========");
        System.out.println("1-Germany\n2-USA\n3-England\n4-Turkey\n5-Canada");
        System.out.println("==========================");
        System.out.print("Select the map:");
        int mapSelection = scan.nextInt();

        while (mapSelection > 5 || mapSelection < 1) {
            System.out.println("This ID does not exist. Please enter a ID that exists");
            System.out.print("Select the map:");
            mapSelection = scan.nextInt();
        }

        switch (mapSelection) {
            case 1:
                race(map1);
                // race--;
                map1.isfinished = true;
                break;
            case 2:
                race(map2);
                // race--;
                map2.isfinished = true;
                break;
            case 3:
                race(map3);
                // race--;
                map3.isfinished = true;
                break;
            case 4:
                race(map4);
                map4.isfinished = true;
                break;
            case 5:
                race(map5);
                map5.isfinished = true;
                break;
            default:
                break;
            }
        }

        System.out.println("\n\n\n\n\n");
        System.out.println("All races are completed!!!!!!");
    }

    private void race(Maps map) {
        System.out.println("\n\n\n\n\n\n\n\n");
        System.out.println("==========================================");
        System.out.println("Welcome the the "+ map.getName());
        System.out.println("The race started now !!!");
        System.out.print("To finish the race, enter <f> : ");
        char finish = scan.next().charAt(0);
        while (finish != 'f') {
            System.out.print("To finish the race, enter <f> : "); 
        }
        showResults();
        //System.out.println();
    }

    public void showResults() {

        Random rand = new Random();
        System.out.println("=================================Results==================================");

        int first = rand.nextInt(100);
        int second = rand.nextInt(100);
        if(first < 27){
            if(player.getCar().getName() == "Audi R8"){
                System.out.println("1-"+player.getName() +"\t Car: "+player.getCar().getName());

                if(second < 50){
                    System.out.println("2-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());
                    System.out.println("3-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());
                }
                else{
                    System.out.println("2-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());
                    System.out.println("3-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());
                }
            }
            if(bot1.getBotcar1().getName() == "Audi R8"){
                System.out.println("1-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());

                if(second < 50){
                    System.out.println("2-"+player.getName() +"\t Car: "+player.getCar().getName());
                    System.out.println("3-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());

                }
                else{
                    System.out.println("2-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());
                    System.out.println("3-"+player.getName() +"\t Car: "+player.getCar().getName());

                }

            }
            if(bot2.getBotcar2().getName() == "Audi R8"){
                System.out.println("1-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());

                if(second < 50){
                    System.out.println("2-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());
                    System.out.println("3-"+player.getName() +"\t Car: "+player.getCar().getName());
                }
                else{
                    System.out.println("2-"+player.getName() +"\t Car: "+player.getCar().getName());
                    System.out.println("3-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());

                }
            }
        }


        else if (first > 28 && first <62) {
            if(player.getCar().getName() == "BMW M4"){
                System.out.println("1-"+player.getName() +"\t Car: "+player.getCar().getName());

                if(second < 50){
                    System.out.println("2-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());
                    System.out.println("3-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());
                }
                else{
                    System.out.println("2-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());
                    System.out.println("3-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());
                }
            }
            if(bot1.getBotcar1().getName() == "BMW M4"){
                System.out.println("1-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());

                if(second < 50){
                    System.out.println("2-"+player.getName() +"\t Car: "+player.getCar().getName());
                    System.out.println("3-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());

                }
                else{
                    System.out.println("2-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());
                    System.out.println("3-"+player.getName() +"\t Car: "+player.getCar().getName());

                }

            }
            if(bot2.getBotcar2().getName() == "BMW M4"){
                System.out.println("1-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());

                if(second < 50){
                    System.out.println("2-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());
                    System.out.println("3-"+player.getName() +"\t Car: "+player.getCar().getName());
                }
                else{
                    System.out.println("2-"+player.getName() +"\t Car: "+player.getCar().getName());
                    System.out.println("3-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());

                }
            }
        }

        else{
            if(player.getCar().getName() == "AMG GTR"){
                System.out.println("1-"+player.getName() +"\t Car: "+player.getCar().getName());

                if(second < 50){
                    System.out.println("2-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());
                    System.out.println("3-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());
                }
                else{
                    System.out.println("2-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());
                    System.out.println("3-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());
                }
            }
            if(bot1.getBotcar1().getName() == "AMG GTR"){
                System.out.println("1-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());

                if(second < 50){
                    System.out.println("2-"+player.getName() +"\t Car: "+player.getCar().getName());
                    System.out.println("3-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());

                }
                else{
                    System.out.println("2-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());
                    System.out.println("3-"+player.getName() +"\t Car: "+player.getCar().getName());

                }

            }
            if(bot2.getBotcar2().getName() == "AMG GTR"){
                System.out.println("1-"+bot2.getName() +"\t Car: "+bot2.getBotcar2().getName());

                if(second < 50){
                    System.out.println("2-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());
                    System.out.println("3-"+player.getName() +"\t Car: "+player.getCar().getName());
                }
                else{
                    System.out.println("2-"+player.getName() +"\t Car: "+player.getCar().getName());
                    System.out.println("3-"+bot1.getName() +"\t Car: "+bot1.getBotcar1().getName());

                }
            }
        }

        System.out.println("=========================================================================");
        
    }
    
}