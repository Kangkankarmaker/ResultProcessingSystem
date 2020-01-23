package kangkan.developer.resultprocessingsystem;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import kangkan.developer.resultprocessingsystem.Pojo.User;
import kangkan.developer.resultprocessingsystem.admin_session.SessionHandler;

public class DashboardActivity extends AppCompatActivity {

    private SessionHandler session;

    Dialog myDialog;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setTitle("Teacher | Admin penal");

        myDialog = new Dialog(this);

        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
        TextView welcomeText = findViewById(R.id.welcomeText);

        welcomeText.setText("Welcome : "+user.getAdmin_name()
                +"\n"+"\n"+user.getAdmin_email());

        Button logoutBtn = findViewById(R.id.btnLogout);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
                Intent i = new Intent(DashboardActivity.this, WelcomeActivity.class);
                startActivity(i);
                finish();

            }
        });


        Button adstudent = findViewById(R.id.btn_add_student);
        adstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, Add_student_Activity.class);
                startActivity(i);
            }
        });

        Button manage_stu = findViewById(R.id.btn_manage_stu);
        manage_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, Show_all_student_Activity.class);
                startActivity(i);
            }
        });

        Button manage_reu = findViewById(R.id.btn_manage_result);
        manage_reu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, Manage_result_Activity.class);
                startActivity(i);
            }
        });

        Button no = findViewById(R.id.btn_notification);
        no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent policy = new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.onesignal.com/apps/326714d2-f479-4434-a6a7-88008504e5e7/notifications/new"));
                        try {
                            startActivity(policy);
                        }
                        catch (android.content.ActivityNotFoundException ex)
                        { Toast.makeText(DashboardActivity.this, "There is no client installed....", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    public void ShowPopup(View v) {
        myDialog.setContentView(R.layout.custompopup);

        TextView  colse = myDialog.findViewById(R.id.txtclose);
        colse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        Button frist = myDialog.findViewById(R.id.btn_1_semester);
        frist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,Add_first_semester_result_Activity.class)
                        ;startActivity(intent);
            }
        });

        Button second = myDialog.findViewById(R.id.btn_2_semester);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,Add_second_semester_result_Activity.class)
                        ;startActivity(intent);
            }
        });


        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

}