package android.com.yourbookk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cmdadmin extends AppCompatActivity {
    // addlivre = findViewById(R.id.addlivree);
    //validation
   private Button valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmdadmin);
        valid =findViewById(R.id.validation);
        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cmdadmin.this,infocommandclient.class);
                startActivity(intent);

            }
        });

    }
}