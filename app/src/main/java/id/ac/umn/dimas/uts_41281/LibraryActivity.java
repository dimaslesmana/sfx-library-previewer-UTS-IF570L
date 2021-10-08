package id.ac.umn.dimas.uts_41281;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    private RecyclerView rvSfxList;
    private ArrayList<Sfx> sfxList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        String username = getIntent().getStringExtra(EXTRA_NAME);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(username);
        }

        Toast.makeText(this, "Selamat datang, " + username, Toast.LENGTH_SHORT).show();

        sfxList.addAll(SfxData.getSfxList());

        rvSfxList = findViewById(R.id.rv_library_sfx);
        rvSfxList.setHasFixedSize(true);

        SfxAdapter sfxAdapter = new SfxAdapter(sfxList);
        rvSfxList.setAdapter(sfxAdapter);
        rvSfxList.setLayoutManager(new LinearLayoutManager(this));

        sfxAdapter.setOnItemClickCallback(new SfxAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Sfx data) {
                showSfxDetails(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_library, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setOption(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setOption(int selectedOption) {
        switch (selectedOption) {
            case R.id.action_profile:
                Intent profileIntent = new Intent(this, ProfileActivity.class);

                startActivity(profileIntent);
                break;
            case R.id.action_logout:
                Intent mainIntent = new Intent(this, MainActivity.class);

                startActivity(mainIntent);
                break;
        }
    }

    private void showSfxDetails(Sfx sfx) {
        Intent sfxDetailsIntent = new Intent(this, SfxDetailsActivity.class);
        sfxDetailsIntent.putExtra(SfxDetailsActivity.EXTRA_SFX, sfx);

        startActivity(sfxDetailsIntent);
    }
}