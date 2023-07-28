package people;

public abstract class MedicalStaff extends Person {
    private Integer workExperience;

    public MedicalStaff(String name, Integer workExperience) {
        super(name);
        this.workExperience = workExperience;
    }

    public MedicalStaff(String name) {
        super(name);
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }
}
