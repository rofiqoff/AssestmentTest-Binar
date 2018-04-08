package id.rofiqof.assesmenttest.module.list_data;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import id.rofiqof.assesmenttest.model.DataBarang;

public class ListDataInteractor implements ListDataInput {

    ListDataOutput output;

    @Override
    public void getListData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference tabelListBarang = database.getReference("List");

        tabelListBarang.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    DataBarang dataBarang = dataSnapshot.getValue(DataBarang.class);
                    output.getListDataSuccess(dataBarang);
                } else {
                    output.getListDataFailed("Data not exist");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                output.getListDataFailed("Request Canceled");
            }
        });

    }
}
