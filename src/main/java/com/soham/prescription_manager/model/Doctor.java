package com.soham.prescription_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long did;

    private String dname;
    private String department;
    private String dphone_number;
    private String demail;

    public Doctor()
    {}

    public Doctor(String dname, String department, String dphone_number, String demail)
    {
        this.dname = dname;
        this.department = department;
        this.dphone_number = dphone_number;
        this.demail = demail;
    }

    public long getDoctorId()
    {
        return did;
    }

    public String getDoctorName()
    {
        return dname;
    }

    public String getDoctorDepartment()
    {
        return department;
    }

    public String getDoctorPhoneNumber()
    {
        return dphone_number;
    }

    public String getDoctorEmail()
    {
        return demail;
    }

    public void setDoctorName(String dname)
    {
        this.dname = dname;
    }

    public void setDoctorDepartment(String department)
    {
        this.department = department;
    }

    public void setDoctorPhoneNumber(String dphone_number)
    {
        this.dphone_number = dphone_number;
    }

    public void setDoctorEmail(String demail)
    {
        this.demail = demail;
    }
}
