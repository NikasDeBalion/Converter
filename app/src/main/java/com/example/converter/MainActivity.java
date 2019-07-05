package com.example.converter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text_from_user;
    private TextView result;
    private Button btn;
    private float num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnBtnClick();
    }

    public void OnBtnClick() {
        this.text_from_user = findViewById(R.id.editText);
        this.result = findViewById(R.id.result_field);
        this.btn = findViewById(R.id.btn_convert);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_from_user.getText().toString();
                if (!text.matches("")) {
                    num = Float.parseFloat(text);

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Want to multiply by 2?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            num *= 1.61f * 2f;
                            result.setText(Float.toString(num));
                            btn.setText("Completed");
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                                btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                            else
                                btn.setBackgroundColor(Color.GREEN);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            num *= 1.61;
                            result.setText(Float.toString(num));
                            btn.setText("Completed");
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                                btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                            else
                                btn.setBackgroundColor(Color.GREEN);
                            dialog.cancel();
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.setTitle("Multiplication of numbers");
                    alert.show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Enter some text",
                            Toast.LENGTH_LONG).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    else
                        btn.setBackgroundColor(Color.RED);
                }
            }
        });
    }
}
