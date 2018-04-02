//package com.example.microservicesandtesting.features;
//
//import com.example.microservicesandtesting.models.User;
//import com.example.microservicesandtesting.repostitories.UserRepository;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static io.restassured.http.ContentType.JSON;
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.core.Is.is;
//
//
//import java.util.stream.Stream;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//public class UsersApiFeatureTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Before
//    public void setUp() {
//        userRepository.deleteAll();
//    }
//
//    @After
//    public void tearDown() {
//        userRepository.deleteAll();
//    }
//
//    @Test
//    public void shouldAllowFullCrudForAUser() throws Exception {
//        User firstUser = new User(
//                "someone",
//                "Ima",
//                "Person"
//        );
//
//        User secondUser = new User(
//                "someone_else",
//                "Someone",
//                "Else"
//        );
//
//        Stream.of(firstUser, secondUser)
//                .forEach(user -> {
//                    userRepository.save(user);
//                });
//
//        when()
//                .get("http://localhost:8080/users/")
//                .then()
//                .statusCode(is(200))
//                .and().body(containsString("someone"))
//                .and().body(containsString("Else"));
//
//        // Test creating a User
//        User userNotYetInDb = new User(
//                "new_user",
//                "Not",
//                "Yet Created"
//        );
//
//        given()
//                .contentType(JSON)
//                .and().body(userNotYetInDb)
//                .when()
//                .post("http://localhost:8080/users")
//                .then()
//                .statusCode(is(200))
//                .and().body(containsString("new_user"));
//
//        // Test get all Users
//        when()
//                .get("http://localhost:8080/users/")
//                .then()
//                .statusCode(is(200))
//                .and().body(containsString("someone"))
//                .and().body(containsString("Else"))
//                .and().body(containsString("Yet Created"));
//
//        // Test finding one user by ID
//        when()
//                .get("http://localhost:8080/users/" + secondUser.getId())
//                .then()
//                .statusCode(is(200))
//                .and().body(containsString("Someone"))
//                .and().body(containsString("Else"));
//
//        // Test updating a user
//        secondUser.setFirstName("changed_name");
//
//        given()
//                .contentType(JSON)
//                .and().body(secondUser)
//                .when()
//                .patch("http://localhost:8080/users/" + secondUser.getId())
//                .then()
//                .statusCode(is(200))
//                .and().body(containsString("changed_name"));
//
//        // Test deleting a user
//        when()
//                .delete("http://localhost:8080/users/" + secondUser.getId())
//                .then()
//                .statusCode(is(200));
//    }
//
//}
