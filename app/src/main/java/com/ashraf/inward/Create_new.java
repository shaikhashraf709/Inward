package com.ashraf.inward;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Create_new extends AppCompatActivity  {

    Spinner sp_type, sp_brand;     //dropdown list
    ArrayAdapter<CharSequence> type_adapter;
    ArrayAdapter<CharSequence> brand_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);

        sp_type=findViewById(R.id.job_type);
        sp_brand=findViewById(R.id.brand);


        type_adapter=ArrayAdapter.createFromResource(this,R.array.job_type,android.R.layout.simple_spinner_item);
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_type.setAdapter(type_adapter);

        sp_brand.setEnabled(false);






        sp_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                sp_brand.setEnabled(true);


                switch (parent.getItemAtPosition(i).toString()){

                    case "cpu":
                        brand_adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.cpu_brand,android.R.layout.simple_spinner_item);
                        brand_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        break;


                    case "monitor":
                        brand_adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.monitor_brand,android.R.layout.simple_spinner_item);
                        brand_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        break;

                    case "laptop":
                        brand_adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.laptop_brand,android.R.layout.simple_spinner_item);
                        brand_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        break;


                    case "printer":
                        brand_adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.printer_brand,android.R.layout.simple_spinner_item);
                        brand_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        break;

                    case "speakers":
                        brand_adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.speakers_brand,android.R.layout.simple_spinner_item);
                        brand_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        break;

                    case "other":
                        brand_adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.other,android.R.layout.simple_spinner_item);
                        brand_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        break;



                }
                sp_brand.setAdapter(brand_adapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        final FirebaseFirestore DB = FirebaseFirestore.getInstance();
        findViewById(R.id.CN_Submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name =((EditText)(findViewById(R.id.CN_Cust_Name))).getText().toString();
                //String Type= sp_type.getSelectedItem().toString();
                //String Brand= sp_brand.getSelectedItem().toString();
                //String Contact =((EditText)(findViewById(R.id.CN_Contact))).getText().toString();
                //String Description =((EditText)(findViewById(R.id.CN_Description))).getText().toString();
                //String Problem =((EditText)(findViewById(R.id.CN_Problem))).getText().toString();
                //String Accessories =((EditText)(findViewById(R.id.CN_Accessories))).getText().toString();
                //String Type=((RadioButton)findViewById(((RadioGroup)findViewById(R.id.CN_Type)).getCheckedRadioButtonId())).getText().toString();

                //Date date = Calendar.getInstance().getTime();
                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                //String Fdate = sdf.format(date);

                Map<String, Object> document = new HashMap<>();

                document.put("name", Name);
                document.put("pic", "https://1.bp.blogspot.com/-As2LicKAAw4/YFd92z49lSI/AAAAAAAAAus/9CGh5" +
                        "8Th2oEdfcTlRftpHoVeKUhoZsF7wCLcBGAsYHQ/s0/Placeholder.png");
                //Customer.put("Job_Type", Type);
                //Customer.put("Brand", Brand);
                //Customer.put("Description", Description);
                //Customer.put("Problem", Problem);
                //Customer.put("Accessories", Accessories);
                //Customer.put("Issuer", "Ashraf");
                //Customer.put("Inward_Date",Fdate);


                DB.collection("Profile")
                        .add(document)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                               Log.d("Ash", "DocumentSnapshot added with ID: " + documentReference.getId());
                                Toast.makeText(getApplicationContext(),"Data Added Successfully!",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Create_new.this,MainActivity.class));
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                               Log.w("Ash", "Error adding document", e);
                                Toast.makeText(getApplicationContext(),"Something Went Wrong!",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}