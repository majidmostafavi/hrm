package com.noor;

import com.noor.entity.Department;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
public class DepartmentResourceTest {

//    @Test
//    public void testGetAllEndpoint() {
//        // First create a test department
//        Department department = new Department();
//        department.setName("Test Department");
//        department.setCode(123L);
//
//        // Create the department
//        given()
//            .contentType(ContentType.JSON)
//            .body(department)
//            .when()
//            .post("/departments")
//            .then()
//            .statusCode(200);
//
//        // Test GET all endpoint
//        given()
//            .when()
//            .get("/departments")
//            .then()
//            .statusCode(200)
//            .contentType(ContentType.JSON)
//            .body("$", hasSize(greaterThanOrEqualTo(1)))
//            .body("[0].name", notNullValue())
//            .body("[0].code", notNullValue());
//    }
//
//    @Test
//    public void testGetByIdEndpoint() {
//        // First create a test department
//        Department department = new Department();
//        department.setName("Test Department");
//        department.setCode(124L);
//
//        // Create and get the ID
//        Long id = given()
//            .contentType(ContentType.JSON)
//            .body(department)
//            .when()
//            .post("/departments")
//            .then()
//            .statusCode(200)
//            .extract()
//            .jsonPath()
//            .getLong("id");
//
//        // Test GET by ID endpoint
//        given()
//            .when()
//            .get("/departments/" + id)
//            .then()
//            .statusCode(200)
//            .contentType(ContentType.JSON)
//            .body("name", equalTo("Test Department"))
//            .body("code", equalTo(124));
//    }
//
//    @Test
//    public void testGetByIdNotFound() {
//        given()
//            .when()
//            .get("/departments/999999")
//            .then()
//            .statusCode(404);
//    }
//
//    @Test
//    public void testCreateDepartment() {
//        Department department = new Department();
//        department.setName("New Department");
//        department.setCode(125L);
//
//        given()
//            .contentType(ContentType.JSON)
//            .body(department)
//            .when()
//            .post("/departments")
//            .then()
//            .statusCode(200)
//            .contentType(ContentType.JSON)
//            .body("name", equalTo("New Department"))
//            .body("code", equalTo(125))
//            .body("id", notNullValue());
//    }
//
//    @Test
//    public void testDeleteDepartment() {
//        // First create a department to delete
//        Department department = new Department();
//        department.setName("Department to Delete");
//        department.setCode(126L);
//
//        Long id = given()
//            .contentType(ContentType.JSON)
//            .body(department)
//            .when()
//            .post("/departments")
//            .then()
//            .statusCode(200)
//            .extract()
//            .jsonPath()
//            .getLong("id");
//
//        // Test DELETE endpoint
//        given()
//            .when()
//            .delete("/departments/" + id)
//            .then()
//            .statusCode(204);
//
//        // Verify it's deleted
//        given()
//            .when()
//            .get("/departments/" + id)
//            .then()
//            .statusCode(404);
//    }
//
//    @Test
//    public void testDeleteNonExistentDepartment() {
//        given()
//            .when()
//            .delete("/departments/999999")
//            .then()
//            .statusCode(404);
//    }
}
