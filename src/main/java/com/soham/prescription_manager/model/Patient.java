package com.soham.prescription_manager.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    @NotBlank(message = "Patient name cannot be empty!")
    @Size(max = 50, message = "Patient name too long!")
    private String pname;

    @NotBlank(message = "Patient phone number cannot be empty!")
    @Size(max = 10, message = "Patient phone number too long!")
    private String pphone_number;

    @NotBlank(message = "Patient email cannot be empty!")
    @Size(max = 60, message = "Patient email too long!")
    @Email(message = "Please enter a valid email")
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
