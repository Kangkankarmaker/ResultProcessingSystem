package kangkan.developer.resultprocessingsystem.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kangkan.developer.resultprocessingsystem.Pojo.student_responce;
import kangkan.developer.resultprocessingsystem.R;

public class resultAdapter extends ArrayAdapter<student_responce> {

    private Context context;
    private List<student_responce> responses;

    public resultAdapter(@NonNull Context context, List<student_responce> responses) {
        super(context, R.layout.list_result ,responses);
        this.context =context;
        this.responses = responses;
    }


    class ViewHolder{
        TextView name,reg,roll,dept,sec,cgpa;
    }
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        resultAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new resultAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            convertView = inflater.inflate(R.layout.list_result, parent, false);

            viewHolder.reg = convertView.findViewById(R.id.txt_student_reg);
            viewHolder.name = convertView.findViewById(R.id.txt_student_name);
            viewHolder.roll = convertView.findViewById(R.id.txt_student_roll);
            viewHolder.dept = convertView.findViewById(R.id.txt_student_dept);
            viewHolder.sec = convertView.findViewById(R.id.txt_student_sec);
            viewHolder.cgpa = convertView.findViewById(R.id.txt_cgpa);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (resultAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText("Name  :  "+responses.get(position).getStudentName());
        viewHolder.roll.setText("Roll      :  "+responses.get(position).getStudentRoll());
        viewHolder.reg.setText("Reg.     :  "+responses.get(position).getStudentReg());
        viewHolder.dept.setText("Dept.   :  "+responses.get(position).getStudentDept());
        viewHolder.sec.setText("Sec.     :  "+responses.get(position).getStudentSec());

        viewHolder.cgpa.setText("CGPA"+"\n"+responses.get(position).getC_gpa());

        return convertView;

    }
}

