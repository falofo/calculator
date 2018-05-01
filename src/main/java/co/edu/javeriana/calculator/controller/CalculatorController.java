package co.edu.javeriana.calculator.controller;

import co.edu.javeriana.calculator.util.ServiceUtil;
import com.sun.org.apache.regexp.internal.recompile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;


@RestController
public class CalculatorController {

    @RequestMapping("/add/**")
    public ResponseEntity<?> add(HttpServletRequest req) {
        if (ServiceUtil.numeros(req.getServletPath(),"/add/")) {
            String[] stringArray = req.getServletPath().replace("/add/", "").split("/");
            Integer sum = 0;
            for (int i = 0; i < stringArray.length; i++) {
                String numberAsString = stringArray[i];
               sum += Integer.parseInt(numberAsString);
            }
            return new ResponseEntity<>(sum, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Ingrese solo numeros enteros", HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping("/subs/**")
    public ResponseEntity<?> subs(HttpServletRequest req) {
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
            return new ResponseEntity<>(sub, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Ingrese solo numeros enteros", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/mult/**")
    public ResponseEntity<?> mult(HttpServletRequest req) {
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
            return new ResponseEntity<>(mult, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Ingrese solo numeros enteros", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/div/**")
    public ResponseEntity<?> div(HttpServletRequest req) {
        if (ServiceUtil.numeros(req.getServletPath(),"/div/")) {
            String[] stringArray = req.getServletPath().replace("/div/", "").split("/");
            Double div = 0.0;
            for (int i = 0; i < stringArray.length; i++) {
                String numberAsString = stringArray[i];
                if(i>0){
                    div /= Double.parseDouble(numberAsString);
                }else{
                    div = Double.parseDouble(numberAsString);
                }
            }
            return new ResponseEntity<>(div, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Ingrese solo numeros enteros", HttpStatus.BAD_REQUEST);
        }
    }


}
