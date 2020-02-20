package com.orangebd.retroobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.orangebd.retroobject.DataModel.DataList;
import com.orangebd.retroobject.DataModel.OtherOfficeList;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<DataList> ministryOffices = new ArrayList<>();
    private List<DataList> doptorOfficeesList = new ArrayList<>();
    private List<OtherOfficeList> otherOfficeList = new ArrayList<>();

    JsonArray ministryJsonArray;
    JsonArray doptorOffice;
    JsonObject otherOfficeJsonObject;
    JsonArray otherOfficeJsonArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MainActivity.this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        getData();

    }

    private void getData() {

        String url = String.format("cache/full_office_layer.json");

        EkShebaService mEkshebaService = RetrofitClass1.getRetrofitInstance().create(EkShebaService.class);
        Call<JsonObject> serviceRespone = mEkshebaService.getMinistryData(url);
        serviceRespone.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                String s = "";
                ministryJsonArray = response.body().getAsJsonArray("ministryOffices");
                doptorOffice = response.body().getAsJsonArray("doptorOfffices");
                otherOfficeJsonObject = response.body().getAsJsonObject("otherOffices");
                try {
                    getModelFromJsonObject(otherOfficeJsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                getModelFromJsonArray(doptorOffice);
                ministryOffices.addAll(getModelFromJsonArray(ministryJsonArray));
                doptorOfficeesList.addAll(getModelFromJsonArray(doptorOffice));

                String ss = "";


            }

            @Override

            public void onFailure(Call<JsonObject> call, Throwable t) {
                String s = "";
            }
        });
    }

    private void getModelFromJsonObject(JsonObject jsonObject) throws JSONException {

        // JsonArray jsonArray= jsonObject.toString();
        String s = jsonObject.toString();


        JSONObject mJsonObject = new JSONObject(s);


//            for(int aaaa=0; aaaa<mJsonObject.length(); aaaa++) {
//
//                JSONObject mJOSOOOO = mJsonObject.getJSONObject(aaaa + "");
//
//                String nameEn= mJOSOOOO.getString("name");
//            }

        Iterator<String> keys = jsonObject.keySet().iterator();


        while (keys.hasNext()) {
            OtherOfficeList otherOffice = new OtherOfficeList();
            String key = keys.next();
            JsonObject jsonObject1;
            jsonObject1= jsonObject.getAsJsonObject(key);

           otherOffice.setName(jsonObject1.getAsJsonObject().get("name").getAsString());

            otherOfficeJsonArray=jsonObject1.getAsJsonArray("offices");
           otherOffice.setOfficeList( getModelFromJsonArray(otherOfficeJsonArray));

           otherOfficeList.add(otherOffice);
        }

        String sss ="";



//        for(JsonElement data:mJsonObject)
//        {
//            OtherOfficeList otherOffice = new OtherOfficeList();
//            JsonArray jsonArray1 ;
//            jsonArray1=data.getAsJsonObject().getAsJsonArray("office");
//            otherOffice.setName(data.getAsJsonObject().get("name").getAsString());
//            otherOffice.setOfficeList(getModelFromJsonArray(jsonArray1));
//            otherOfficeList.add(otherOffice);
//        }

    }


    public List<DataList> getModelFromJsonArray(JsonArray jsonArray) {
        List<DataList> dataModelList = new ArrayList<>();

        for (JsonElement data : jsonArray) {
            DataList dataList = new DataList();
            dataList.setId(data.getAsJsonObject().get("id").getAsInt());
            dataList.setDistrict(data.getAsJsonObject().get("district").getAsInt());
            dataList.setDivision(data.getAsJsonObject().get("division").getAsInt());
            dataList.setOrigin(data.getAsJsonObject().get("origin").getAsInt());
            dataList.setName(data.getAsJsonObject().get("name").getAsString());
            dataList.setNameBn(data.getAsJsonObject().get("nameBn").getAsString());
            dataList.setUpazila(data.getAsJsonObject().get("upazila").getAsInt());
            dataList.setMinistry(data.getAsJsonObject().get("ministry").getAsInt());
            dataList.setLayer(data.getAsJsonObject().get("layer").getAsInt());

            dataModelList.add(dataList);
        }

        return dataModelList;

    }

}
