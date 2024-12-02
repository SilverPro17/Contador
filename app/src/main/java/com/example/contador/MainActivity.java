package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView counterTextView;

    private final ActivityResultLauncher<Intent> incrementLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    counter = result.getData().getIntExtra("counter", counter);
                    updateCounter();
                }
            });

    private final ActivityResultLauncher<Intent> decrementLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    counter = result.getData().getIntExtra("counter", counter);
                    updateCounter();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.tv_counter);

        Button btnIncrement = findViewById(R.id.btn_increment);
        btnIncrement.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, IncrementActivity.class);
            intent.putExtra("counter", counter);
            incrementLauncher.launch(intent);
        });

        Button btnDecrement = findViewById(R.id.btn_decrement);
        btnDecrement.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DecrementActivity.class);
            intent.putExtra("counter", counter);
            decrementLauncher.launch(intent);
        });

        Button btnReset = findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(view -> {
            counter = 0;
            updateCounter();
        });

        updateCounter();
    }

    private void updateCounter() {
        counterTextView.setText(String.valueOf(counter));
    }
}
