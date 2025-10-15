package com.noor.resource;


import com.noor.dto.PersonnelAttendanceDetailDTO;
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

        Map<Long,List<PersonAttendanceReportDetail>> map = new HashMap<>();
        Map<Long,String> mapOccupation = new HashMap<>();

        for (ReportSearchDTO reportSearchDTO : searchDTO) {

            List<PersonnelAttendanceDetailDTO> personnelAttendanceDetailDTOS = personAttendanceService.sumDTOPersonAttendanceDetail(reportSearchDTO.yearID(), reportSearchDTO.organizationID(),reportSearchDTO.monthIDs());

            for (PersonnelAttendanceDetailDTO detailDTO : personnelAttendanceDetailDTOS) {

                mapOccupation.putIfAbsent(detailDTO.occupationId(), detailDTO.occupationName());

                if(!map.containsKey(detailDTO.occupationId())) {
                    PersonAttendanceReportDetail personAttendanceReport = new PersonAttendanceReportDetail(
                            detailDTO.occupationName(),
                            detailDTO.totalAttended(),
                            detailDTO.totalWorked(),
                            detailDTO.overtimeMinutesWorked() + " : " + detailDTO.overtimeHoursWorked(),
                            detailDTO.totalMinutesWorked()  + " : " + detailDTO.totalHoursWorked()
                            );
                    List<PersonAttendanceReportDetail> personAttendanceReports = new ArrayList<>();
                    personAttendanceReports.add(personAttendanceReport);
                    map.put(detailDTO.occupationId(),personAttendanceReports);
                }else {
                    PersonAttendanceReportDetail personAttendanceReport = new PersonAttendanceReportDetail(
                            detailDTO.occupationName(),
                            detailDTO.totalAttended(),
                            detailDTO.totalWorked(),
                            detailDTO.overtimeMinutesWorked() + " : " + detailDTO.overtimeHoursWorked(),
                            detailDTO.totalMinutesWorked() + " : " +  detailDTO.totalHoursWorked()
                            );
                    map.get(detailDTO.occupationId()).add(personAttendanceReport);
                }


            }
        }
        List<PersonAttendanceReport> personAttendanceReports =
                map.keySet()
                        .stream()
                        .map(occupation -> new PersonAttendanceReport(mapOccupation.get(occupation),occupation, map.get(occupation))).collect(Collectors.toList());
        return Response.ok(personAttendanceReports).build();
    }
}
