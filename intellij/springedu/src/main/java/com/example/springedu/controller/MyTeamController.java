package com.example.springedu.controller;

import com.example.springedu.domain.TeamDTO;
import com.example.springedu.domain.TeamMemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class MyTeamController {
    @RequestMapping(value = "/introduce", produces = "application/json; charset=utf-8")
    @ResponseBody
    public TeamDTO getByIdInJSON(){
        TeamMemberVO kcj = new TeamMemberVO("김철진","찰스","라면");
        TeamMemberVO kiy = new TeamMemberVO("구인영","잠만보","떡볶이");
        TeamMemberVO lsy = new TeamMemberVO("이소영","새또","마라탕");
        TeamMemberVO hsh = new TeamMemberVO("한승현","루피","고기");

        ArrayList<TeamMemberVO> memberList = new ArrayList<TeamMemberVO>();
        memberList.add(kcj);
        memberList.add(kiy);
        memberList.add(lsy);
        memberList.add(hsh);

        TeamDTO dto = new TeamDTO();
        dto.setTeamName("글써조");
        dto.setTeamMember(memberList);

        return dto;
    }
}
