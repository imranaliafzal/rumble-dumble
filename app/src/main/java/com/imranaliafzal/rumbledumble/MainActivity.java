package com.imranaliafzal.rumbledumble;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout main_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_layout = findViewById(R.id.main_layout);

        findViewById(R.id.bt_matrix_rotation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lIntent = new Intent(v.getContext(),MatrixRotationActivity.class);
                startActivity(lIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

}
