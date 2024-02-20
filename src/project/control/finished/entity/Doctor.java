package project.control.finished.entity;

import java.util.Objects;

public class Doctor {

    private String fio;
    private String jobTitle;
    private int idHospital;

    public Doctor(){}

    public Doctor(String fio,String jobTitle,int idHospital){
        this.fio=fio;
        this.jobTitle=jobTitle;
        this.idHospital=idHospital;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "fio='" + fio + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", idHospital=" + idHospital +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return idHospital == doctor.idHospital && Objects.equals(fio, doctor.fio) && Objects.equals(jobTitle, doctor.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, jobTitle, idHospital);
    }

}
