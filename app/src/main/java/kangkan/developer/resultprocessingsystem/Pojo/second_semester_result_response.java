package kangkan.developer.resultprocessingsystem.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class second_semester_result_response implements Serializable
{

    @SerializedName("student_reg")
    @Expose
    private String studentReg;
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
    private final static long serialVersionUID = 3873807333516742450L;

    public String getStudentReg() {
        return studentReg;
    }

    public void setStudentReg(String studentReg) {
        this.studentReg = studentReg;
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

}