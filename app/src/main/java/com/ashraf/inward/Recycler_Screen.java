package com.ashraf.inward;

import android.os.Bundle;


import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

public class Recycler_Screen extends AppCompatActivity {


    RecyclerView rv;
    InwardAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_screen);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        Query query = FirebaseFirestore.getInstance().collection("Profile").limit(10);

        FirestoreRecyclerOptions<Inward_Model> options = new FirestoreRecyclerOptions.Builder<Inward_Model>()
                .setQuery(query,Inward_Model.class).build();



        rv= findViewById(R.id.rvInwards);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new InwardAdapter(options);


        rv.setAdapter(adapter);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show(); }
        });





    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}