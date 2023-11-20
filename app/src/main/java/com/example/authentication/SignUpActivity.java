package com.example.authentication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class SignUpActivity extends AppCompatActivity {
    EditText signupName, signupUsername, signupEmail, signupPassword,signuproll;
    TextView loginRedirectText;
    Button signupButton;
    AutoCompleteTextView autoCompleteTextView,autoCompleteTextView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);
        signuproll = findViewById(R.id.signup_roll);
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView2=findViewById(R.id.autoCompleteTextView2);
        String[] branch = getResources().getStringArray(R.array.branch);
        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.dropdown_item, branch);
        // get reference to the autocomplete text view
        AutoCompleteTextView autocompleteTV = findViewById(R.id.autoCompleteTextView);
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter);
        String[] year = getResources().getStringArray(R.array.year);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, R.layout.dropdown_item, year);
        // get reference to the autocomplete text view
        AutoCompleteTextView autocompleteTV2 = findViewById(R.id.autoCompleteTextView2);
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter);
        autocompleteTV2.setAdapter(arrayAdapter2);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}