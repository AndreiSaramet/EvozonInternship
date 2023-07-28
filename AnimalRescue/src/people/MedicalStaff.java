package people;

import utils.Gender;

public abstract class MedicalStaff extends AbstractPerson {
    private Integer workExperience;

    public MedicalStaff(String name) {
        super(name, Gender.MALE);
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }
}
