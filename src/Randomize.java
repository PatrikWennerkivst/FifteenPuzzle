import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


public class Randomize implements ActionListener {
    // JButton randomButton;
    private FifteenPuzzle fifteenPuzzle;

    public Randomize (FifteenPuzzle randomizePuzzle) {
        this.fifteenPuzzle  = randomizePuzzle;
    }

    //en metod för att randomizera knapparna 1-15 vid knapp tryck av new game
    public void randomizeBoard() {
       ArrayList<String> numbers = new ArrayList<>(); // skapar en lista för nr 1-15
        for (int i = 1; i <= 15; i++) {  //for loop för att gå fr 1-15
            numbers.add(String.valueOf(i)); // värdet av i omvandlar d till en sträng
        }
//
        //använder collections för enklaste sättet att slumpa ordningen av numrerna
        Collections.shuffle(numbers);

        ArrayList<JButton> buttons = FifteenPuzzle.getButtons(); //Detta va vad vi missat
        for (int i = 0; i < 15; i++) { // genom att uppdatera knapparna m dem slumpade numrerna,
            buttons.get(i).setText(numbers.get(i)); //korrekta version
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        randomizeBoard();
    }
}