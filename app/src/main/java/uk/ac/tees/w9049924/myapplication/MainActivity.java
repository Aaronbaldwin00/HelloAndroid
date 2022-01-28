package uk.ac.tees.w9049924.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class); //Takes 2 parameters, A context and a class
        EditText editText = (EditText) findViewById(R.id.editText); //R is the God class and it is looking for the editText which is the text box in activity_display_message
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message); //Adds edit text to the intent - intents can carry data types called extras
        startActivity(intent);
    }
}