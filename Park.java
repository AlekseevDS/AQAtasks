public class Park {

    public class Attraction {
        String title;
        String schedule;
        int cost;

        public Attraction(String title, String schedule, int cost) {
            this.title = title;
            this.schedule = schedule;
            this.cost = cost;
        }

        public void info() {
            System.out.println(title + " / " + schedule + " / " + cost + "RUB");
        }
    }

}
