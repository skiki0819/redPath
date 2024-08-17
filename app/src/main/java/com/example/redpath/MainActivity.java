package com.example.redpath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button startButton, nameBtn;
    EditText editText;
    TextView name,welcome;
    public static final String NAME = "name";
    public static final String SHARED_PREF= "sharedPrefs";
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        nameBtn = findViewById(R.id.nameBtn);
        name = findViewById(R.id.name);
        startButton=findViewById(R.id.startButton);
        editText = findViewById(R.id.editText);
        welcome = findViewById(R.id.welcome);
        startButton.setVisibility(View.INVISIBLE);
        welcome.setText("Welcome ");
        welcome.setVisibility(View.INVISIBLE);

        nameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText(editText.getText().toString());
                saveData();
                editText.setVisibility(View.INVISIBLE);
                nameBtn.setVisibility(View.INVISIBLE);
                startButton.setVisibility(View.VISIBLE);
                welcome.setVisibility(View.VISIBLE);
            }
        });
        loadData();
        updateViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (name.getText().length()!=0){
            editText.setVisibility(View.INVISIBLE);
            nameBtn.setVisibility(View.INVISIBLE);
            startButton.setVisibility(View.VISIBLE);
            welcome.setVisibility(View.VISIBLE);

        }
    }
    public void start(View v){
            Intent begin = new Intent(this, GameScreen.class);
            startActivity(begin);
        }
    private void saveData() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString(NAME, name.getText().toString());

        editor.apply();
    }
    public void loadData(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);

        text = sp.getString(NAME,"");
    }
    public void updateViews(){
        name.setText(text);
    }

}