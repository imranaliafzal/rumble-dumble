package com.imranaliafzal.rumbledumble;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MatrixRotationActivity extends AppCompatActivity {

    public static int N = 3;

    int[][] matrix = null;

    TextView tvMatrix;
    Button btRotate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_rotation);
        tvMatrix = findViewById(R.id.tv_matrix);
        btRotate = findViewById(R.id.bt_rotate_90);

        btRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateMatrix_90_degrees();
            }
        });

        findViewById(R.id.bt_rotate_180).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateMatrix_180_degrees();
            }
        });

        ((TextInputEditText)findViewById(R.id.et_dimensions)).setText(String.valueOf(N));

        ((TextInputEditText)findViewById(R.id.et_dimensions)).setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    N = Integer.valueOf(v.getText().toString());
                    matrix = generateMatrix(N);
                    displayMatrix(matrix, N);

                return false;
            }
        });
    }

    public int[][] generateMatrix(int size){
        int count=0;
        int[][] result = new int[size][size];
        for(int i=0; i < size; i++){
            for(int j=0; j< size; j++) {
                result[i][j] = count++;
            }
        }

        return result;
    }


    public void rotateMatrix_90_degrees(){
        int[][] rotatedMatrix = new int[N][N];

        displayMatrix(rotatedMatrix, N);

        for(int j=0; j < N; j++){

            for(int i=0; i < N; i++){
                rotatedMatrix[j][i] = matrix[i][N-1-j];
            }

        }

        displayMatrix(rotatedMatrix, N);
        matrix = rotatedMatrix;
    }


    public void rotateMatrix_180_degrees(){
        int[][] rotatedMatrix = new int[N][N];

        displayMatrix(rotatedMatrix, N);

        for(int j=0; j < N; j++){

            for(int i=0; i < N; i++){
                rotatedMatrix[j][i] = matrix[i][j];
            }

        }

        displayMatrix(rotatedMatrix, N);
        matrix = rotatedMatrix;
    }


    public void displayMatrix(int[][] pMatrix, int size){
        String textToBeDisplayed = "";

        DecimalFormat df = new DecimalFormat("00");

        for(int i=0; i < size; i++){
            for(int j=0; j < size; j++){

                textToBeDisplayed += "  "+df.format(pMatrix[i][j])+"  ";
            }

            textToBeDisplayed += "\n\n\n";
        }

        tvMatrix.setText(textToBeDisplayed);
    }
}
