package com.noor.resource;


import com.noor.entity.PersonnelAttendance;
import com.noor.service.PersonAttendanceService;
import com.noor.wrapper.PersonAttendanceReport;
import com.noor.wrapper.ReportSearchDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("personnel-attendance-report")
public class PersonAttendanceReportResource {

    @Inject
    PersonAttendanceService personAttendanceService;

    @POST
    public Response reportMedicalPerMonth(ReportSearchDTO searchDTO) {

        List<PersonnelAttendance> personnelAttendances = personAttendanceService.findOrganizationYearID(searchDTO.yearID(),searchDTO.monthID(),searchDTO.organizationID());
        List<PersonAttendanceReport> personAttendanceReports = new ArrayList<>();
        for(PersonnelAttendance personnelAttendance : personnelAttendances) {
            PersonAttendanceReport personAttendanceReport = new PersonAttendanceReport(personnelAttendance.getOccupation().name,personnelAttendance.getAttendanceCount(),personnelAttendance.getTotalWorked(),personnelAttendance.getOvertimeTotalWorked(),personnelAttendance.getOvertimeWithMultiplier());
            personAttendanceReports.add(personAttendanceReport);
        }

        return Response.ok(personAttendanceReports).build();
    }
}
