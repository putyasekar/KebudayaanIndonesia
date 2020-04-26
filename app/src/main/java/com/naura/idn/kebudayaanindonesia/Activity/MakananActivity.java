package com.naura.idn.kebudayaanindonesia.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.naura.idn.kebudayaanindonesia.Adapter.GridMakananAdapter;
import com.naura.idn.kebudayaanindonesia.Data.MakananData;
import com.naura.idn.kebudayaanindonesia.Model.Kebudayaan;
import com.naura.idn.kebudayaanindonesia.R;

import java.util.ArrayList;

public class MakananActivity extends AppCompatActivity {
    MakananData makananData = new MakananData();
    RecyclerView rvMakanan;
    ArrayList<Kebudayaan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);
        rvMakanan = findViewById(R.id.rv_makanan);
        rvMakanan.setHasFixedSize(true);
        list.addAll(makananData.getListMakan());
        showRecyclerGridMakan();

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
                Intent intent2 = new Intent(MakananActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.action_makanan:
                Intent intent1 = new Intent(MakananActivity.this, MakananActivity.class);
                startActivity(intent1);
                break;
            case R.id.action_about:
                Intent intent = new Intent(MakananActivity.this, AboutActivity.class);
                startActivity(intent);
                break;

        }
    }

    private void showRecyclerGridMakan() {
        rvMakanan.setLayoutManager(new LinearLayoutManager(this));
        GridMakananAdapter gridMakananAdapter = new GridMakananAdapter(list);
        rvMakanan.setAdapter(gridMakananAdapter);
        gridMakananAdapter.setOnItemClickCallBack(new GridMakananAdapter.onItemClickCallBack() {
            @Override
            public void onItemClicked(Kebudayaan data) {
                showSelectedMakanan(data);
            }

        });
    }

    private void showSelectedMakanan(Kebudayaan data) {
        Intent moveDetail = new Intent(MakananActivity.this, DetailActivity.class);
        moveDetail.putExtra("EXTRA_DATA", data);
        startActivity(moveDetail);
    }
}