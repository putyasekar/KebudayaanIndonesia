package com.naura.idn.kebudayaanindonesia.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.naura.idn.kebudayaanindonesia.Adapter.GridWisataAdapter;
import com.naura.idn.kebudayaanindonesia.Model.Kebudayaan;
import com.naura.idn.kebudayaanindonesia.R;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private TextView detailName, detailInfo;
    private ImageView detailPhoto;
    RecyclerView rvBudaya;
    ArrayList<Kebudayaan> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailName = findViewById(R.id.tv_detail_name);
        detailInfo = findViewById(R.id.tv_detail_info);
        detailPhoto = findViewById(R.id.img_detail_photo);

        final Kebudayaan data = (Kebudayaan) getIntent().getSerializableExtra("EXTRA_DATA");
        Glide.with(this).load(data.getPhoto())
                .apply(new RequestOptions().override(550, 350))
                .into(detailPhoto);
        detailName.setText(data.getName());
        detailInfo.setText(data.getInfo());
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
                Intent intent2 = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.action_makanan:
                Intent intent1 = new Intent(DetailActivity.this, MakananActivity.class);
                startActivity(intent1);
                break;
            case R.id.action_about:
                Intent intent = new Intent(DetailActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }
    }
}