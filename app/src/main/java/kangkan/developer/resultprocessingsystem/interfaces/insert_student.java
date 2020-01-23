package kangkan.developer.resultprocessingsystem.interfaces;

import kangkan.developer.resultprocessingsystem.Pojo.first_semester_result_response;
import kangkan.developer.resultprocessingsystem.Pojo.second_semester_result_response;
import kangkan.developer.resultprocessingsystem.Pojo.student_responce;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface insert_student {

    @FormUrlEncoded
    @POST("/Result_processing_system/insert_student_details.php")
    Call<student_responce> insert_stu_data(

            @Field("student_name") String student_name,
            @Field("student_roll") String student_roll,
            @Field("student_reg") String student_reg ,
            @Field("student_dept") String student_dept ,
            @Field("student_sec") String student_sec ,
            @Field("student_gender") String student_gender

    );

    @FormUrlEncoded
    @POST("/Result_processing_system/insert_first_result.php")
    Call<first_semester_result_response> insert_first_result(

            @Field("student_reg") String student_reg ,
            @Field("Introduction_to_computer_system") String Introduction_to_computer_system ,
            @Field("Programming_language") String Programming_language ,
            @Field("Programming_language_practical") String Programming_language_practical,
            @Field("physics") String physics ,
            @Field("differential_calculus_and_co_ordinate_geometry") String differential_calculus_and_co_ordinate_geometry ,
            @Field("english") String english

    );
    @FormUrlEncoded
    @POST("/Result_processing_system/insert_second_result.php")
    Call<second_semester_result_response> insert_second_result(

            @Field("student_reg") String student_reg ,
            @Field("data_structure") String data_structure ,
            @Field("data_structure_practical") String data_structure_practical ,
            @Field("introduction_to_electrical_enginnering") String introduction_to_electrical_enginnering,
            @Field("introduction_to_electrical_enginnering_practical") String introduction_to_electrical_enginnering_practical ,
            @Field("integral_calculas_and_diff_eqn") String integral_calculas_and_diff_eqn ,
            @Field("statistic_and_probability") String statistic_and_probability,
            @Field("discreate_mathematics") String discreate_mathematics

    );
}
