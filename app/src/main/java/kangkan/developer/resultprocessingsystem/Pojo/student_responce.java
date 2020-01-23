package kangkan.developer.resultprocessingsystem.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class student_responce implements Serializable
{

    @SerializedName("student_id")
    @Expose
    private String studentId;
    @SerializedName("student_name")
    @Expose
    private String studentName;
    @SerializedName("student_roll")
    @Expose
    private String studentRoll;
    @SerializedName("student_reg")
    @Expose
    private String studentReg;
    @SerializedName("student_sec")
    @Expose
    private String studentSec;
    @SerializedName("student_dept")
    @Expose
    private String studentDept;
    @SerializedName("student_gender")
    @Expose
    private String studentGender;

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


    @SerializedName("cgpa")
    @Expose
    private String c_gpa;


    @SerializedName("data_structure")
    @Expose
    private String dataStructure;
    @SerializedName("data_structure_practical")
    @Expose
    private String dataStructurePractical;
    @SerializedName("introduction_to_electrical_enginnering")
    @Expose
    private String introductionToElectricalEnginnering;
    @SerializedName("introduction_to_electrical_enginnering_practical")
    @Expose
    private String introductionToElectricalEnginneringPractical;
    @SerializedName("integral_calculas_and_diff_eqn")
    @Expose
    private String integralCalculasAndDiffEqn;
    @SerializedName("statistic_and_probability")
    @Expose
    private String statisticAndProbability;
    @SerializedName("discreate_mathematics")
    @Expose
    private String discreateMathematics;

    private final static long serialVersionUID = -3536253186194170891L;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(String studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getStudentReg() {
        return studentReg;
    }

    public void setStudentReg(String studentReg) {
        this.studentReg = studentReg;
    }

    public String getStudentSec() {
        return studentSec;
    }

    public void setStudentSec(String studentSec) {
        this.studentSec = studentSec;
    }

    public String getStudentDept() {
        return studentDept;
    }

    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
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


    public String getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(String dataStructure) {
        this.dataStructure = dataStructure;
    }

    public String getDataStructurePractical() {
        return dataStructurePractical;
    }

    public void setDataStructurePractical(String dataStructurePractical) {
        this.dataStructurePractical = dataStructurePractical;
    }

    public String getIntroductionToElectricalEnginnering() {
        return introductionToElectricalEnginnering;
    }

    public void setIntroductionToElectricalEnginnering(String introductionToElectricalEnginnering) {
        this.introductionToElectricalEnginnering = introductionToElectricalEnginnering;
    }

    public String getIntroductionToElectricalEnginneringPractical() {
        return introductionToElectricalEnginneringPractical;
    }

    public void setIntroductionToElectricalEnginneringPractical(String introductionToElectricalEnginneringPractical) {
        this.introductionToElectricalEnginneringPractical = introductionToElectricalEnginneringPractical;
    }

    public String getIntegralCalculasAndDiffEqn() {
        return integralCalculasAndDiffEqn;
    }

    public void setIntegralCalculasAndDiffEqn(String integralCalculasAndDiffEqn) {
        this.integralCalculasAndDiffEqn = integralCalculasAndDiffEqn;
    }

    public String getStatisticAndProbability() {
        return statisticAndProbability;
    }

    public void setStatisticAndProbability(String statisticAndProbability) {
        this.statisticAndProbability = statisticAndProbability;
    }

    public String getDiscreateMathematics() {
        return discreateMathematics;
    }

    public void setDiscreateMathematics(String discreateMathematics) {
        this.discreateMathematics = discreateMathematics;
    }

    public String getC_gpa() {
        return c_gpa;
    }

    public void setC_gpa(String c_gpa) {
        this.c_gpa = c_gpa;
    }
}