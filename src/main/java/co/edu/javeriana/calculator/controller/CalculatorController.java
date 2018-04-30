package co.edu.javeriana.calculator.controller;

import co.edu.javeriana.calculator.util.ServiceUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class CalculatorController {

    @RequestMapping("/add/**")
    public String add(HttpServletRequest req) {
        if (ServiceUtil.numeros(req.getServletPath(),"/add/")) {
            String[] stringArray = req.getServletPath().replace("/add/", "").split("/");
            Integer sum = 0;
            for (int i = 0; i < stringArray.length; i++) {
                String numberAsString = stringArray[i];
               sum += Integer.parseInt(numberAsString);
            }
            return sum.toString();
        }
        else {
            return "Ingrese solo numeros";
        }

    }

    @RequestMapping("/subs/**")
    public String subs(HttpServletRequest req) {
        if (ServiceUtil.numeros(req.getServletPath(),"/subs/")) {
            String[] stringArray = req.getServletPath().replace("/subs/", "").split("/");
            Integer sub = 0;
            for (int i = 0; i < stringArray.length; i++) {
                String numberAsString = stringArray[i];
                if(i>0){
                    sub -= Integer.parseInt(numberAsString);
                }else{
                    sub = Integer.parseInt(numberAsString);
                }
            }
            return sub.toString();
        }
        else {
            return "Ingrese solo numeros";
        }
    }

    @RequestMapping("/mult/**")
    public String mult(HttpServletRequest req) {
        if (ServiceUtil.numeros(req.getServletPath(),"/mult/")) {
            String[] stringArray = req.getServletPath().replace("/mult/", "").split("/");
            Integer mult = 0;
            for (int i = 0; i < stringArray.length; i++) {
                String numberAsString = stringArray[i];
                if(i>0){
                    mult *= Integer.parseInt(numberAsString);
                }else{
                    mult = Integer.parseInt(numberAsString);
                }
            }
            return mult.toString();
        }
        else {
            return "Ingrese solo numeros";
        }
    }

    @RequestMapping("/div/**")
    public String div(HttpServletRequest req) {
        if (ServiceUtil.numeros(req.getServletPath(),"/div/"))
            return req.getServletPath().replace("/div/", "");
        else
            return "Ingrese solo numeros";
    }


}
