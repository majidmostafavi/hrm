package com.noor.resource;
import com.noor.entity.MedicalPerMonthDetail;
import com.noor.entity.MedicalPerMonthMaster;
import com.noor.wrapper.ReportSearchDTO;
import com.noor.wrapper.MedicalPerMonthDTO;
import com.noor.wrapper.MedicalPerMonthReportResponseDTO;
import com.noor.dto.SumPersonnelAttendanceDTO;
import com.noor.entity.MedicalPerMonth;
import com.noor.service.MedicalPerMonthService;
import com.noor.service.PersonAttendanceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/medical-per-months-report")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalPerMonthReportResource {

    @Inject
    MedicalPerMonthService medicalPerMonthService;

    @Inject
    PersonAttendanceService personAttendanceService;

    @POST
    public Response reportMedicalPerMonth(ReportSearchDTO searchDTO) {

        List<MedicalPerMonthReportResponseDTO> medicalPerMonthReportResponseDTOList = new ArrayList<>();
        List<SumPersonnelAttendanceDTO> personAttendance = personAttendanceService.sumByOrganizationYear(searchDTO.organizationID(), searchDTO.yearID());
        for  (SumPersonnelAttendanceDTO personnelAttendance : personAttendance) {
            Long overTimeHours =(personnelAttendance.overtimeHoursWorked()/60 )+personnelAttendance.overtimeHoursWorked();
            Long overTimeMinutes = (long) Math.floorMod(personnelAttendance.overtimeMinutesWorked(),60);
            Long overTimeWithHours =(personnelAttendance.overtimeWithHoursWorked()/60 )+personnelAttendance.overtimeWithHoursWorked();
            Long overTimeWithMinutes =(long)Math.floorMod(personnelAttendance.overtimeWithMinutesWorked(),60);
            MedicalPerMonthMaster perMonthMaster = medicalPerMonthService.searchByOrganizationYear(searchDTO.organizationID(), searchDTO.yearID(),personnelAttendance.monthID());
            List<MedicalPerMonthDTO> medicalPerMonthDTOList = new ArrayList<>();
            if(perMonthMaster!=null) {
                for(MedicalPerMonthDetail detail : perMonthMaster.getMedicalPerMonthDetails()) {
                    MedicalPerMonthDTO medicalPerMonthDTO = new MedicalPerMonthDTO(detail.getServiceID(),detail.getService().getName(),detail.getTotalMedicalPerMonth());
                    medicalPerMonthDTOList.add(medicalPerMonthDTO);
                }
                medicalPerMonthReportResponseDTOList.add(new MedicalPerMonthReportResponseDTO(
                        personnelAttendance.monthID(),personnelAttendance.monthName(),
                        personnelAttendance.yearID(),personnelAttendance.yearName(),
                        personnelAttendance.organizationID(),personnelAttendance.organizationName(),
                        personnelAttendance.attendanceCount(),
                        overTimeHours,
                        overTimeMinutes,
                        overTimeWithHours,
                        overTimeWithMinutes,
                        medicalPerMonthDTOList)


                );
            }

        }



       return Response.status(Response.Status.OK).entity(medicalPerMonthReportResponseDTOList).build();
    }
}
