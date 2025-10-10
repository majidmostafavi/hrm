package com.noor.resource;

import com.noor.dto.PersonCategoryDTO;
import com.noor.dto.ServiceCategoryDTO;
import com.noor.enumration.CategoryType;
import com.noor.service.MedicalPerMonthService;
import com.noor.service.PersonAttendanceService;
import com.noor.wrapper.RatioServiceResWrapper;
import com.noor.wrapper.RatioServiceSearchWrapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/ratio-report")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RatioServiceResource {
    @Inject
    PersonAttendanceService personAttendanceService;
    @Inject
    MedicalPerMonthService medicalPerMonthService;


    @POST
    public Response getReport(RatioServiceSearchWrapper ratioServiceSearchWrapper) {
        List<RatioServiceResWrapper> ratioServiceResWrappers = new ArrayList<>();
        Map<Long,ServiceCategoryDTO> mapService= new HashMap();
        List<ServiceCategoryDTO>  serviceCategoryDTOS =medicalPerMonthService.sumServiceCategoryByYearOrganizationMonth(ratioServiceSearchWrapper.yearID(), ratioServiceSearchWrapper.organizationID(), ratioServiceSearchWrapper.months());
        serviceCategoryDTOS.forEach(serviceCategoryDTO -> {
            mapService.put(serviceCategoryDTO.categoryID(),serviceCategoryDTO);
        });

        switch (ratioServiceSearchWrapper.ratioReportType()) {
            case category -> {
                Map<Long,PersonCategoryDTO> mapPersonAttendance = new HashMap();
                List<PersonCategoryDTO> personCategoryDTOS =personAttendanceService.sumPersonCategoryByYearID(ratioServiceSearchWrapper.yearID(),ratioServiceSearchWrapper.organizationID(),ratioServiceSearchWrapper.months());
                personCategoryDTOS.forEach(personCategoryDTO -> {
                    mapPersonAttendance.put(personCategoryDTO.categoryID(),personCategoryDTO);
                });
                for (Long key : mapService.keySet()) {
                    ratioServiceResWrappers.add(new RatioServiceResWrapper(
                            mapService.get(key).categoryName(),
                            mapService.get(key).categoryCode(),
                            mapService.get(key).categoryID(),
                            (double) (mapService.get(key).countService() / mapPersonAttendance.get(key).countAttendance()),
                            (double) (mapService.get(key).countService() / mapPersonAttendance.get(key).countAttendance())
                    ));
                }
            }

            case support -> {
                Map<CategoryType,Long> mapPersonAttendance = new HashMap();
                mapPersonAttendance.put(CategoryType.support,0l);
                mapPersonAttendance.put(CategoryType.therapeutic,0l);
                List<PersonCategoryDTO> personCategoryDTOS =personAttendanceService.sumPersonCategoryByYearID(ratioServiceSearchWrapper.yearID(),ratioServiceSearchWrapper.organizationID(),ratioServiceSearchWrapper.months());
                for (PersonCategoryDTO personCategoryDTO : personCategoryDTOS) {
                    mapPersonAttendance.put(personCategoryDTO.categoryType(),mapPersonAttendance.get(personCategoryDTO.categoryType())+personCategoryDTO.countAttendance());
                }
                mapService.keySet().forEach(key -> {
                    ratioServiceResWrappers.add( new RatioServiceResWrapper(
                            mapService.get(key).categoryName(),
                            mapService.get(key).categoryCode(),
                            mapService.get(key).categoryID(),
                            (double) (mapService.get(key).countService()/mapPersonAttendance.get(CategoryType.support)),
                            (double) (mapService.get(key).countService()/mapPersonAttendance.get(CategoryType.support))
                    ));
                });

            }
            case total -> {
                long totalAttendance = personAttendanceService.sumPersonCategoryByYearID(ratioServiceSearchWrapper.yearID(),ratioServiceSearchWrapper.organizationID(),ratioServiceSearchWrapper.months()).stream()
                        .mapToLong(PersonCategoryDTO::countAttendance)
                        .sum();
                mapService.keySet().forEach(key -> {
                    ratioServiceResWrappers.add( new RatioServiceResWrapper(
                            mapService.get(key).categoryName(),
                            mapService.get(key).categoryCode(),
                            mapService.get(key).categoryID(),
                            (double) (mapService.get(key).countService()/totalAttendance),
                            (double) (mapService.get(key).countService()/totalAttendance)
                    ));
                });
            }


        }
        return Response.ok(ratioServiceResWrappers).build();
    }
}
