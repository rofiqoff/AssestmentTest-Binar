package id.rofiqof.assesmenttest.module.list_data;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import id.rofiqof.assesmenttest.model.DataBarang;

public class ListDataInteractor implements ListDataInput {

    ListDataOutput output;

    @Override
    public void getListData() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference tabelListBarang = database.getReference("List");

        tabelListBarang.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<DataBarang> data = new ArrayList<DataBarang>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    data.add(child.getValue(DataBarang.class));
                }
                    output.getListDataSuccess(data);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                output.getListDataFailed("Request Canceled");
            }
        });

    }
}
