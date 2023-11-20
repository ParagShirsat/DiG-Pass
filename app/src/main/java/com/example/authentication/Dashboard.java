package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void onStudentLoginClick(View view) {
        // Create an Intent to open the StudentLoginActivity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onAdminLoginClick(View view) {
        // Create an Intent to open the AdminLoginActivity
        Intent intent = new Intent(this, Admin_login.class);
        startActivity(intent);
    }
    public void onStaffLoginClick(View view){
        Intent intent=new Intent(this,Staff_login.class );
        startActivity(intent);
    }
    public void onGuardLoginClick(View view) {
        // Create an Intent to open the GuardLoginActivity
        Intent intent = new Intent(this, security_login.class);
        startActivity(intent);
    }
}