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

public class listAdapter extends ArrayAdapter<student_responce> {

    private Context context;
    private List<student_responce> responses;

    public listAdapter(@NonNull Context context,List<student_responce> responses) {
        super(context, R.layout.list_row ,responses);
        this.context =context;
        this.responses = responses;
    }


    class ViewHolder{
        TextView name,roll,dept,sec,reg;
    }
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            convertView = inflater.inflate(R.layout.list_row, parent, false);

            viewHolder.name = convertView.findViewById(R.id.txt_list_stu_name);
            viewHolder.roll = convertView.findViewById(R.id.txt_list_stu_roll);
            viewHolder.reg = convertView.findViewById(R.id.txt_list_stu_reg);
            viewHolder.dept = convertView.findViewById(R.id.txt_list_stu_dept);
            viewHolder.sec = convertView.findViewById(R.id.txt_list_stu_sec);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText("Name               :    "+responses.get(position).getStudentName());
        viewHolder.roll.setText("Roll                    :    "+responses.get(position).getStudentRoll());
        viewHolder.reg.setText("Registration    :    "+responses.get(position).getStudentReg());
        viewHolder.dept.setText("Dept.                :    "+responses.get(position).getStudentDept());
        viewHolder.sec.setText("Session           :    "+responses.get(position).getStudentSec());

        return convertView;

    }
}

