package com.example.myapplicationfasfasfa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class AddEditOne extends AppCompatActivity {

    Button btn_ok,btn_cancle;
    List<President> presidentList;
    MyApplication myApplication = (MyApplication) this.getApplication();

    EditText et_presdata, et_presidentName, et_presidentImage;
    TextView tv_presId;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_edit_one);

        presidentList = myApplication.getPresidentList();

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancle = findViewById(R.id.btn_cancle);
        et_presidentName = findViewById(R.id.et_presName);
        et_presdata = findViewById(R.id.et_date);
        et_presidentImage = findViewById(R.id.et_presImage);
        tv_presId = findViewById(R.id.tv_presidentIdNumber);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        President president = null;

        if (id >= 0){
            // Edit the president
            for (President p : presidentList){
                if (p.getId() == id){
                    president = p;
                }
            }
            et_presidentName.setText(president.getName());
            et_presdata.setText(String.valueOf(president.getData()));
            et_presidentImage.setText(president.getImage());
            tv_presId.setText(String.valueOf(id));
        }else {
            // Create a new president
        }
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id >- 0){
                    // Update
                    President updatePresident = new President(id, et_presidentName.getText().toString(), Integer.parseInt(et_presdata.getText().toString()), et_presidentImage.getText().toString());
                    presidentList.set(id, updatePresident);
                }else {
                    // Create president object
                    int nextID = myApplication.getNextId();
                    President president = new President(nextID, et_presidentName.getText().toString(), Integer.parseInt(et_presdata.getText().toString()), et_presidentImage.getText().toString());

                    // Add the object to the global list of President
                    presidentList.add(president);
                    myApplication.setNextId(nextID++);
                }
                // Go back to the main activity
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}