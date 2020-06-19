package GB.Marathon;


public class Main {
    public static void main(String[] args) {
//        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
//        Obstacle[] course = {new Cross(80), new Water(5), new Wall(1), new Cross(120)};
        Course c = new Course("wall", "1", "cross", "80", "water", "5", "cross", "400", "wall", "21"); // Создаем полосу препятствий
        Team team = new Team("ДримТим","human", "Боб", "cat", "Барсик", "dog", "Бобик"); // Создаем команду
        team.showTeamInfo();
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты

    }
}
