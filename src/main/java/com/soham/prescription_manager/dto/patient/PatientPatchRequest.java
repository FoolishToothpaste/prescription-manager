package com.soham.prescription_manager.dto.patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PatientPatchRequest
{
    @Pattern(regexp = ".*\\S.*", message = "Patient name cannot be whitespaces, either have null or a valid name!")
    @Size(max = 50, message = "Patient name too long!")
    private String pname;

    @Pattern(
            regexp = "[6-9][0-9]{9}",
            message = "Please enter a valid 10-digit Indian mobile number!"
    )
    private String pphone_number;

    @Pattern(regexp = ".*\\S.*", message = "Patient email cannot be whitespaces, either have null or a valid email!")
    @Size(max = 60, message = "Patient email too long!")
    @Email(message = "Please enter a valid email")
    private String pemail;

    public PatientPatchRequest()
    {}

    public PatientPatchRequest(String pname, String pphone_number, String pemail)
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
