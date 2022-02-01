package android.com.yourbookk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcomactivity extends AppCompatActivity {
    private Button skipe , logine , singupp;
    private TextView text;
    //skip login sinup

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomactivity);
        skipe=findViewById(R.id.skip);
        logine=findViewById(R.id.login);
        singupp=findViewById(R.id.sinup);
        text=findViewById(R.id.title_view);
        text.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent xx= new Intent(welcomactivity.this,demarage.class);
                                        startActivity(xx);
                                    }
                                });


                skipe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(welcomactivity.this, skipe.class);
                        startActivity(intent);
                    }
                });
        logine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcomactivity.this, login.class);
                startActivity(intent);
            }
        });
        singupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcomactivity.this, signup.class);
                startActivity(intent);
            }
        });
    }
}