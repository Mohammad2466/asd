package com.example.myapplicationfasfasfa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "President App";
    Button btn_addOne;
    List<President> presidentList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myApplication = (MyApplication) this.getApplication();
        presidentList = myApplication.getPresidentList();

        Log.d(TAG, "onCreate: " + presidentList.toString());
        Toast.makeText(this, "President count " + presidentList.size(), Toast.LENGTH_SHORT).show();

        btn_addOne = findViewById(R.id.btn_addOne);
        btn_addOne.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddEditOne.class);
            startActivity(intent);
        });

        recyclerView = findViewById(R.id.lv_presidentList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerViewAdapter(presidentList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu); // Replace with your menu resource ID
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_aToz) {
            sortAtoZ();
            return true;
        } else if (itemId == R.id.menu_zToa) {
            sortZtoA();
            return true;
        } else if (itemId == R.id.menu_dataAsc) {
            sortAscending();
            return true;
        } else if (itemId == R.id.menu_dataDesc) {
            sortDescending();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // Method to sort list A to Z (replace with your actual sorting logic)
    private void sortAtoZ() {
        presidentList.sort(President.presidentComparator1);
        Toast.makeText(MainActivity.this, getString(R.string.a_z), Toast.LENGTH_SHORT).show();
        mAdapter.notifyDataSetChanged();
    }

    // Method to sort list Z to A  (replace with your actual sorting logic)
    private void sortZtoA() {
        presidentList.sort(President.presidentComparator2);
        Toast.makeText(MainActivity.this, getString(R.string.z_a), Toast.LENGTH_SHORT).show();
        mAdapter.notifyDataSetChanged();
    }

    // Method to sort list in ascending order (replace with your actual sorting logic)
    private void sortAscending() {
        presidentList.sort(President.presidentComparator3);
        Toast.makeText(MainActivity.this, getString(R.string.ascending), Toast.LENGTH_SHORT).show();
        mAdapter.notifyDataSetChanged();
    }

    // Method to sort list in descending order (replace with your actual sorting logic)
    private void sortDescending() {
        presidentList.sort(President.presidentComparator4);
        Toast.makeText(MainActivity.this, getString(R.string.descending), Toast.LENGTH_SHORT).show();
        mAdapter.notifyDataSetChanged();
    }
}
