package study.studyspring.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {

    @GetMapping("hello")
    public void hello(@RequestParam("name") String name){


        ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    }


}
