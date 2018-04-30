package co.edu.javeriana.calculator.util;

public class ServiceUtil {

    public static boolean numeros(String path, String operacion){
        return path.replace(operacion, "")
                .replace("/", "")
                .replace("-", "").matches("[0-9]*");
    }
}
