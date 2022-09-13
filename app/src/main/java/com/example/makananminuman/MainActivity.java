package com.example.makananminuman;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText isi_menu;
    Button makan;
    Button minum;
    TextView jumlah_menu;
    public static final String MESSAGE_EXTRA1 = "MESSAGE_KEY1";
    public static final String MESSAGE_EXTRA2 = "MESSAGE_KEY2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isi_menu = findViewById(R.id.menu);
        makan = findViewById(R.id.makanan);
        minum = findViewById(R.id.minuman);
        jumlah_menu = findViewById(R.id.jumlah);

        makan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                String message1 = isi_menu.getText().toString();
                String message2 = "MAKANAN";
                intent.putExtra(MESSAGE_EXTRA1, message1);
                intent.putExtra(MESSAGE_EXTRA2, message2);
                startActivityForResult(intent, 1);

            }
        });

        minum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                String message1 = isi_menu.getText().toString();
                String message2 = "MINUMAN";
                intent.putExtra(MESSAGE_EXTRA1, message1);
                intent.putExtra(MESSAGE_EXTRA2, message2);
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String replyText = data.getStringExtra(SecondActivity.REPLY_EXTRA);
            jumlah_menu.setText(replyText);
        }
    }
}
