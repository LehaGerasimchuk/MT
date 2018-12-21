package com.example.admin.mt_lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button[][] fields = new Button[3][3];
    TableLayout layout;
    int leadCounter = 0;
    boolean currentPlayer1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.table);

        buildGame();
    }

    private void buildGame() {

        for(int i = 0; i < 3; i++){
            TableRow row = new TableRow(this);
            for(int j = 0; j < 3; j++){
                final Button button = new Button(this);
                fields[i][j] = button;
                row.addView(button, new TableRow.LayoutParams(360, 560));
                fields[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(currentPlayer1){
                            button.setText("X");
                            button.setClickable(false);
                            leadCounter++;
                            checkVictory();
                            currentPlayer1 = !currentPlayer1;
                        }else{
                            button.setText("O");
                            button.setClickable(false);
                            leadCounter++;
                            checkVictory();
                            currentPlayer1 = !currentPlayer1;
                        }
                    }
                });
            }

            layout.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
        }
    }

    private void checkVictory(){

        if(fields[0][0].getText() == "X" && fields[0][1].getText() == "X" && fields[0][2].getText() == "X"
        || fields[1][0].getText() == "X" && fields[1][1].getText() == "X" && fields[1][2].getText() == "X"
        || fields[2][0].getText() == "X" && fields[2][1].getText() == "X" && fields[2][2].getText() == "X"
        || fields[0][0].getText() == "X" && fields[1][0].getText() == "X" && fields[2][0].getText() == "X"
        || fields[0][1].getText() == "X" && fields[1][1].getText() == "X" && fields[2][1].getText() == "X"
        || fields[0][2].getText() == "X" && fields[1][2].getText() == "X" && fields[2][2].getText() == "X"
        || fields[0][0].getText() == "X" && fields[1][1].getText() == "X" && fields[2][2].getText() == "X"
        || fields[0][2].getText() == "X" && fields[1][1].getText() == "X" && fields[2][0].getText() == "X"){

            Toast.makeText(this, "Player 1 (X) won!", Toast.LENGTH_SHORT).show();
            refresh();
        }
        else if(fields[0][0].getText() == "O" && fields[0][1].getText() == "O" && fields[0][2].getText() == "O"
             || fields[1][0].getText() == "O" && fields[1][1].getText() == "O" && fields[1][2].getText() == "O"
             || fields[2][0].getText() == "O" && fields[2][1].getText() == "O" && fields[2][2].getText() == "O"
             || fields[0][0].getText() == "O" && fields[1][0].getText() == "O" && fields[2][0].getText() == "O"
             || fields[0][1].getText() == "O" && fields[1][1].getText() == "O" && fields[2][1].getText() == "O"
             || fields[0][2].getText() == "O" && fields[1][2].getText() == "O" && fields[2][2].getText() == "O"
             || fields[0][0].getText() == "O" && fields[1][1].getText() == "O" && fields[2][2].getText() == "O"
             || fields[0][2].getText() == "O" && fields[1][1].getText() == "O" && fields[2][0].getText() == "O"){

            Toast.makeText(this, "Player 2 (O) won!", Toast.LENGTH_SHORT).show();
            refresh();
        }
        else if(leadCounter == 9){
            Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
            refresh();
        }
    }

    private void refresh(){

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){

                fields[i][j].setText("");
                fields[i][j].setClickable(true);
                leadCounter = 0;
            }
        }
    }
}
