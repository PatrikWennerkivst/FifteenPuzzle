import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


// klassen representerar ett fönster + den kan hantera knapptryckningar och andra interaktioner
public class FifteenPuzzle extends JFrame implements ActionListener {
    private Randomize randomizer;
    public static ArrayList<JButton> buttons = new ArrayList<>();


    private int emptyIndex = 15; // den tomma brickans position i b listan,  startvärde 15 (sista positionen).
    private JPanel panel = new JPanel(new GridLayout(4, 4));
    private JButton newGameButton; //för att starta om spelet

    public FifteenPuzzle() {
        //klassen anropar metoden initializeGame, som skapar layouten för spelplanen och placerar knapparna.
        randomizer = new Randomize(this);
        initializeGame();
        randomizer.randomizeBoard();


    }

    public void initializeGame() { //för att skapa layout o skapa knapp,
        setLayout(new BorderLayout()); //layouten för fönstret

        //en knapp med texten "New Game". Genom addActionListener anger man att knappen ska anropa restartGame när den trycks
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> {
            restartGame();
            randomizer.randomizeBoard();
        });

        add(panel, BorderLayout.CENTER);
        add(newGameButton, BorderLayout.SOUTH);

        newGame(); //Anropar metoden som initierar en ny spelomgång
        panel.setBackground(new Color(51,153,255)); // använder dessa rgb för få en blå ram runt knapparna
        setTitle("15-Puzzle"); //va den ska heta
        setSize(500, 500); //strlk
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //så d stängs korrekt eft
        setVisible(true); // synlig
    }

    public void newGame() {
        panel.removeAll();
        buttons.clear();
        //Skapara en font för alla knappar som jag sedan lägger in i alla knappar
        Font boldTextForButtons = new Font("Arial", Font.BOLD, 16);

        for (int i = 1; i <= 15; i++) { // läggs till i till i både buttons-listan och panel.
            JButton button = new JButton(String.valueOf(i));
            buttons.add(button);
            panel.add(button);
            button.addActionListener(new ButtonListener(this));
            button.setBackground(Color.BLACK);
            button.setFont(boldTextForButtons);
            button.setForeground(Color.YELLOW);
        }


        JButton emptyButton = new JButton("");
        buttons.add(emptyButton);
        emptyButton.setBackground(Color.BLACK);
        emptyButton.setForeground(Color.YELLOW);
        emptyButton.setFont(boldTextForButtons);
        panel.add(emptyButton);
        emptyIndex = 15;
        emptyButton.addActionListener(new ButtonListener(this));

        panel.revalidate(); //''
        panel.repaint(); //Uppdaterar panelens layout och säkerställer att alla ändringar visas korrekt.
    }

    private void restartGame() {
        newGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static ArrayList<JButton> getButtons() {
        return buttons;
    }

    public int getEmptyIndex() {
        return emptyIndex;
    }

    public void setEmptyIndex(int newEmptyIndex) {
        this.emptyIndex = newEmptyIndex;
    }
}