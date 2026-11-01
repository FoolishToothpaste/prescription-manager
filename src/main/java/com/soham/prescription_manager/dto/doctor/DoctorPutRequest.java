package com.soham.prescription_manager.dto.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DoctorPutRequest
{
    @NotBlank(message = "Doctor's name cannot be blank!")
    @Size(max = 50, message = "Doctor's name too long!")
    private String dname;

    @NotBlank(message = "Doctor's department name cannot be blank!")
    @Size(max = 20, message = "Doctor's department name too long!")
    private String department;

    @Pattern(
            regexp = "[6-9][0-9]{9}",
            message = "Please enter a valid 10-digit Indian mobile number!"
    )
    @NotBlank(message = "Doctor's phone number cannot be blank!")
    @Size(max = 10, message = "Doctor's phone number too long!")
    private String dphone_number;

    @NotBlank(message = "Doctor's email cannot be blank!")
    @Size(max = 60, message = "Doctor's email too long!")
    @Email(message = "Please enter a valid email!")
    private String demail;

    public DoctorPutRequest()
    {}

    public DoctorPutRequest(String dname, String department, String dphone_number, String demail)
    {
        this.dname = dname;
        this.department = department;
        this.dphone_number = dphone_number;
        this.demail = demail;
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
