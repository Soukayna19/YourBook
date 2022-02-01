package android.com.yourbookk;

import androidx.appcompat.app.AppCompatActivity;

import android.com.yourbookk.R;
import android.com.yourbookk.ajouterlivreadmain;
import android.com.yourbookk.cmdadmin;
import android.com.yourbookk.fairepromotionadmain;
import android.com.yourbookk.modifierlivreaddm;
import android.com.yourbookk.welcomactivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class homeadmin extends AppCompatActivity {

    private ImageButton addlivre,modfiere;
    private TextView faireprom ;
    private ImageView commandeadm , logoutad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeadmin);
        addlivre = findViewById(R.id.addlivree);
        faireprom=findViewById(R.id.faire_promotion);
        commandeadm=findViewById(R.id.cdmadmin);
        logoutad=findViewById(R.id.logoutadmin);
        modfiere=findViewById(R.id.modfier);
        addlivre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeadmin.this, ajouterlivreadmain.class);
                startActivity(intent);
            }
        });
        faireprom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeadmin.this, fairepromotionadmain.class);
                startActivity(intent);
            }
        });
        commandeadm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeadmin.this, cmdadmin.class);
                startActivity(intent);
            }
        });
        logoutad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeadmin.this, welcomactivity.class);
                startActivity(intent);
            }
        });
        modfiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeadmin.this, modifierlivreaddm.class);
                startActivity(intent);
            }
        });

    }

}