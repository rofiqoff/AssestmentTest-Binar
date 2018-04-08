package id.rofiqof.assesmenttest.module.tambah_data;

import id.rofiqof.assesmenttest.model.DataBarang;

interface TambahDataInterface {
    void addData(DataBarang dataBarang);
}

interface TambahDataInput {
    void addData(DataBarang dataBarang);
}

interface TambahDataOutput {
    void addDataSuccess(String message);
    void addDataFailed(String message);
}
