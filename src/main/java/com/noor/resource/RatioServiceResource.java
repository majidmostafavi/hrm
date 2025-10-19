package com.noor.resource;

import com.noor.dto.PersonCategoryDTO;
import com.noor.dto.ServiceCategoryDTO;
import com.noor.entity.Category;
import com.noor.enumration.CategoryType;
import com.noor.enumration.RatioReportType;
import com.noor.service.CategoryService;
import com.noor.service.MedicalPerMonthService;
import com.noor.service.PersonAttendanceService;
import com.noor.utils.Numbers;
import com.noor.wrapper.RatioServiceResDetailWrapper;
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
    CategoryService categoryService;
    @Inject
    PersonAttendanceService personAttendanceService;
    @Inject
    MedicalPerMonthService medicalPerMonthService;


    @POST
    public Response getReport(
            @QueryParam("ratioReportType") int reportType,
            List<RatioServiceSearchWrapper> ratioServiceSearchWrappers) {
        RatioReportType ratioReportType = RatioReportType.values()[reportType];
        switch (ratioReportType) {
            case category ->{
               return Response.ok(calculateCategory(ratioServiceSearchWrappers)).build();
            }
            case categoryType -> {
                return Response.ok(calculateCategoryType(ratioServiceSearchWrappers,CategoryType.support)).build();
            }
            case total -> {
                return Response.ok(calculateTotal(ratioServiceSearchWrappers)).build();
            }
        }
        return null;

    }


    public List<RatioServiceResWrapper>  calculateCategory(List<RatioServiceSearchWrapper> ratioServiceSearchWrappers) {
        List<Category> categoryList = categoryService.findAllCategory();
        List<RatioServiceResWrapper> ratioServiceResWrappers = new ArrayList<>();
        for (Category category : categoryList) {
            List<RatioServiceResDetailWrapper> detailWrappers = new ArrayList<>();
            for (RatioServiceSearchWrapper ratioServiceSearchWrapper : ratioServiceSearchWrappers) {
                ServiceCategoryDTO serviceCategoryDTOS = medicalPerMonthService.sumServiceCategoryByYearOrganizationMonth(ratioServiceSearchWrapper.yearID(), ratioServiceSearchWrapper.organizationID(), ratioServiceSearchWrapper.months(), category);
                PersonCategoryDTO personCategoryDTO = personAttendanceService.sumPersonCategoryByYearID(ratioServiceSearchWrapper.yearID(), ratioServiceSearchWrapper.organizationID(), ratioServiceSearchWrapper.months(), category);
                Double withOverTime = (double)((((personCategoryDTO.minuteAttendance()/60)+personCategoryDTO.hourAttendance())/8)/20)+personCategoryDTO.countAttendance();
                if(personCategoryDTO!=null && serviceCategoryDTOS!=null&&serviceCategoryDTOS.countService()!=null) {
                    detailWrappers.add(new RatioServiceResDetailWrapper(
                            ratioServiceSearchWrapper.organizationName(),
                            ratioServiceSearchWrapper.organizationID(),
                            Numbers.roundDouble((double) serviceCategoryDTOS.countService() / personCategoryDTO.countAttendance(),2),
                            Numbers.roundDouble((double) serviceCategoryDTOS.countService() /withOverTime,2)
                ));
                }else {
                    detailWrappers.add(new RatioServiceResDetailWrapper(
                            ratioServiceSearchWrapper.organizationName(),
                            ratioServiceSearchWrapper.organizationID(),
                           0d,0d
                    ));
                }

            }

            ratioServiceResWrappers.add(new RatioServiceResWrapper(category.name, category.code, category.id, detailWrappers));
        }
        return ratioServiceResWrappers;
    }

    public List<RatioServiceResWrapper>  calculateCategoryType(List<RatioServiceSearchWrapper> ratioServiceSearchWrappers, CategoryType categoryType) {
        List<Category> categoryList = categoryService.findAllCategory();
        List<RatioServiceResWrapper> ratioServiceResWrappers = new ArrayList<>();
        for (Category category : categoryList) {
            List<RatioServiceResDetailWrapper> detailWrappers = new ArrayList<>();
            for (RatioServiceSearchWrapper ratioServiceSearchWrapper : ratioServiceSearchWrappers) {
                ServiceCategoryDTO serviceCategoryDTOS = medicalPerMonthService.sumServiceCategoryByYearOrganizationMonth(ratioServiceSearchWrapper.yearID(), ratioServiceSearchWrapper.organizationID(), ratioServiceSearchWrapper.months(), category);
                PersonCategoryDTO personCategoryDTO = personAttendanceService.sumPersonCategoryByYearID(ratioServiceSearchWrapper.yearID(), ratioServiceSearchWrapper.organizationID(), ratioServiceSearchWrapper.months(),categoryType);
                if(personCategoryDTO!=null&& serviceCategoryDTOS!=null && serviceCategoryDTOS.countService()!=null) {
                    Double withOverTime = (double)((((personCategoryDTO.minuteAttendance()/60)+personCategoryDTO.hourAttendance())/8)/20)+personCategoryDTO.countAttendance();
                    detailWrappers.add(new RatioServiceResDetailWrapper(
                            ratioServiceSearchWrapper.organizationName(),
                            ratioServiceSearchWrapper.organizationID(),
                            Numbers.roundDouble((double) serviceCategoryDTOS.countService() / personCategoryDTO.countAttendance(),2),
                            Numbers.roundDouble((double) serviceCategoryDTOS.countService() / withOverTime ,2)
                    ));
                }else {
                    detailWrappers.add(new RatioServiceResDetailWrapper(
                            ratioServiceSearchWrapper.organizationName(),
                            ratioServiceSearchWrapper.organizationID(),
                            0d,0d
                    ));
                }

            }

            ratioServiceResWrappers.add(new RatioServiceResWrapper(category.name, category.code, category.id, detailWrappers));
        }
        return ratioServiceResWrappers;
    }

    public List<RatioServiceResWrapper>  calculateTotal(List<RatioServiceSearchWrapper> ratioServiceSearchWrappers) {
        List<Category> categoryList = categoryService.findAllCategory();
        List<RatioServiceResWrapper> ratioServiceResWrappers = new ArrayList<>();
        for (Category category : categoryList) {
            List<RatioServiceResDetailWrapper> detailWrappers = new ArrayList<>();
            for (RatioServiceSearchWrapper ratioServiceSearchWrapper : ratioServiceSearchWrappers) {
                ServiceCategoryDTO serviceCategoryDTOS = medicalPerMonthService.sumServiceCategoryByYearOrganizationMonth(ratioServiceSearchWrapper.yearID(), ratioServiceSearchWrapper.organizationID(), ratioServiceSearchWrapper.months(), category);
               if( serviceCategoryDTOS!=null && serviceCategoryDTOS.countService()!=null) {
                   long attendance = 0;
                   double withOverTime = 0d;

                   List<PersonCategoryDTO> personCategoryDTOs =personAttendanceService.sumPersonCategoryByYearID(ratioServiceSearchWrapper.yearID(), ratioServiceSearchWrapper.organizationID(), ratioServiceSearchWrapper.months());
                   for(PersonCategoryDTO personCategoryDTO :personCategoryDTOs){
                       attendance=attendance+personCategoryDTO.countAttendance();
                       withOverTime  =withOverTime+(double)((((personCategoryDTO.minuteAttendance()/60)+personCategoryDTO.hourAttendance())/8)/20)+personCategoryDTO.countAttendance();
                   }

                   detailWrappers.add(new RatioServiceResDetailWrapper(
                           ratioServiceSearchWrapper.organizationName(),
                           ratioServiceSearchWrapper.organizationID(),
                           Numbers.roundDouble((double) serviceCategoryDTOS.countService() / attendance,2),
                           Numbers.roundDouble((double) serviceCategoryDTOS.countService() / withOverTime,2)
                   ));
               }else {
                   detailWrappers.add(new RatioServiceResDetailWrapper(
                           ratioServiceSearchWrapper.organizationName(),
                           ratioServiceSearchWrapper.organizationID(),
                           0d,0d
                   ));
               }

            }

            ratioServiceResWrappers.add(new RatioServiceResWrapper(category.name, category.code, category.id, detailWrappers));
        }
        return ratioServiceResWrappers;
    }

}
