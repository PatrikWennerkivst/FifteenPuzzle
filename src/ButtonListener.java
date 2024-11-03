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
        if (isNextToEmpty(indexOfButton, emptyIndex)) {
            ChangeButton(indexOfButton, emptyIndex);
            fifteenPuzzle.setEmptyIndex(indexOfButton);

            if (CheckWinner.winnerCheck(FifteenPuzzle.getButtons())) {
                CheckWinner.winMessage(); // hämtar metoden ifr winnerchecker om detta uppföljs så printas..
            }
        }
    }
    private boolean isNextToEmpty(int clickedButton, int emptyButton) {
        //Koll av vilken rad den klickad knapp och tom rutan har genom att dela med 4
        int clickedRow = clickedButton / 4;
        int emptyRow = emptyButton / 4;
        //Kolla av vilken kolumnnummer den klickad knapp och tom ruta har med hjälp av modolus
        int clickedColumn = clickedButton % 4;
        int emptyColumn = emptyButton % 4;
        // Kolla om de är på samma rad och ligger bredvid varandra horisontellt
        if (clickedRow == emptyRow) {
            //godkänd både +1 och -1 beroende på om den toma rutan ligger till höger eller vänster om knappen
            if (clickedButton == emptyButton + 1 || clickedButton == emptyButton - 1) {
                return true;
            }
        }
        //godkänd både +4 och -4 beroende på om den toma rutan ligger till ovanför eller under knappen
        if (clickedColumn == emptyColumn) {
            if (clickedButton == emptyButton + 4 || clickedButton == emptyButton - 4) {
                return true;
            }
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