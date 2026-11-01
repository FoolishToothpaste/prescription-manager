package com.soham.prescription_manager.dto.medicine;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MedicinePatchRequest
{
    @Pattern(regexp = ".*\\S.*", message = "Medicine name cannot be whitespaces, either have null or a valid name!")
    @Size(max = 100, message = "Medicine name is too long!")
    private String name;

    @Pattern(regexp = ".*\\S.*", message = "Medicine dosage cannot be whitespaces, either have null or a valid name!")
    @Size(max = 30, message = "Dosage is too large!")
    private String dosage;

    @Pattern(regexp = ".*\\S.*", message = "Medicine type cannot be whitespaces, either have null or a valid name!")
    @Size(max = 50, message = "Medicine type is too long!")
    private String form;

    public MedicinePatchRequest()
    {}

    public MedicinePatchRequest(String name, String dosage, String form)
    {
        this.name = name;
        this.dosage = dosage;
        this.form = form;
    }

    public String getName()
    {
        return name;
    }

    public String getDosage()
    {
        return dosage;
    }

    public String getForm()
    {
        return form;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDosage(String dosage)
    {
        this.dosage = dosage;
    }

    public void setForm(String form)
    {
        this.form = form;
    }
}