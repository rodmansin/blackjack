

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
}
