package kangkan.developer.resultprocessingsystem;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import kangkan.developer.resultprocessingsystem.Pojo.first_semester_result_response;
import kangkan.developer.resultprocessingsystem.Pojo.student_responce;
import kangkan.developer.resultprocessingsystem.interfaces.insert_student;
import kangkan.developer.resultprocessingsystem.interfaces.update_students;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Edit_result_Activity extends AppCompatActivity {

    AutoCompleteTextView ext_sub_1,ext_sub_2,ext_sub_3,ext_sub_4,ext_sub_5,ext_sub_6;
    Button update_data;

    public static final String BASE_URL = "https://untearable-trays.000webhostapp.com";
    private ProgressDialog pDialog;
    private update_students service;

    String[] languages = {"4.00 ", "3.75", "3.50", "3.25", "3.00", "2.75", "2.50", "2.25", "2.00", "0.00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_result);

        final student_responce aResponse = (student_responce) getIntent().getSerializableExtra("details");

        if(!isConnected(Edit_result_Activity.this)) buildDialog(Edit_result_Activity.this).show();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, languages);

        ext_sub_1=findViewById(R.id.eext_111);
        ext_sub_1.setText(aResponse.getIntroductionToComputerSystem());

        ext_sub_2=findViewById(R.id.eext_112);
        ext_sub_2.setText(aResponse.getProgrammingLanguage());

        ext_sub_3=findViewById(R.id.eext_113);
        ext_sub_3.setText(aResponse.getProgrammingLanguagePractical());

        ext_sub_4=findViewById(R.id.eext_114);
        ext_sub_4.setText(aResponse.getPhysics());

        ext_sub_5=findViewById(R.id.eext_115);
        ext_sub_5.setText(aResponse.getDifferentialCalculusAndCoOrdinateGeometry());

        ext_sub_6=findViewById(R.id.eext_116);
        ext_sub_6.setText(aResponse.getEnglish());

        ext_sub_1.setAdapter(adapter);
        ext_sub_1.setThreshold(1);

        ext_sub_2.setAdapter(adapter);
        ext_sub_2.setThreshold(1);

        ext_sub_3.setAdapter(adapter);
        ext_sub_3.setThreshold(1);

        ext_sub_4.setAdapter(adapter);
        ext_sub_4.setThreshold(1);

        ext_sub_5.setAdapter(adapter);
        ext_sub_5.setThreshold(1);

        ext_sub_6.setAdapter(adapter);
        ext_sub_6.setThreshold(1);

        update_data=findViewById(R.id.btn_Change_first_result);
        update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sub1,sub2,sub3,sub4,sub5,sub6;

                sub1=ext_sub_1.getText().toString();
                sub2=ext_sub_2.getText().toString();
                sub3=ext_sub_3.getText().toString();
                sub4=ext_sub_4.getText().toString();
                sub5=ext_sub_5.getText().toString();
                sub6=ext_sub_6.getText().toString();

                final student_responce aResponse = (student_responce) getIntent().getSerializableExtra("details");
                String reg=aResponse.getStudentReg();

                if (validateInputs()) {
                    update_first_result(reg,sub1,sub2,sub3,sub4,sub5,sub6);
                    displayLoader();
                }


            }
        });




    }

    private void update_first_result(String reg, String sub1, String sub2, String sub3, String sub4, String sub5, String sub6) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(update_students.class);

        Call<student_responce> call =service.updateStudentResult(reg,sub1,sub2,sub3,sub4,sub5,sub6);
        call.enqueue(new Callback<student_responce>() {
            @Override
            public void onResponse(Call<student_responce> call, Response<student_responce> response) {

                pDialog.dismiss();

                Intent i = new Intent(Edit_result_Activity.this, DashboardActivity.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onFailure(Call<student_responce> call, Throwable t) {

                Toast.makeText(Edit_result_Activity.this,"Failed to update ",Toast.LENGTH_LONG).show();
                pDialog.dismiss();
                /*Intent i = new Intent(Add_first_semester_result_Activity.this, DashboardActivity.class);
                startActivity(i);
                finish();*/
            }


        });
    }

    private boolean validateInputs() {

        if(ext_sub_1.length() == 0){
            ext_sub_1.setError("This part can not be empty");
            ext_sub_1.requestFocus();
            return false;
        }
        if(ext_sub_2.length() == 0){
            ext_sub_2.setError("This part can not be empty");
            ext_sub_2.requestFocus();
            return false;
        }
        if(ext_sub_3.length() == 0){
            ext_sub_3.setError("This part can not be empty");
            ext_sub_3.requestFocus();
            return false;
        }
        if(ext_sub_4.length() == 0){
            ext_sub_4.setError("This part can not be empty");
            ext_sub_4.requestFocus();
            return false;
        }
        if(ext_sub_5.length() == 0){
            ext_sub_5.setError("This part can not be empty");
            ext_sub_5.requestFocus();
            return false;
        }

        if(ext_sub_6.length() == 0){
            ext_sub_6.setError("This part can not be empty");
            ext_sub_6.requestFocus();
            return false;
        }
        return true;
    }

    private void displayLoader() {
        pDialog = new ProgressDialog(Edit_result_Activity.this);
        pDialog.setMessage("Saving data, please wait  ...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }

    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
            else return false;
        } else
            return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this.\nPress ok to Exit .. ");
        builder.setCancelable(false);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        return builder;
    }

}
