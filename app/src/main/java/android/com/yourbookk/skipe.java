package android.com.yourbookk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class skipe extends AppCompatActivity {
    private ImageView homeskip , calladm , dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skipe);
        homeskip=findViewById(R.id.skiplivre);
        calladm=findViewById(R.id.call);
        dec=findViewById(R.id.dec);
        homeskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(skipe.this, skiplivre.class);
                startActivity(intent);
            }
        });
        calladm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(skipe.this, chatadmin.class);
                startActivity(intent);
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(skipe.this, welcomactivity.class);
                startActivity(intent);
            }
        });

    }
}