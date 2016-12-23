package com.michael.controller;

import com.michael.entity.Guest;
import com.michael.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController
{
    @Autowired
    private GuestRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllRecords(Model model)
    {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("guests", repository.findAll());

        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addRecord(@RequestParam(value = "name") String name,@RequestParam(value = "message") String message)
    {
        repository.saveAndFlush(new Guest(name, message));

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("guests", repository.findAll());

        return mv;
    }
}
