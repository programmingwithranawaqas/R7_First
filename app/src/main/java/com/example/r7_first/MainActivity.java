package com.example.r7_first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit, btnCancel;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etID.getText().toString();
                if(id.isEmpty())
                {
                    //etID.setError("ID can't be empty");
                    Toast.makeText(MainActivity.this, getString(R.string.id_can_t_be_empty), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(id.length() != 13)
                    {
                        Toast.makeText(MainActivity.this, getString(R.string.invalid_id_length_should_be_13), Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        String dob = id.substring(0,6);
                        String gender = id.substring(6,10);
                        char citizenship = id.charAt(10);
                        char validity = id.charAt(12);

                        String text = "Date of birth : "+dob
                                +"\nGender : "+gender+
                                "\nCitizenship : "+citizenship
                                +"\nValidity : "+validity;

                        tvResult.setText(text);
                        tvResult.setVisibility(View.VISIBLE);
                    }
                }
            }
        });


    }

    private void init()
    {
        etID = findViewById(R.id.etID);
        btnCancel = findViewById(R.id.btnCancel);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
        tvResult.setVisibility(View.GONE);
    }
}