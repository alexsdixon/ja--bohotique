package net.alexsdixon.jabohotique.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shopper")
public class ShopperController {

    @RequestMapping(value = "")
    public String index (Model model){

        model.addAttribute("title",  "JA BOHOTIQUE");

            return "shopper/index";

    }








}
