package MVCTravis;

/**
 * Created by Joseph on 10/12/16.
 */
public class CollegeBean {
        private String name;
        private int wins;
        private int losses;
        private String rank;
        private String key;

        public String getName() {
            return name;
        }
        //change to hashmap of football teams using a bean of colleges

        public void setName(String name) {
            this.name = name;
        }

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getLosses() {
            return losses;
        }

        public void setLosses(int losses) {
            this.losses = losses;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

    @Override
    public String toString() {
        return "\nCollegeBean{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", rank='" + rank + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    public CollegeBean() {
        this.name = "";
        this.wins = 0;
        this.losses = 0;
        this.rank = "Unknown";
        this.key = "";
    }
}
