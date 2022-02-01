package android.com.yourbookk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class chatadmin extends AppCompatActivity {
//backBtn
    private  ImageView backmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatadmin);
        backmenu=findViewById(R.id.backBtn);
        backmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chatadmin.this, Menu.class);
                startActivity(intent);
            }

        });
    }
}