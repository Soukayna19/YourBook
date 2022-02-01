package android.com.yourbookk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fairepromotionadmain extends AppCompatActivity {
    EditText nompromotion,prixinitialle,prixpromotion,descriptionppromotion,reduction,durie;
    Button promotion,image;
    ImageView imagepromotion;
    private static final int PIC = 1;
    private Uri uri;
    private String promotionRandomKey, downloadImagUrl;
    //   private StorageReference PromotionImagesRef;
    private DatabaseReference PromotionRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fairepromotionadmain);
        nompromotion=findViewById(R.id.nom_promotion);
        prixinitialle=findViewById(R.id.prixinitialle);
        prixpromotion=findViewById(R.id.prixpromotion);
        PromotionRef = FirebaseDatabase.getInstance().getReference("promotion");
        //PromotionImagesRef = FirebaseStorage.getInstance().getReference();
        descriptionppromotion=findViewById(R.id.descriptionpromotion);
        reduction=findViewById(R.id.reduction);
        durie=findViewById(R.id.duridepromotion);
        promotion=findViewById(R.id.ajoute_promotion);
        image=findViewById(R.id.imagepromotion);
        imagepromotion=findViewById(R.id.select_IMG);
        promotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fairepromotion();


            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,PIC);
            }
        });
    }
    private void Fairepromotion() {
        String prixinitialle = this.prixinitialle.getText().toString();
        String prixpromotion =this.prixpromotion.getText().toString();
        String nompromotion = this.nompromotion.getText().toString();
        String descriptionppromotion=this.descriptionppromotion.getText().toString();
        String reduction=this.reduction.getText().toString();
        String durie=this.durie.getText().toString();
        if (uri == null)
        {
            Toast.makeText(this, "promotion  image est mandatory...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(prixinitialle))
        {
            Toast.makeText(this, "prix initial est non valide  ", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(prixpromotion))
        {
            Toast.makeText(this, " prix promotion est vide ", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(nompromotion))
        {
            Toast.makeText(this, "le nom de promotion est vide ", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(descriptionppromotion)){
            Toast.makeText(this, "description est de promotion est vide ", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(reduction)){
            Toast.makeText(this, "reduction est vide  ", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(durie)){
            Toast.makeText(this, "durie est vide   ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            StoreProductInformation();
        }

    }
    private void StoreProductInformation()
    {

        //final StorageReference filePath = PromotionImagesRef.child(uri.getLastPathSegment() + promotionRandomKey + ".png");

        //final UploadTask uploadTask = filePath.putFile(uri);

        //uploadTask.addOnFailureListener(new OnFailureListener() {
        // @Override
        // public void onFailure(@NonNull Exception e) {
        //    String message = e.toString();
        //    Toast.makeText(promotionadminActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
    }
    //}).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
    // @Override
    // public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
    //Toast.makeText(promotionadminActivity.this, "vous fait une bon promotion ....", Toast.LENGTH_SHORT).show();
    // Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
    //  @Override
    // public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
    //     if (!task.isSuccessful())
    // {
    //    throw task.getException();

    // }

    // downloadImagUrl = filePath.getDownloadUrl().toString();
    // return filePath.getDownloadUrl();
    //  }
    //}).addOnCompleteListener(new OnCompleteListener<Uri>() {
    //   @Override
    // public void onComplete(@NonNull Task<Uri> task) {
    //   if (task.isSuccessful())
    //  {
    //  downloadImagUrl = task.getResult().toString();

    //Toast.makeText(addlivreActivity.this, "got the Product image Url Successfully...", Toast.LENGTH_SHORT).show();

    //  SaveProductInfoToDatabase();
    //}
    // }
    //});
    // }
    //});

    //}
    //private void SaveProductInfoToDatabase()


    //{
    //  String nompromotion=this.nompromotion.getText().toString();
    // String prixinitialle = this.prixinitialle.getText().toString();
    //String prixpromotion = this.prixpromotion.getText().toString();
    //String descriptionppromotion = this.descriptionppromotion.getText().toString();
    //String reduction = this.reduction.getText().toString();
    //String durie = this.durie.getText().toString();
    //Promotion promotion=new Promotion(nompromotion,prixinitialle,prixpromotion,descriptionppromotion,reduction,durie,downloadImagUrl);
    //HashMap<String, Object> promotionMap = new HashMap<>();
    //  promotionMap.put("descriptionppromotion", descriptionppromotion);
    // promotionMap.put("image", downloadImagUrl);
    // promotionMap.put("prixpromotion", prixpromotion);
    // promotionMap.put("nompromotion", nompromotion);
    //promotionMap.put("prixinitialle", prixinitialle);
    //promotionMap.put("reduction", reduction);
    // promotionMap.put("durie", durie);

    // PromotionRef.child(nompromotion).updateChildren(promotionMap)
    // .addOnCompleteListener(new OnCompleteListener<Void>() {
    //  @Override
    public void onComplete(@NonNull Task<Void> task)
    {
        if (task.isSuccessful())
        {
            Intent intent = new Intent(fairepromotionadmain.this, homeadmin.class);
            startActivity(intent);
            Toast.makeText(fairepromotionadmain.this, "le livre est bien ajouter....", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String message = task.getException().toString();
            Toast.makeText(fairepromotionadmain.this, "Error: " + message, Toast.LENGTH_SHORT).show();
        }
    }
    //   });
    //}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PIC||requestCode==RESULT_OK||data!=null||data.getData()!=null){
            uri=data.getData();
            imagepromotion.setImageURI(uri);
        }
    }
}