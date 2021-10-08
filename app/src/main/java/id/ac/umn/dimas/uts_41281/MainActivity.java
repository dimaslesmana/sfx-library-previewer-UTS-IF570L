package id.ac.umn.dimas.uts_41281;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnProfile;
    private Button btnLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        btnProfile = findViewById(R.id.button_main_profile);
        btnProfile.setOnClickListener(this);

        btnLibrary = findViewById(R.id.button_main_library);
        btnLibrary.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnProfile.getId()) {
            Intent profileIntent = new Intent(this, ProfileActivity.class);

            startActivity(profileIntent);
        } else if (v.getId() == btnLibrary.getId()) {
            Intent loginIntent = new Intent(this, LoginActivity.class);

            startActivity(loginIntent);
        }
    }
}