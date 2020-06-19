package GB.Marathon;

public class Course {

    protected Obstacle[] course;

    /*
    И тут можно было сделать как
    public Course(Obstacle... obstacles) {
    this.obstacles = obstacles;
    }
    Но тогда в Main будет строчка и с созданием препятствий : Course c = new Course...
                                  и с созданием объектов: ...new Cross(80), new Water(5),...и тд
                                  в коде ниже я просто избавился от непосредственного создания объектов в main
                                  потому что такого подхода я еще не делал
    */
    public Course(String...obstacles){
        int j = 0;
        course = new Obstacle[obstacles.length / 2];
        for (int i = 0; i < obstacles.length; i = i + 2){
            switch (obstacles[i]) {
                case "wall":
                    course[j] = new Wall(Integer.parseInt(obstacles[i + 1]));
                    break;
                case "cross":
                    course[j] = new Cross(Integer.parseInt(obstacles[i + 1]));
                    break;
                case "water":
                    course[j] = new Water(Integer.parseInt(obstacles[i + 1]));
                    break;
            }
            j++;
        }
    }

    public void doIt(Team t){
        for (Competitor c : t.team) {
            for (Obstacle o : course) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}
