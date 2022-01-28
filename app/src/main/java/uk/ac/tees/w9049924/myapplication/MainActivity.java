package uk.ac.tees.w9049924.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static java.net.Proxy.Type.HTTP;

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

    public void sendEmail(View view)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
        EditText emailMessage = (EditText) findViewById(R.id.editTextEmail);
        EditText emailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        String email = emailAddress.getText().toString();
        String emailmessage = emailMessage.getText().toString();
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailmessage);
        startActivity(emailIntent);
        //emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
// You can also attach multiple items by passing an ArrayList of Uris
    }
}