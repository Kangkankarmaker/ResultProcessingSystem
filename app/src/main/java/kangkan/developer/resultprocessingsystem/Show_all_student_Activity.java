package kangkan.developer.resultprocessingsystem;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kangkan.developer.resultprocessingsystem.Pojo.student_responce;
import kangkan.developer.resultprocessingsystem.adapter.listAdapter;
import kangkan.developer.resultprocessingsystem.admin_session.SessionHandler;
import kangkan.developer.resultprocessingsystem.interfaces.show_student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Show_all_student_Activity extends AppCompatActivity {


    public static final String BASE_URL = "https://untearable-trays.000webhostapp.com";
    private show_student service;

    private ListView listView;
    private List<student_responce> student = new ArrayList<>();
    private listAdapter studentAdapter;

    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_student);

        setTitle("All Students");

        show_all_student("users","");
        displayLoader();


        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                student_responce Response = student.get(position);

                startActivity(new Intent(Show_all_student_Activity.this,Edit_student_details_Activity.class)
                        .putExtra("details", Response));

            }
        });
    }

    private void show_all_student(String users, String s) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(show_student.class);

        Call<List<student_responce>> call =service.getAllStudent(users,s);
        call.enqueue(new Callback<List<student_responce>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<List<student_responce>> call, Response<List<student_responce>> response) {
                if (response.code() == 200){
                    student =response.body();
                    studentAdapter = new listAdapter(Show_all_student_Activity.this, student);
                    listView.setAdapter(studentAdapter);
                    pDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<student_responce>> call, Throwable t) {
                Toast.makeText(Show_all_student_Activity.this, "Failed to connect Database..", Toast.LENGTH_SHORT).show();
                pDialog.dismiss();
            }
        });
    }
    private void displayLoader() {
        pDialog = new ProgressDialog(Show_all_student_Activity.this);
        pDialog.setMessage("Showing data, Please wait ...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menuSearch).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                show_all_student("users",newText);
                return false;
            }
        });

        return true;

    }


}
