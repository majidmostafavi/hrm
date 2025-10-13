package com.noor.resource;

import com.noor.dto.PersonCategoryDTO;
import com.noor.dto.ServiceCategoryDTO;
import com.noor.entity.Category;
import com.noor.enumration.CategoryType;
import com.noor.enumration.RatioReportType;
import com.noor.service.CategoryService;
import com.noor.service.MedicalPerMonthService;
import com.noor.service.PersonAttendanceService;
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
    public Response getReport(List<RatioServiceSearchWrapper> ratioServiceSearchWrappers) {
        RatioReportType ratioReportType = ratioServiceSearchWrappers.getFirst().ratioReportType();

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
                if(personCategoryDTO!=null && serviceCategoryDTOS!=null) {
                    detailWrappers.add(new RatioServiceResDetailWrapper(
                            ratioServiceSearchWrapper.organizationName(),
                            ratioServiceSearchWrapper.organizationID(),
                            (double) serviceCategoryDTOS.countService() / personCategoryDTO.countAttendance(),
                            (double) serviceCategoryDTOS.countService() / personCategoryDTO.countAttendance()));
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
                PersonCategoryDTO personCategoryDTO = personAttendanceService.sumPersonCategoryByYearID(ratioServiceSearchWrapper.yearID(), ratioServiceSearchWrapper.organizationID(), ratioServiceSearchWrapper.months(), category,categoryType);
                if(personCategoryDTO!=null&& serviceCategoryDTOS!=null) {
                    detailWrappers.add(new RatioServiceResDetailWrapper(
                            ratioServiceSearchWrapper.organizationName(),
                            ratioServiceSearchWrapper.organizationID(),
                            (double) serviceCategoryDTOS.countService() / personCategoryDTO.countAttendance(),
                            (double) serviceCategoryDTOS.countService() / personCategoryDTO.countAttendance()));
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
               if( serviceCategoryDTOS!=null) {
                   long attendance = personAttendanceService.sumPersonCategoryByYearID(ratioServiceSearchWrapper.yearID(), ratioServiceSearchWrapper.organizationID(), ratioServiceSearchWrapper.months())
                           .stream()
                           .mapToLong(PersonCategoryDTO::countAttendance)
                           .sum();

                   detailWrappers.add(new RatioServiceResDetailWrapper(
                           ratioServiceSearchWrapper.organizationName(),
                           ratioServiceSearchWrapper.organizationID(),
                           (double) serviceCategoryDTOS.countService() / attendance,
                           (double) serviceCategoryDTOS.countService() / attendance));
               }

            }

            ratioServiceResWrappers.add(new RatioServiceResWrapper(category.name, category.code, category.id, detailWrappers));
        }
        return ratioServiceResWrappers;
    }

}
