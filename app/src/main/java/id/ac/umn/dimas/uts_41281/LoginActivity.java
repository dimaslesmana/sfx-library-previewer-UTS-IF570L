package id.ac.umn.dimas.uts_41281;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etInputName;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        etInputName = findViewById(R.id.et_login_name);

        btnNext = findViewById(R.id.button_login_next);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnNext.getId()) {
            String username = etInputName.getText().toString();

            if (username.trim().isEmpty()) {
                etInputName.setError("Harap Di-isi");
                return;
            }

            Intent libraryIntent = new Intent(this, LibraryActivity.class);
            libraryIntent.putExtra(LibraryActivity.EXTRA_NAME, username);

            startActivity(libraryIntent);
        }
    }
}