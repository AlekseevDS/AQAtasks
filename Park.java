import java.util.ArrayList;
import java.util.List;

public class Park {

    private String titlePark;
    private List<Attraction> attractionsList = new ArrayList<>();


    public Park(String titlePark) {
        this.titlePark = titlePark;
    }

    public void addAttraction(String title, String schedule, int cost) {
        new Attraction(title, schedule, cost);
    }

    public void attractionsInfo() {
        System.out.println("Park " + titlePark + " attractions:");
        for (Attraction attraction : attractionsList) {
            attraction.info();
        }
    }

    private class Attraction {
        private String titleAttraction;
        private String schedule;
        private int cost;

        private Attraction(String title, String schedule, int cost) {
            this.titleAttraction = title;
            this.schedule = schedule;
            this.cost = cost;

            attractionsList.add(this);
        }

        private void info() {
            System.out.println(titleAttraction + " / " + schedule + " / " + cost + "RUB");
        }
    }
}
