package com.soham.prescription_manager.dto.doctor;

public class DoctorResponse
{
    private long did;
    private String dname;
    private String department;

    public DoctorResponse(long did, String dname, String department)
    {
        this.did = did;
        this.dname = dname;
        this.department = department;
    }

    public long getDoctorId()
    {
        return did;
    }

    public String getDoctorName()
    {
        return dname;
    }

    public String getDoctorDepartment()
    {
        return department;
    }
}
