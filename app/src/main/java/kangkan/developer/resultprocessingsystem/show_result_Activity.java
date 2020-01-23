package kangkan.developer.resultprocessingsystem;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import kangkan.developer.resultprocessingsystem.Pojo.student_responce;
import kangkan.developer.resultprocessingsystem.adapter.resultAdapter;
import kangkan.developer.resultprocessingsystem.interfaces.show_student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class show_result_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText ext_stu_reg;
    Button save_stu;

    public static final String BASE_URL = "https://untearable-trays.000webhostapp.com";
    private ProgressDialog pDialog;
    private show_student service;

    private ListView listView;
    private List<student_responce> student = new ArrayList<>();
    private resultAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        if(!isConnected(show_result_Activity.this)) buildDialog(show_result_Activity.this).show();


        ext_stu_reg=findViewById(R.id.ext_reg);
        save_stu=findViewById(R.id.tb_see_result);

        setTitle("Show Student Result");

//MaterialBetterSpinner
        final Spinner semester = findViewById(R.id.spinner_semester);
        semester.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> categories_semester = new ArrayList<String>();
        categories_semester.add("Chose a semester");
        categories_semester.add("1st_semester");
        categories_semester.add("2nd_semester");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories_semester);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        semester.setAdapter(dataAdapter);


        save_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2;
                s1= ext_stu_reg.getText().toString();
                s2= String.valueOf(semester.getSelectedItem());
                
                if (validateInputs()){
                     if (s2.equals("Chose a semester"))
                    {
                        Toast.makeText(show_result_Activity.this, "Select a semester", Toast.LENGTH_SHORT).show();
                    }else {
                         getResult(s1, s2);
                         displayLoader();
                     }
                }
            }
        });


        listView = findViewById(R.id.listView_result);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String s;
                s = String.valueOf(semester.getSelectedItem());

                student_responce response = student.get(position);


                if (s.equals("1st_semester"))
                {

                    String sub_1_result,sub_2_result,sub_3_result,sub_4_result,sub_5_result,sub_6_result;

                    String sub_1_name="Introduction to computer system";
                    String sub_2_name="Programming language";
                    String sub_3_name="Programming language practical";
                    String sub_4_name="Physics";
                    String sub_5_name="Differential calculus and co-ordinate geometry";
                    String sub_6_name="English";

                    sub_1_result=response.getIntroductionToComputerSystem();
                    sub_2_result=response.getProgrammingLanguage();
                    sub_3_result=response.getProgrammingLanguagePractical();
                    sub_4_result=response.getPhysics();
                    sub_5_result=response.getDifferentialCalculusAndCoOrdinateGeometry();
                    sub_6_result=response.getEnglish();

                    String semester="1st semester result";

                    Intent intent=new Intent(show_result_Activity.this,show_result_details_Activity.class);
                    intent.putExtra("sub1_name",sub_1_name);
                    intent.putExtra("sub2_name",sub_2_name);
                    intent.putExtra("sub3_name",sub_3_name);
                    intent.putExtra("sub4_name",sub_4_name);
                    intent.putExtra("sub5_name",sub_5_name);
                    intent.putExtra("sub6_name",sub_6_name);

                    intent.putExtra("sub1_result",sub_1_result);
                    intent.putExtra("sub2_result",sub_2_result);
                    intent.putExtra("sub3_result",sub_3_result);
                    intent.putExtra("sub4_result",sub_4_result);
                    intent.putExtra("sub5_result",sub_5_result);
                    intent.putExtra("sub6_result",sub_6_result);
                    intent.putExtra("details", response);
                    intent.putExtra("semester", semester);
                    startActivity(intent);

                }
                else if (s.equals("2nd_semester"))
                {
                    String sub_1_result,sub_2_result,sub_3_result,sub_4_result,sub_5_result,sub_6_result,sub_7_result;

                    String sub_1_name="Data structure";
                    String sub_2_name="Data structure practical";
                    String sub_3_name="Introduction to electrical engineering";
                    String sub_4_name="Introduction to electrical engineering practical";
                    String sub_5_name="Integral calculus and diff eqn";
                    String sub_6_name="Statistic and probability";
                    String sub_7_name="Discrete mathematics";

                    String semester="2nd semester result";

                    sub_1_result=response.getDataStructure();
                    sub_2_result=response.getDataStructurePractical();
                    sub_3_result=response.getIntroductionToElectricalEnginnering();
                    sub_4_result=response.getIntroductionToElectricalEnginneringPractical();
                    sub_5_result=response.getIntegralCalculasAndDiffEqn();
                    sub_6_result=response.getStatisticAndProbability();
                    sub_7_result=response.getDiscreateMathematics();

                    Intent intent=new Intent(show_result_Activity.this,show_result_details_Activity.class);
                    intent.putExtra("sub1_name",sub_1_name);
                    intent.putExtra("sub2_name",sub_2_name);
                    intent.putExtra("sub3_name",sub_3_name);
                    intent.putExtra("sub4_name",sub_4_name);
                    intent.putExtra("sub5_name",sub_5_name);
                    intent.putExtra("sub6_name",sub_6_name);
                    intent.putExtra("sub7_name",sub_7_name);

                    intent.putExtra("sub1_result",sub_1_result);
                    intent.putExtra("sub2_result",sub_2_result);
                    intent.putExtra("sub3_result",sub_3_result);
                    intent.putExtra("sub4_result",sub_4_result);
                    intent.putExtra("sub5_result",sub_5_result);
                    intent.putExtra("sub6_result",sub_6_result);
                    intent.putExtra("sub7_result",sub_7_result);
                    intent.putExtra("details", response);
                    intent.putExtra("semester", semester);
                    startActivity(intent);
                }


            }
        });

    }

    private void getResult(String s1, String s2) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(show_student.class);

        Call<List<student_responce>> call =service.getStudentResult(s1,s2);
        call.enqueue(new Callback<List<student_responce>>() {
            @Override
            public void onResponse(Call<List<student_responce>>call, Response<List<student_responce>> response) {

                if (response.code() == 200){
                    student =response.body();
                    studentAdapter = new resultAdapter(show_result_Activity.this, student);
                    listView.setAdapter(studentAdapter);
                    pDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<List<student_responce>> call, Throwable t) {


                ext_stu_reg.setError("Invalid Registration");
                ext_stu_reg.requestFocus();
                pDialog.dismiss();
            }


        });
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
        if(ext_stu_reg.equals(0)){
            ext_stu_reg.setError("Registration cannot be empty");
            ext_stu_reg.requestFocus();
            return false;
        }
        return true;
    }
    private void displayLoader() {
        pDialog = new ProgressDialog(show_result_Activity.this);
        pDialog.setMessage("Please wait...");
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
