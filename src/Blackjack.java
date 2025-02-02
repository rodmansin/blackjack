import java.util.ArrayList;
import java.util.Random;

public class Blackjack {
    ArrayList<Card> deck;
    Random random = new Random();
    //Dealer
    Card faceDownCard, faceUpCard;
    ArrayList<Card> dealerHand;
    int dealerValue;
    int dealerAces;
    //Player
    ArrayList<Card> playerHand;
    int playerValue;
    int playerAces;

    Blackjack() {
        newGame();
    }

    public void newGame(){
        newDeck();
        shuffle();
        dealerHand = new ArrayList<Card>();
        dealerValue = 0;
        dealerAces = 0;
        faceDownCard = deck.remove(deck.size()-1);
        dealerValue += faceDownCard.getValue();
        if (faceDownCard.checkAce()) {
            dealerAces++;
        }
        faceUpCard = deck.remove(deck.size()-1);
        dealerValue += faceUpCard.getValue();
        if (faceUpCard.checkAce()) {
            dealerAces++;
        }
        dealerHand.add(faceUpCard);

        playerHand = new ArrayList<Card>();
        playerValue = 0;
        playerAces = 0;
        
        for (int i = 0; i < 2; i++) {
            Card playerCard = deck.remove(deck.size()-1);
            playerValue += playerCard.getValue();
            if (playerCard.checkAce()) {
                playerAces++;
            }
            playerHand.add(playerCard);
        }
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
    }

    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(deck.size());
            Card card1 = deck.get(i);
            Card card2 = deck.get(j);
            deck.set(i, card2);
            deck.set(j, card1);
        }
    }
}
