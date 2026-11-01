package com.soham.prescription_manager.dto.medicine;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MedicinePutRequest
{
    @NotBlank(message = "The medicine name cannot be empty!")
    @Size(max = 100, message = "Medicine name is too long!")
    private String name;

    @NotBlank(message = "The dosage cannot be empty!")
    @Size(max = 30, message = "Dosage is too large!")
    private String dosage;

    @NotBlank(message = "The medicine type cannot be empty!")
    @Size(max = 50, message = "Medicine type is too long!")
    private String form;

    public MedicinePutRequest()
    {}

    public MedicinePutRequest(String name, String dosage, String form)
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
