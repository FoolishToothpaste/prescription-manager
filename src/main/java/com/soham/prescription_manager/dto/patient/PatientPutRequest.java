package com.soham.prescription_manager.dto.patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PatientPutRequest
{
    @NotBlank(message = "Patient name cannot be empty!")
    @Size(max = 50, message = "Patient name too long!")
    private String pname;

    @NotBlank(message = "Patient phone number cannot be empty!")
    @Pattern(
            regexp = "[6-9][0-9]{9}",
            message = "Please enter a valid 10-digit Indian mobile number!"
    )
    private String pphone_number;

    @NotBlank(message = "Patient email cannot be empty!")
    @Size(max = 60, message = "Patient email too long!")
    @Email(message = "Please enter a valid email")
    private String pemail;

    public PatientPutRequest()
    {}

    public PatientPutRequest(String pname, String pphone_number, String pemail)
    {
        this.pname = pname;
        this.pphone_number = pphone_number;
        this.pemail = pemail;
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

