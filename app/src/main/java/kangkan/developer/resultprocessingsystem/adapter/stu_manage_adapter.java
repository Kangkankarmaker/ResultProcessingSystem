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

public class stu_manage_adapter extends ArrayAdapter<student_responce> {

    private Context context;
    private List<student_responce> responses;

    public stu_manage_adapter(@NonNull Context context, List<student_responce> responses) {
        super(context, R.layout.list_manage_student ,responses);
        this.context =context;
        this.responses = responses;
    }


    class ViewHolder{
        TextView semester;
    }
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        stu_manage_adapter.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new stu_manage_adapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            convertView = inflater.inflate(R.layout.list_manage_student, parent, false);

            viewHolder.semester = convertView.findViewById(R.id.txt_semester_list);


            convertView.setTag(viewHolder);

        }else {
            viewHolder = (stu_manage_adapter.ViewHolder) convertView.getTag();
        }

        viewHolder.semester.setText(responses.get(position).getIntroductionToComputerSystem()+responses.get(position).getDataStructure());


        return convertView;

    }
}


