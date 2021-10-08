package id.ac.umn.dimas.uts_41281;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SfxDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_SFX = "extra_sfx";
    private TextView tvSfxName;
    private TextView tvSfxCategory;
    private Button btnSfxPlay;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfx_details);

        Sfx sfx = getIntent().getParcelableExtra(EXTRA_SFX);
        String sfxName = sfx.getName();
        String sfxCategory = sfx.getCategory();
        int sfxSource = sfx.getSource();

        mediaPlayer = MediaPlayer.create(this, sfxSource);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(sfxName);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tvSfxName = findViewById(R.id.tv_sfx_details_name);
        tvSfxName.setText(sfxName);

        tvSfxCategory = findViewById(R.id.tv_sfx_details_category);
        tvSfxCategory.setText(sfxCategory);

        btnSfxPlay = findViewById(R.id.button_sfx_details_play);
        btnSfxPlay.setOnClickListener(v -> {
            mediaPlayer.start();
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}