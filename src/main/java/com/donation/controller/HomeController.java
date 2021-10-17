package com.donation.controller;

import com.donation.entity.Visit;
import com.donation.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    public static final String HOME_TEMPLATE = "home";

    @Autowired
    private VisitService visitService;

    @GetMapping
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView(HOME_TEMPLATE);
        Visit visit = visitService.getTodayVisit();

        System.out.println(visit);
        if(visit == null){
            visit = new Visit();
            visit.setViews(1);
        }else{
            visit.setViews(visit.getViews()+1);
        }
        visitService.save(visit);
        Integer totalVisitors = visitService.getTotalVisits();

        mav.addObject("todayVisitors", visit.getViews());
        mav.addObject("totalVisitors", totalVisitors);

        return mav;
    }
}
