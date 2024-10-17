import java.util.ArrayList;
import java.util.Random;

public class Blackjack {
    ArrayList<Card> deck;
    Blackjack() {
        newGame();
    }
    public void newGame(){
        newDeck();
    }
    public void newDeck(){
        deck = new ArrayList<Card>();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Clubs", "Spades", "Diamonds", "Hearts"};

        for (int i = 0; i < suits.length; i++){
            for (int j = 0; j < ranks.length; j++){
                deck.add(new Card(ranks[j], suits[i]));
            }
        }
        System.out.println(deck);
    }
}
