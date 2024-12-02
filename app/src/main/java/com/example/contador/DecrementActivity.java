package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DecrementActivity extends AppCompatActivity {

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrement);
        counter = getIntent().getIntExtra("counter", 0);
        Button btnDecrement = findViewById(R.id.btn_decrement);
        btnDecrement.setOnClickListener(view -> {
            counter--;
            Intent resultIntent = new Intent();
            resultIntent.putExtra("counter", counter);
            setResult(RESULT_OK, resultIntent);

            finish();
        });
    }
}
