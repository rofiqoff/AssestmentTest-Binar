package id.rofiqof.assesmenttest.module.list_data;

import android.content.Context;

import java.util.List;

import id.rofiqof.assesmenttest.model.DataBarang;

interface ListDataInterface {
    void getListData();
    void toAddList(Context context);
}

interface ListDataInput {
    void getListData();
}

interface ListDataOutput {
    void getListDataSuccess(List<DataBarang> data);
    void getListDataFailed(String message);
}
