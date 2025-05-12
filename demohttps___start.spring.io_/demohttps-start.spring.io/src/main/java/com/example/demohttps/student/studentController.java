//   package com.example.demohttps.student;

// import java.time.LocalDate;
// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;



// import com.example.demohttps.student.student;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


// @RestController
// @RequestMapping(path = "api/v1/student")
// public class studentController {


//     @GetMapping
// 	public List<student> hello(){
// 		//this method returns a json array 
// 		return List.of(
// 			new student(
// 				1L, 
// 			 "Mariam",
// 			 "mariam.gmail.com" , 
// 			 LocalDate.of(2000,01,05),
// 			 21)
// 		); 

// }
// }