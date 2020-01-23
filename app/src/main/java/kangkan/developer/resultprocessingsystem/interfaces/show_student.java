package kangkan.developer.resultprocessingsystem.interfaces;

import java.util.List;

import kangkan.developer.resultprocessingsystem.Pojo.student_responce;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface show_student {

    @GET("/Result_processing_system/select_all_student.php")
    Call<List<student_responce>> getAllStudent(

            @Query("item_type") String item_type,
            @Query("key") String key
    );

    @GET("/Result_processing_system/get_student_result.php")
    Call<List<student_responce>> getStudentResult(

            @Query("stu_reg") String stu_reg,
            @Query("stu_semester") String stu_semester
    );

    @GET("/Result_processing_system/select_stu_semester.php")
    Call<List<student_responce>> getStudentSemesterResult(

            @Query("stu_reg") String stu_reg

    );
}
