package com.soham.prescription_manager.dto.patient;

public class PatientResponse
{
    private long pid;
    private String pname;
    private String pemail;

    public PatientResponse(long pid, String pname, String pemail)
    {
        this.pid = pid;
        this.pname = pname;
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

    public String getPatientEmail()
    {
        return pemail;
    }
}
