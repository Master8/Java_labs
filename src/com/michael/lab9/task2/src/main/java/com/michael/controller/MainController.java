package com.michael.controller;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Controller
@RequestMapping("/")
public class MainController
{
    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model)
    {
        return "index";
    }

    @RequestMapping(value = "encode", method = RequestMethod.POST)
    public ModelAndView encode(@RequestParam(value = "src") String src)
    {
        String result = "Incorrect line!";

        try{
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            XZCompressorOutputStream xzOut = new XZCompressorOutputStream(bout);
            xzOut.write(src.getBytes());
            xzOut.close();

            result = Base64.encodeBase64String(bout.toByteArray());
        }
        catch(Exception e)
        {

        }

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("result", result);

        return mv;
    }

    @RequestMapping(value = "decode", method = RequestMethod.POST)
    public ModelAndView decode(@RequestParam(value = "src") String src)
    {
        String result = "Incorrect line!";

        try
        {
            byte[] buffer = Base64.decodeBase64(src);
            byte[] rezultBuffer = new byte[100];

            ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);
            XZCompressorInputStream compressorInputStream = new XZCompressorInputStream(inputStream);

            compressorInputStream.read(rezultBuffer);
            compressorInputStream.close();

            result = new String(rezultBuffer);
        }
        catch (Exception e)
        {
        }

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("result", result);

        return mv;
    }
}
