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
import com.naura.idn.kebudayaanindonesia.Adapter.GridWisataAdapter;
import com.naura.idn.kebudayaanindonesia.Model.Kebudayaan;
import com.naura.idn.kebudayaanindonesia.Data.MakananData;
import com.naura.idn.kebudayaanindonesia.R;
import com.naura.idn.kebudayaanindonesia.Data.WisataData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvBudaya;
    ArrayList<Kebudayaan> list = new ArrayList<>();
    WisataData wisataData = new WisataData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvBudaya = findViewById(R.id.rv_kebudayaan);
        rvBudaya.setHasFixedSize(true);
        list.addAll(wisataData.getListBudaya());
        showRecyclerGrid();
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
                showRecyclerGrid();
                break;
            case R.id.action_makanan:
                Intent intent1 = new Intent(MainActivity.this, MakananActivity.class);
                startActivity(intent1);
                break;
            case R.id.action_about:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void showRecyclerGrid() {
        rvBudaya.setLayoutManager(new LinearLayoutManager(this));
        GridWisataAdapter gridWisataAdapter = new GridWisataAdapter(list);
        rvBudaya.setAdapter(gridWisataAdapter);
        gridWisataAdapter.setOnItemClickCallBack(new GridWisataAdapter.onItemClickCallBack() {
            @Override
            public void onItemClicked(Kebudayaan data) {
                showSelectedBudaya(data);
            }
        });
    }

    private void showSelectedBudaya(Kebudayaan data) {
        Intent moveDetail = new Intent(MainActivity.this, DetailActivity.class);
        moveDetail.putExtra("EXTRA_DATA", data);
        startActivity(moveDetail);
    }


}
