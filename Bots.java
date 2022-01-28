public class Bots {
    private String name;
    
    Bots(String name){
        this.name = name;
    }

    racecars botcar1 = new racecars();
    racecars botcar2 = new racecars();


    public void importBot1(String carbrand,int horsepower,int winrate) {
        getBotcar1().setName(carbrand);
        getBotcar1().setHorsepower(horsepower);
        getBotcar1().setWinrate(winrate);
    }
    public void importBot2(String carbrand,int horsepower,int winrate) {
        getBotcar2().setName(carbrand);
        getBotcar2().setHorsepower(horsepower);
        getBotcar2().setWinrate(winrate);
    }
    
    public void showBot1Info() {
        System.out.println("Name : Bot 1"+"\tCar : "+getBotcar1().getName()+"\tHorsepower : "+getBotcar1().getHorsepower()+"\tWinrate : "+getBotcar1().getWinrate());
    }

    public void showBot2Info() {
        System.out.println("Name : Bot 2"+"\tCar : "+getBotcar2().getName()+"\tHorsepower : "+getBotcar2().getHorsepower()+"\tWinrate : "+getBotcar2().getWinrate());
    }




    public racecars getBotcar1() {
        return botcar1;
    }

    public void setBotcar1(racecars botcar1) {
        this.botcar1 = botcar1;
    }

    public racecars getBotcar2() {
        return botcar2;
    }

    public void setBotcar2(racecars botcar2) {
        this.botcar2 = botcar2;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
