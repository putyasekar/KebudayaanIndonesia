package com.naura.idn.kebudayaanindonesia.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.naura.idn.kebudayaanindonesia.Adapter.GridMakananAdapter;
import com.naura.idn.kebudayaanindonesia.Adapter.GridWisataAdapter;
import com.naura.idn.kebudayaanindonesia.Model.Kebudayaan;
import com.naura.idn.kebudayaanindonesia.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId) {
            case R.id.action_wisata:
                Intent intent2 = new Intent(AboutActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.action_makanan:
                Intent intent1 = new Intent(AboutActivity.this, MakananActivity.class);
                startActivity(intent1);
                break;
            case R.id.action_about:
                Intent intent = new Intent(AboutActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }
    }
}