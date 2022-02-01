package android.com.yourbookk;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
// create objet database reference class to acces firebase realtime database


public class signup extends AppCompatActivity {
    DatabaseReference DatabaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://yourbook-501aa-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText  name = findViewById(R.id.nom);
       final EditText  prenom = findViewById(R.id.prenom_text);
        final EditText  email = findViewById(R.id.email_text);
       final EditText  pass = findViewById(R.id.password_edit);
       //final ProgressBar progressbar= findViewById(R.id.progressBar1);
        final Button crercompte = findViewById(R.id.creerv);
        final TextView text = findViewById(R.id.title_view);


        crercompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String namee=name.getText().toString();
                final String prenonn=prenom.getText().toString();
                final String emaile=email.getText().toString();
                final String password=pass.getText().toString();

                if(namee.isEmpty() || prenonn.isEmpty()|| emaile.isEmpty() || password.isEmpty()  )  {
                    Toast.makeText(signup.this, "All fields are required ", Toast.LENGTH_SHORT).show();
                }

                else {
                    DatabaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // check if phone is not regiser before
                            if(snapshot.hasChild(emaile)){
                                Toast.makeText(signup.this,"email is already registrerd",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                //sending data to firebase Realtime Database
                                DatabaseReference.child("user").child(emaile).child("nom").setValue(namee);
                                DatabaseReference.child("user").child(emaile).child("prenon").setValue(prenonn);
                                DatabaseReference.child("user").child(emaile).child("passwoord").setValue(password);

                                // show a succes message then finish the activity
                                Toast.makeText(signup.this,"User register successfull ",Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }

            }});



        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, welcomactivity.class);
                startActivity(intent);
            }
        });





    }




}
