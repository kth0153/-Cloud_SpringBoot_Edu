package com.rubypaper.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/system/accessDenied")
    public void accessDenied(){

    }

   @GetMapping("/system/login")
   public void login(){}

    @GetMapping("/system/logout")
    public void logout(){
    }

    @GetMapping("/admin/adminPage")
    public void admin(){
    }

/*    @GetMapping("/")
    public String index(){
        System.out.println("index 요청입니다.");
        return "index";
    }*/

   /* @GetMapping("/member")
    public void forMember(){
        System.out.println("Mmember 요청입니다.");
    }

    @GetMapping("/manager")
    public void forManager(){
        System.out.println("Manager 요청입니다.");
    }

    @GetMapping("/admin")
    public void forAdmin(){
        System.out.println("Admin 요청입니다.");
    }*/
}
