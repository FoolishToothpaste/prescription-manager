package com.soham.prescription_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Doctor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long did;

    @NotBlank(message = "Doctor's name cannot be blank!")
    @Size(max = 50, message = "Doctor's name too long!")
    private String name;

    @NotBlank(message = "Doctor's department name cannot be blank!")
    @Size(max = 20, message = "Doctor's department name too long!")
    private String department;

    @NotBlank(message = "Doctor's phone number cannot be blank!")
    @Size(max = 10, message = "Doctor's phone number too long!")
    private String dphone_number;

    @NotBlank(message = "Doctor's email cannot be blank!")
    @Size(max = 60, message = "Doctor's email too long!")
    @Email(message = "Please enter a valid email!")
    private String demail;

    public Doctor()
    {}

    public Doctor(String name, String department, String dphone_number, String demail)
    {
        this.name = name;
        this.department = department;
        this.dphone_number = dphone_number;
        this.demail = demail;
    }

    public long getDoctorId()
    {
        return did;
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
}
