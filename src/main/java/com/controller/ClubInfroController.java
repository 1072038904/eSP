package com.controller;

import com.pojo.Club;
import com.service.ClubInfroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("clubInfro")
public class ClubInfroController {
    @Autowired
    private ClubInfroService clubInfroService;

    @RequestMapping("getClubInfro.do")
    @ResponseBody
    public Club getClubInfroById(Integer clubId) {
        return clubInfroService.getClubInfroById(clubId);
        //return null;
    }
}
