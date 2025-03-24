package com.keyin.member;


import com.keyin.member.MemberDTO;
import com.keyin.member.Member;
import com.keyin.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/add")
    public Member addMember(@RequestBody MemberDTO memberDTO) {
        return memberService.addMember(memberDTO);
    }

    @GetMapping("/all")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/search")
    public List<Member> searchByName(@RequestParam String name) {
        return memberService.searchByName(name);
    }
}

