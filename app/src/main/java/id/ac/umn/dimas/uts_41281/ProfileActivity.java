package id.ac.umn.dimas.uts_41281;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {
    private ImageView imvProfileAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Profile");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        imvProfileAuthor = findViewById(R.id.image_profile_author);

        Glide.with(this)
                .load(R.drawable.profile_author)
                .circleCrop()
                .into(imvProfileAuthor);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}