package com.noor.resource;


import com.noor.entity.Occupation;
import com.noor.entity.PersonnelAttendanceDetail;
import com.noor.entity.PersonnelAttendanceMaster;
import com.noor.service.PersonAttendanceService;
import com.noor.wrapper.PersonAttendanceReport;
import com.noor.wrapper.PersonAttendanceReportDetail;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("personnel-attendance-report")
public class PersonAttendanceReportResource {

    @Inject
    PersonAttendanceService personAttendanceService;

    @POST
    public Response reportMedicalPerMonth(List<ReportSearchDTO> searchDTO) {

        Map<Occupation,List<PersonAttendanceReportDetail>> map = new HashMap<>();
        for (ReportSearchDTO reportSearchDTO : searchDTO) {
            PersonnelAttendanceMaster personnelAttendance = personAttendanceService.findOrganizationYearID(reportSearchDTO.yearID(), reportSearchDTO.monthID(), reportSearchDTO.organizationID());

            for (PersonnelAttendanceDetail detail : personnelAttendance.getPersonnelAttendanceDetails()) {
                if(!map.containsKey(detail.getOccupation())) {
                    PersonAttendanceReportDetail personAttendanceReport = new PersonAttendanceReportDetail(
                            detail.getOccupation().name,
                            detail.getAttendanceCount(),
                            detail.getTotalWorked(),
                            detail.getOvertimeMinutesWorked() + " : " + detail.getOvertimeHoursWorked(),
                            detail.getTotalHoursWorked() + " : " + detail.getTotalMinutesWorked()
                            );
                    List<PersonAttendanceReportDetail> personAttendanceReports = new ArrayList<>();
                    personAttendanceReports.add(personAttendanceReport);
                    map.put(detail.getOccupation(),personAttendanceReports);
                }else {
                    PersonAttendanceReportDetail personAttendanceReport = new PersonAttendanceReportDetail(
                            detail.getOccupation().name,
                            detail.getAttendanceCount(),
                            detail.getTotalWorked(),
                            detail.getOvertimeMinutesWorked() + " : " + detail.getOvertimeHoursWorked(),
                            detail.getTotalHoursWorked() + " : " + detail.getTotalMinutesWorked()
                            );
                    map.get(detail.getOccupation()).add(personAttendanceReport);
                }


            }
        }
        List<PersonAttendanceReport> personAttendanceReports = map.keySet().stream().map(occupation -> new PersonAttendanceReport(occupation,occupation.id, map.get(occupation))).collect(Collectors.toList());
        return Response.ok(personAttendanceReports).build();
    }
}
