package FrameWork;

public class BarCodeExceptions extends Exception {

    public BarCodeExceptions(String e, String clase, String metodo) {
      // System.out.println("[404]   "+ clase+"."+metodo+":"+e);
    }
    @Override
    public String getMessage(){
        return  "¿Que haces?";
    }
}
