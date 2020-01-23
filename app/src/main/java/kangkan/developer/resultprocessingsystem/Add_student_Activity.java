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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kangkan.developer.resultprocessingsystem.Pojo.student_responce;
import kangkan.developer.resultprocessingsystem.interfaces.insert_student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Add_student_Activity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;

    EditText stu_name,stu_reg,stu_roll;

    Button save_stu;

    public static final String BASE_URL = "https://untearable-trays.000webhostapp.com";
    private ProgressDialog pDialog;
    private insert_student service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_);

        setTitle("Add student");

        if(!isConnected(Add_student_Activity.this)) buildDialog(Add_student_Activity.this).show();

        stu_name=findViewById(R.id.ext_stu_name);
        stu_reg=findViewById(R.id.ext_stu_reg);
        stu_roll=findViewById(R.id.ext_stu_roll);

        radioSexGroup = findViewById(R.id.radioSex);


        save_stu=findViewById(R.id.btn_save_stu);


        // Spinner element
        final Spinner dept = findViewById(R.id.spinner_dept);

        // Spinner click listener
        dept.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        final List<String> categories = new ArrayList<String>();
        categories.add("CSE");
        categories.add("BBA");

        final Spinner sec = findViewById(R.id.spinner_sec);
        // Spinner click listener
        sec.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> categories_sec = new ArrayList<String>();
        categories_sec.add("2015-16");
        categories_sec.add("2016-17");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories_sec);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        dept.setAdapter(dataAdapter);
        sec.setAdapter(dataAdapter2);




        save_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioSexGroup.getCheckedRadioButtonId();
                radioSexButton = findViewById(selectedId);
                //Toast.makeText(getBaseContext(), radioSexButton.getText(), Toast.LENGTH_SHORT).show();

                String s1,s2,s3,s4,s5,s6;
                s1=stu_name.getText().toString();
                s2=stu_roll.getText().toString();
                s3= stu_reg.getText().toString();
                s4= String.valueOf(dept.getSelectedItem());
                s5= String.valueOf(sec.getSelectedItem());
                s6=radioSexButton.getText().toString();

                if (categories.equals(""))
                {

                }else {
                    if (validateInputs()) {
                        save_student(s1, s2, s3, s4, s5, s6);
                        displayLoader();
                    }
                }

            }
        });




    }

    private void save_student(String s1, String s2, String s3, String s4, String s5, String s6) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(insert_student.class);

        Call<student_responce> call =service.insert_stu_data(s1,s2,s3,s4,s5,s6);
        call.enqueue(new Callback<student_responce>() {
            @Override
            public void onResponse(Call<student_responce> call, Response<student_responce> response) {

                pDialog.dismiss();
                /*Intent i = new Intent(Add_student_Activity.this, DashboardActivity.class);
                startActivity(i);
                finish();*/
                if (response.code() == 200)
                {
                    stu_reg.setError("Registration Exist");
                    stu_reg.requestFocus();
                }

            }

            @Override
            public void onFailure(Call<student_responce> call, Throwable t) {

                Toast.makeText(Add_student_Activity.this, "Student Details added", Toast.LENGTH_SHORT).show();
               Intent i = new Intent(Add_student_Activity.this, DashboardActivity.class);
                startActivity(i);
                finish();
                pDialog.dismiss();
            }


        });

    }

    private void displayLoader() {
        pDialog = new ProgressDialog(Add_student_Activity.this);
        pDialog.setMessage("Please wait ...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private boolean validateInputs() {

        if(stu_name.length() == 0){
            stu_name.setError("This part can not be empty");
            stu_name.requestFocus();
            return false;
        }

        if(stu_reg.length() == 0){
            stu_reg.setError("This part can not be empty");
            stu_reg.requestFocus();
            return false;
        }
        if(stu_roll.length() == 0){
            stu_roll.setError("This part can not be empty");
            stu_roll.requestFocus();
            return false;
        }

        return true;
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
