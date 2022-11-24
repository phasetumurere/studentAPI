package com.example.myOwnDemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
           Student mariam=new Student(
                   "Mariam",
                   "mariam@gmail.com",
                   LocalDate.of(1999, Month.JANUARY,12)

           ) ;
            Student phase=new Student(
                    "phase",
                    "phase@gmail.com",
                    LocalDate.of(1998, Month.JULY,07)
            ) ;

            repository.saveAll(
                    List.of(mariam,phase)
            );
        };
    }

}
