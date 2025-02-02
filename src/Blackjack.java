import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Blackjack {
    //Game attributes
    ArrayList<Card> deck;
    Random random = new Random();
    //Dealer attributes
    Card faceDownCard, faceUpCard;
    ArrayList<Card> dealerHand;
    int dealerValue;
    int dealerAces;
    //Player attributes
    ArrayList<Card> playerHand;
    int playerValue;
    int playerAces;
    //UI
    int screenWidth = 1000, screenHeight = 720;
    final int cardWidth = 120, cardHeight = 168;
    JFrame frame = new JFrame("Blackjack");
    JPanel mainPanel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Image faceDownCardImg = new ImageIcon(getClass().getResource("./cards/Back.png")).getImage();
            g.drawImage(faceDownCardImg, 40, 4, (int)(cardWidth*1.35), (int)(cardHeight*1.35), null);
            for (int i = 0; i < dealerHand.size(); i++) {
                Card card = dealerHand.get(i);
                Image cardImg = new ImageIcon(getClass().getResource(card.getImgPath())).getImage();
                g.drawImage(cardImg, cardWidth + 80 + i*(cardWidth + 20), 30, cardWidth, cardHeight, null);
            }
            for (int i = 0; i < playerHand.size(); i++) {
                Card card = playerHand.get(i);
                Image cardImg = new ImageIcon(getClass().getResource(card.getImgPath())).getImage();
                g.drawImage(cardImg, 60 + i*(cardWidth + 20), 400, cardWidth, cardHeight, null);
            }
        }
    };
    JPanel buttonPanel = new JPanel();
    JButton hitButton = new JButton("Hit");
    JButton standButton = new JButton("Stand");

    Blackjack() {
        newGame();
        //GUI
        frame.setVisible(true);
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(16,59,52));
        frame.add(mainPanel);

        hitButton.setFocusable(false);
        buttonPanel.add(hitButton);
        standButton.setFocusable(false);
        buttonPanel.add(standButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
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
