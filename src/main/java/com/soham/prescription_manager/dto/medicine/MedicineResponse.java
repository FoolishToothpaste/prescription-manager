package com.soham.prescription_manager.dto.medicine;

public class MedicineResponse
{
    private long id;
    private String name;
    private String dosage;
    private String form;

    public MedicineResponse(long id, String name, String dosage, String form)
    {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.form = form;
    }

    public long getId()
    {
        return id;
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

}
