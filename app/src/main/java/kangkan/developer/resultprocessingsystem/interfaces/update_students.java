package kangkan.developer.resultprocessingsystem.interfaces;

import kangkan.developer.resultprocessingsystem.Pojo.student_responce;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface update_students {

    @FormUrlEncoded
    @POST("/Result_processing_system/update_student_details.php")
    Call<student_responce> updateStudent(

            @Field("student_id") String student_id,
            @Field("student_name") String student_name,
            @Field("student_reg") String student_reg,
            @Field("student_roll") String student_roll,
            @Field("student_dept") String student_dept,
            @Field("student_sec") String student_sec,
            @Field("student_gender") String student_gender,
            @Field("prv_reg") String prv_reg

    );

    @FormUrlEncoded
    @POST("/Result_processing_system/update_first_result.php")
    Call<student_responce> updateStudentResult(

            @Field("student_reg") String student_reg ,
            @Field("Introduction_to_computer_system") String Introduction_to_computer_system ,
            @Field("Programming_language") String Programming_language ,
            @Field("Programming_language_practical") String Programming_language_practical,
            @Field("physics") String physics ,
            @Field("differential_calculus_and_co_ordinate_geometry") String differential_calculus_and_co_ordinate_geometry ,
            @Field("english") String english


    );
}


