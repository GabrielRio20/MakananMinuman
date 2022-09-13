package com.example.makananminuman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView menu2;
    TextView kategori_menu;
    EditText jumlah_2;
    Button ok_2;
    public static final String REPLY_EXTRA = "REPLY_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        menu2 = findViewById(R.id.nama_menu2);
        kategori_menu = findViewById(R.id.kategori);
        jumlah_2 = findViewById(R.id.jumlah2);
        ok_2 = findViewById(R.id.ok2);

        Intent intent = getIntent();
        String message1 = intent.getStringExtra(MainActivity.MESSAGE_EXTRA1);
        String message2 = intent.getStringExtra(MainActivity.MESSAGE_EXTRA2);
        menu2.setText(message1);
        kategori_menu.setText(message2);

        ok_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String message = jumlah_2.getText().toString();
                intent.putExtra(REPLY_EXTRA, message);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
