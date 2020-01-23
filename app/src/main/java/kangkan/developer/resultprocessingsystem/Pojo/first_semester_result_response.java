package kangkan.developer.resultprocessingsystem.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class first_semester_result_response implements Serializable
{

    @SerializedName("student_reg")
    @Expose
    private String studentReg;
    @SerializedName("Introduction_to_computer_system")
    @Expose
    private String introductionToComputerSystem;
    @SerializedName("Programming_language")
    @Expose
    private String programmingLanguage;
    @SerializedName("Programming_language_practical")
    @Expose
    private String programmingLanguagePractical;
    @SerializedName("physics")
    @Expose
    private String physics;
    @SerializedName("differential_calculus_and_co_ordinate_geometry")
    @Expose
    private String differentialCalculusAndCoOrdinateGeometry;
    @SerializedName("english")
    @Expose
    private String english;


    private final static long serialVersionUID = 8618667702368513417L;

    public String getStudentReg() {
        return studentReg;
    }

    public void setStudentReg(String studentReg) {
        this.studentReg = studentReg;
    }

    public String getIntroductionToComputerSystem() {
        return introductionToComputerSystem;
    }

    public void setIntroductionToComputerSystem(String introductionToComputerSystem) {
        this.introductionToComputerSystem = introductionToComputerSystem;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguagePractical() {
        return programmingLanguagePractical;
    }

    public void setProgrammingLanguagePractical(String programmingLanguagePractical) {
        this.programmingLanguagePractical = programmingLanguagePractical;
    }

    public String getPhysics() {
        return physics;
    }

    public void setPhysics(String physics) {
        this.physics = physics;
    }

    public String getDifferentialCalculusAndCoOrdinateGeometry() {
        return differentialCalculusAndCoOrdinateGeometry;
    }

    public void setDifferentialCalculusAndCoOrdinateGeometry(String differentialCalculusAndCoOrdinateGeometry) {
        this.differentialCalculusAndCoOrdinateGeometry = differentialCalculusAndCoOrdinateGeometry;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

}