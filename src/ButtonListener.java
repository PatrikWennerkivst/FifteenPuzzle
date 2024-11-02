import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListener implements ActionListener {

    private FifteenPuzzle fifteenPuzzle;

    public ButtonListener(FifteenPuzzle fifteenPuzzle) {
        this.fifteenPuzzle = fifteenPuzzle;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Tar in knapptryck ifrån vilken knapp som helst från JPanel med (JButton) som lyssnar efter ett tryck av
        //vilen JButton som helst.
        JButton clickedButton = (JButton) e.getSource();
        int indexOfButton = fifteenPuzzle.getButtons().indexOf(clickedButton);
        int emptyIndex = fifteenPuzzle.getEmptyIndex();

        // Kollar om knappen ligger brevid den tomma rutan med hjälp av metoden IsNextToEmpty
        if (isNextToEmpyt(indexOfButton, emptyIndex)) {
            ChangeButton(indexOfButton, emptyIndex);
            fifteenPuzzle.setEmptyIndex(indexOfButton);

        }
    }
        //Metod som kollar om den tryckta knappen ligger brevid den tomma knappen.
        //Görs med hjälp av metoden abs från klassen Math för att kolla om dom ligger intill varandra.
        //Metoden returnerar en boolean för att känna av om detta krav har uppfyllts eller inte.
    private boolean isNextToEmpyt(int clickedButton, int IsNextToEmptyButton) {
        // kollar om den tomma rutan ligger på samma rad som knappen.
        if (clickedButton / 4 == IsNextToEmptyButton / 4) {
            return Math.abs(clickedButton - IsNextToEmptyButton) == 1;
        }
        // kollar om den tomma rutan ligger i samma kolumn.
        if (clickedButton % 4 == IsNextToEmptyButton % 4) {
            return Math.abs(clickedButton - IsNextToEmptyButton) == 4;
        }
        return false;
    }

    //Metod som byter plats på knapparna genom att läsa in knappen som användaren har tryckt på och byter plats på den
    //med den tomma rutan. Detta görs med tre variabler, int buttonToMove, int buttonMovedTo och String buttonToMoveString
    //String buttonToMoveString sparar siffran av den tryckta knappen och lägger sedan in den i nya knappen som bytt plats
    //med den tryckta knappen.
    private void ChangeButton(int buttonToMove, int buttonMovedTo) {
        ArrayList<JButton> buttons = fifteenPuzzle.getButtons();
        String buttonToMoveString = buttons.get(buttonToMove).getText();
        buttons.get(buttonToMove).setText(buttons.get(buttonMovedTo).getText());
        buttons.get(buttonMovedTo).setText(buttonToMoveString);
    }
}