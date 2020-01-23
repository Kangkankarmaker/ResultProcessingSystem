package kangkan.developer.resultprocessingsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kangkan.developer.resultprocessingsystem.Pojo.student_responce;
import kangkan.developer.resultprocessingsystem.interfaces.update_students;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Edit_student_details_Activity extends AppCompatActivity {

    public static final String BASE_URL = "https://untearable-trays.000webhostapp.com";
    private ProgressDialog pDialog;
    private update_students service;

    EditText stu_name,stu_reg,stu_roll,stu_dept,stu_sec,stu_gander;
    Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student_details);

        setTitle("Edit Student Details");

        final student_responce aResponse = (student_responce) getIntent().getSerializableExtra("details");

        stu_name=findViewById(R.id.ext_ed_stu_name);
        stu_reg=findViewById(R.id.ext_ed_stu_reg);
        stu_roll=findViewById(R.id.ext_ed_stu_roll);
        stu_dept=findViewById(R.id.ext_ed_stu_dept);
        stu_sec=findViewById(R.id.ext_ed_stu_sec);
        stu_gander=findViewById(R.id.ext_ed_stu_gender);
        btn_update=findViewById(R.id.btn_update);

        stu_name.setText(aResponse.getStudentName());
        stu_reg.setText(aResponse.getStudentReg());
        stu_roll.setText(aResponse.getStudentRoll());
        stu_dept.setText(aResponse.getStudentDept());
        stu_sec.setText(aResponse.getStudentSec());
        stu_gander.setText(aResponse.getStudentGender());

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id,name,reg,roll,dept,sec,gander,prv_reg;
                id=aResponse.getStudentId();
                prv_reg=aResponse.getStudentReg();
                name=stu_name.getText().toString();
                reg=stu_reg.getText().toString();
                roll=stu_roll.getText().toString();
                dept=stu_dept.getText().toString();
                sec=stu_sec.getText().toString();
                gander=stu_gander.getText().toString();
                updatedata(id,name,reg,roll,dept,sec,gander,prv_reg);
                displayLoader();
            }
        });

    }

    private void updatedata(String id, String name, String reg, String roll, String dept, String sec, String gander,String prv_reg) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(update_students.class);

        Call<student_responce> call =service.updateStudent(id,name,reg,roll,dept,sec,gander,prv_reg);
        call.enqueue(new Callback<student_responce>() {
            @Override
            public void onResponse(Call<student_responce> call, Response<student_responce> response) {

                Toast.makeText(Edit_student_details_Activity.this, "Information Updated", Toast.LENGTH_SHORT).show();
                pDialog.dismiss();
                Intent i = new Intent(Edit_student_details_Activity.this, DashboardActivity.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onFailure(Call<student_responce> call, Throwable t) {
                Toast.makeText(Edit_student_details_Activity.this,"Failed to updated data",Toast.LENGTH_LONG).show();
                pDialog.dismiss();
            }
        });

    }

    private void displayLoader() {
        pDialog = new ProgressDialog(Edit_student_details_Activity.this);
        pDialog.setMessage("Updating data, please wait ...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }
}
