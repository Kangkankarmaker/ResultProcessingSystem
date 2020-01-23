package kangkan.developer.resultprocessingsystem;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kangkan.developer.resultprocessingsystem.Pojo.student_responce;
import kangkan.developer.resultprocessingsystem.adapter.stu_manage_adapter;
import kangkan.developer.resultprocessingsystem.interfaces.show_student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Manage_result_2_Activity extends AppCompatActivity {

    public static final String BASE_URL = "https://untearable-trays.000webhostapp.com";
    private show_student service;

    private ListView listView;
    private List<student_responce> student = new ArrayList<>();
    private stu_manage_adapter studentAdapter;

    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_result_2);
        setTitle("Manage Result");


        final student_responce aResponse = (student_responce) getIntent().getSerializableExtra("details");
        String reg=aResponse.getStudentReg();

        show_all_student(reg);
        displayLoader();


        listView = findViewById(R.id.listView_manage_stu_2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });
    }

    private void show_all_student(String reg) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(show_student.class);

        Call<List<student_responce>> call =service.getStudentSemesterResult(reg);
        call.enqueue(new Callback<List<student_responce>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<List<student_responce>> call, Response<List<student_responce>> response) {
                if (response.code() == 200){
                    student =response.body();
                    studentAdapter = new stu_manage_adapter(Manage_result_2_Activity.this, student);
                    listView.setAdapter(studentAdapter);
                    pDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<student_responce>> call, Throwable t) {
                Toast.makeText(Manage_result_2_Activity.this, "Failed to connect Database..", Toast.LENGTH_SHORT).show();
                pDialog.dismiss();
            }
        });
    }
    private void displayLoader() {
        pDialog = new ProgressDialog(Manage_result_2_Activity.this);
        pDialog.setMessage("Showing data, Please wait ...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }


}
