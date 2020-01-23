package kangkan.developer.resultprocessingsystem;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import kangkan.developer.resultprocessingsystem.Pojo.student_responce;

public class show_result_details_Activity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result_details);

        final student_responce aResponse = (student_responce) getIntent().getSerializableExtra("details");


        TextView sem=findViewById(R.id.txt_semester);
        sem.setText("Result Processing system"+"\n"+getIntent().getStringExtra("semester"));


        TextView textView_stu_name=findViewById(R.id.rtxt_student_name);
        textView_stu_name.setText("Name   :  "+aResponse.getStudentName());

        TextView textView_stu_roll=findViewById(R.id.rtxt_student_roll);
        textView_stu_roll.setText("Roll       :  "+aResponse.getStudentRoll());

        TextView textView_stu_reg=findViewById(R.id.rtxt_student_reg);
        textView_stu_reg.setText("Reg.      :  "+aResponse.getStudentReg());

        TextView textView_stu_dept=findViewById(R.id.rtxt_student_dept);
        textView_stu_dept.setText("Dept.    :  "+aResponse.getStudentDept());

        TextView textView_stu_sec=findViewById(R.id.rtxt_student_sec);
        textView_stu_sec.setText("Sec.      :  "+aResponse.getStudentSec());

        TextView textView_stu_gander=findViewById(R.id.rtxt_student_gender);
        textView_stu_gander.setText("Gander :  "+aResponse.getStudentGender());

        TextView textView_stu_cgpa=findViewById(R.id.rtxt_student_cgpa);
        textView_stu_cgpa.setText("CGPA :  "+aResponse.getC_gpa());


        TextView textView_sub1=findViewById(R.id.txt_sub_1);
        textView_sub1.setText(getIntent().getStringExtra("sub1_name"));

        TextView textView_sub2=findViewById(R.id.txt_sub_2);
        textView_sub2.setText(getIntent().getStringExtra("sub2_name"));

        TextView textView_sub3=findViewById(R.id.txt_sub_3);
        textView_sub3.setText(getIntent().getStringExtra("sub3_name"));

        TextView textView_sub4=findViewById(R.id.txt_sub_4);
        textView_sub4.setText(getIntent().getStringExtra("sub4_name"));

        TextView textView_sub5=findViewById(R.id.txt_sub_5);
        textView_sub5.setText(getIntent().getStringExtra("sub5_name"));

        TextView textView_sub6=findViewById(R.id.txt_sub_6);
        textView_sub6.setText(getIntent().getStringExtra("sub6_name"));

        TextView textView_sub7=findViewById(R.id.txt_sub_7);
        textView_sub7.setText(getIntent().getStringExtra("sub7_name"));


        TextView textView_sub_result_1=findViewById(R.id.txt_sub_result_1);
        textView_sub_result_1.setText(getIntent().getStringExtra("sub1_result"));

        TextView textView_sub_result_2=findViewById(R.id.txt_sub_result_2);
        textView_sub_result_2.setText(getIntent().getStringExtra("sub2_result"));

        TextView textView_sub_result_3=findViewById(R.id.txt_sub_result_3);
        textView_sub_result_3.setText(getIntent().getStringExtra("sub3_result"));

        TextView textView_sub_result_4=findViewById(R.id.txt_sub_result_4);
        textView_sub_result_4.setText(getIntent().getStringExtra("sub4_result"));

        TextView textView_sub_result_5=findViewById(R.id.txt_sub_result_5);
        textView_sub_result_5.setText(getIntent().getStringExtra("sub5_result"));

        TextView textView_sub_result_6=findViewById(R.id.txt_sub_result_6);
        textView_sub_result_6.setText(getIntent().getStringExtra("sub6_result"));

        TextView textView_sub_result_7=findViewById(R.id.txt_sub_result_7);
        textView_sub_result_7.setText(getIntent().getStringExtra("sub7_result"));


    }
}
