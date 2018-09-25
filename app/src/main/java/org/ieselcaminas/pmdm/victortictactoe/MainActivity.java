package org.ieselcaminas.pmdm.victortictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    class Player{
        public String name, symbol;

        public Player(String name, String symbol){
            this.name = name;
            this.symbol = symbol;
        }
    }


    private Player p1;
    private Player p2;
    private Player currPlayer;
    public static final int NUM_ROWS = 3;
    private Button[][] buttons;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1 = new Player("1", "X");
        p2 = new Player("2","X");
        currPlayer = p1;

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        gridLayout.setColumnCount(NUM_ROWS);
        gridLayout.setRowCount(NUM_ROWS);

        addButtons(gridLayout);
    }



    private void addButtons(GridLayout gridLayout) {
        buttons = new Button [NUM_ROWS][NUM_ROWS];
        for(int row = 0; row < NUM_ROWS; row++){
            for(int col = 0;col<NUM_ROWS; col++){
                buttons[row][col] =new Button(this,null,android.R.attr.buttonStyleSmall);
                gridLayout.addView(buttons[row][col]);
                addListenerToButton(buttons[row][col]);
            }
        }
    }
    private void addListenerToButton(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                button.setText(currPlayer.symbol);
                changePlayer();
                displayTurn();

            }
        });
    }

    private void displayTurn() {
        TextView textView = findViewById(R.id.textTurn);
        textView.setText("Turn Player " + currPlayer + "    Symbol" + currPlayer.symbol);
    }

    private void changePlayer() {
        if(currPlayer==p1){
            currPlayer=p2;
        }else{
            currPlayer=p1;
        }
    }

}
