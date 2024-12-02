package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class IncrementActivity extends AppCompatActivity {

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increment);
        counter = getIntent().getIntExtra("counter", 0);
        Button btnIncrement = findViewById(R.id.btn_increment);
        btnIncrement.setOnClickListener(view -> {
            counter++;
            Intent resultIntent = new Intent();
            resultIntent.putExtra("counter", counter);
            setResult(RESULT_OK, resultIntent);

            finish();
        });
    }
}
