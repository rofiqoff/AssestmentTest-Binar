package id.rofiqof.assesmenttest.module.tambah_data;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import id.rofiqof.assesmenttest.model.DataBarang;

public class TambahDataInteractor implements TambahDataInput {

    TambahDataOutput output;

    @Override
    public void addData(final DataBarang dataBarang) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabelListBarang = database.getReference("List");

        tabelListBarang.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tabelListBarang.child(dataBarang.getNama()).setValue(dataBarang);

                output.addDataSuccess("Successfully add Data");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                output.addDataSuccess("Failed add Data");
            }
        });

    }
}
