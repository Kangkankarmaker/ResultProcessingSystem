package kangkan.developer.resultprocessingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button result,admin;

    MyApplication myApplication;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        myApplication = MyApplication.getmInstance();

        result=findViewById(R.id.btn_stu_result);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WelcomeActivity.this,show_result_Activity.class);
                startActivity(intent);
            }
        });



    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.menuAdmin:
            {
                Intent intent=new Intent(WelcomeActivity.this,Admin_LogIn_Activity.class);
                startActivity(intent);
            }
            break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

}

