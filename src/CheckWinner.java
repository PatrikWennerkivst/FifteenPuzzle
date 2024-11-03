import javax.swing.*;
import java.util.ArrayList;

public class CheckWinner {

    public static boolean winnerCheck(ArrayList<JButton> buttons) { //returnerar true om du vunnit, false om nt

        for (int i = 0; i < 15; i++) {  //går igenom listan
            String expectedNumber = String.valueOf(i + 1); //förväntade talet ska börja på 1 å upp t 15
            String actualNumber = buttons.get(i).getText(); // hämtar text fr den aktuella knappen, å visar denna text som spelaren ser på knapp
            if (!actualNumber.equals(expectedNumber)) {
                //om texten matchar m de förväntade talet, - är de inte så är dem inte i ordning - EJ vunnit
                return false; //om ngn knapp inte har rätt tal, fortsätter spelet
            }
        }
        return buttons.get(15).getText().equals("");
        // OM loopen går igenom nu utan att hitta ngt fel, så betyder de att de är rätt i rätt ordning..
        //om sista knappen är tom, returnerar metoden true - spelaren har vunnit!
    }

    public static void winMessage() {
        JOptionPane.showMessageDialog(null, "CONGRATULATION! You ARE THE WINNER!");
        // vet int vf de blir null, å vet inte om de funkar? känns som ja missat ngt! // behöver mergaes för å se?
    }
}