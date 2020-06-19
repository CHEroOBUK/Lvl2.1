package GB.Marathon;

public class Team {
    String name;

    protected Competitor[] team;
    /*
    Безусловно, можно было сделать как:
    public Team (String teamName, Competitor...competitors){
        name = teamName;
        team = competitors;
    }
    но мне такой подход в принципе не нравится.
    Вы хотите сказать, ради того, чтобы избавиться от строчки в main:
    Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")}"
    и превратить ее в строчку:
    Team team = new Team("Team1",new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"));
    ...затеивалось всё дз?
    */

    public Team(String teamName, String...competitors){
        name = teamName;
        int j = 0;
        team = new Competitor[competitors.length / 2];
        for (int i = 0; i < competitors.length; i = i + 2){
            switch (competitors[i]) {
                case "human":
                    team[j] = new Human(competitors[i + 1]);
                    break;
                case "cat":
                    team[j] = new Cat(competitors[i + 1]);
                    break;
                case "dog":
                    team[j] = new Dog(competitors[i + 1]);
                    break;
            }
            j++;
        }
    }

    public void showTeamInfo() {
        System.out.println("\nХарактеристики команды: " + name);
        for (Competitor c : team) {
            c.getAbilities();
        }
        System.out.println();
    }

    public void showResults(){
        for (Competitor c : team) {
            c.info();
        }
    }

}
