package com.Felix.mystringback;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    Button btn;
    char [] charset1;
    char [] charset2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editTextTextPersonName);
        ed2 = findViewById(R.id.editTextTextPersonName2);
        btn = findViewById(R.id.button);
    }

    public void Compare(View v){
        String string1 = ed1.getText().toString();
        String string2 = ed2.getText().toString();
        if (string1.isEmpty()){
            Toast.makeText(this, "Input string1",Toast.LENGTH_SHORT).show();
        }
        else if (string2.isEmpty()){
            Toast.makeText(this, "Input string2",Toast.LENGTH_SHORT).show();
        }
        else if (string1.length() != string2.length()){
            Toast.makeText(this, "String 2 is not a backstring for string1",Toast.LENGTH_SHORT).show();
        }
        else {
            charset1 = new char[string1.length()];
            charset2 = new char[string2.length()];
            string1.getChars(0,string1.length(),charset1,0);
            for (int i=0; i<string1.length()/2; i++) {
                char c = charset1[i];
                charset1[i] = charset1[string1.length() - 1 - i];
                charset1[string1.length() - 1 - i] = c;
            }
            Toast.makeText(this, new String(charset1),Toast.LENGTH_SHORT).show();
            if (new String(charset1).equals(string2)) {
                Toast.makeText(this, "String2 is a backstring for string1",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "String2 is not a backstring for string1",Toast.LENGTH_SHORT).show();
            }
        }

    }


}