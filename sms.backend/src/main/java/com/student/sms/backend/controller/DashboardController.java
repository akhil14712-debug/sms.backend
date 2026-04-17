package com.student.sms.backend.controller;


import com.student.sms.backend.dto.DashboardDto;
import com.student.sms.backend.service.DashboardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/dashboard")
@AllArgsConstructor

public class DashboardController {

    private DashboardService dashboardService;

    @GetMapping("/stats")
    public DashboardDto getDashboardCount(){

        return dashboardService.getDashboard();
    }
}
