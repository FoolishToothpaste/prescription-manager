package com.soham.prescription_manager.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    private String pname;
    private String pphone_number;
    private String pemail;

    public Patient(){}

    public Patient(String pname, String pphone_number, String pemail)
    {
        this.pname = pname;
        this.pphone_number = pphone_number;
        this.pemail = pemail;
    }

    public long getPatientId()
    {
        return pid;
    }

    public String getPatientName()
    {
        return pname;
    }

    public String getPatientPhoneNumber()
    {
        return pphone_number;
    }

    public String getPatientEmail()
    {
        return pemail;
    }

    public void setPatientId(long pid)
    {
        this.pid = pid;
    }

    public void setPatientName(String pname)
    {
        this.pname = pname;
    }

    public void setPatientPhoneNumber(String pphone_number)
    {
        this.pphone_number = pphone_number;
    }

    public void setPatientEmail(String pemail)
    {
        this.pemail = pemail;
    }
}
