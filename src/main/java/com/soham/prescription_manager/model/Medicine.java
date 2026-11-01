package com.soham.prescription_manager.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicine
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String dosage;
    private String form;

    public Medicine()
    {}

    public Medicine(String name, String dosage, String form)
    {
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
