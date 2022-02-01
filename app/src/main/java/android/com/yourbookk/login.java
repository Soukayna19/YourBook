package android.com.yourbookk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    DatabaseReference DatabaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://yourbook-501aa-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         final Button bnlogin = findViewById(R.id.loginbtn);
        final EditText eemail=findViewById(R.id.email_ytjext);
        final EditText modpasse =findViewById(R.id.password_edit_text);
        final  ProgressBar progressBar=findViewById(R.id.progressBar);

        //emailError=findViewById(R.id.emailrror);
        //passError=findViewById(R.id.passeror);
        final Button pas = findViewById(R.id.edt);
        //databaseReference= FirebaseDatabase.getInstance().getReference("clients");
                final TextView text=findViewById(R.id.title_view);
        //client = Client.getClient();

                text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, welcomactivity.class);
                startActivity(intent);
            }
        });

        bnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailText = eemail.getText().toString();
                final String passText = modpasse.getText().toString();
                if (emailText.isEmpty() || passText.isEmpty()) {
                    Toast.makeText(login.this, "please entre your email and password", Toast.LENGTH_SHORT).show();
                }

                else {
                    DatabaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // check if email / email is exist in firebase database

                            if(snapshot.hasChild(emailText)){
                                // email is exist in firebase database
                                // now get password of user from firebase data and match it with user entrered password
                                final String getPassword= snapshot.child(emailText).child("passwoord").getValue(String.class);
                                final String type= snapshot.child(emailText).child("type").getValue(String.class);

















                                if (type.equals("admin")){
                                    if(getPassword.equals(passText)){
                                        progressBar.setVisibility(View.INVISIBLE);
                                        Toast.makeText(login.this,"Successfully logged in ",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(login.this ,homeadmin.class));
                                        finish();
                                    }

                                    else {
                                        Toast.makeText(login.this,"wrong password",Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    if(getPassword.equals(passText)){
                                        progressBar.setVisibility(View.INVISIBLE);
                                        Toast.makeText(login.this,"Successfully logged in ",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(login.this ,Menu.class));
                                        finish();
                                    }

                                    else {
                                        Toast.makeText(login.this,"wrong password",Toast.LENGTH_SHORT).show();
                                    }
                                }




                            }
                            else{
                                Toast.makeText(login.this,"wrong email",Toast.LENGTH_SHORT).show();

                            }



                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });





                }

            }});
        pas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open register activity
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });

    }



}