public class Card {
    private String suit;
    private String rank;

    Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String toString(){
        return (rank + suit);
    }

    public int getValue() {
        if (rank.equals("A")) {
            return 11;
        } else if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
            return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }

    public boolean checkAce() {
        return rank.equals("A");
    }
}
