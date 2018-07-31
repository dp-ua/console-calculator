package logic.math;

public class ParseString {
    String string;

    public ParseString(String string) {
        this.string = string.trim();
    }

    public boolean check(){
        // TODO: 31.07.18 написать правильную проверку введеной строки
        boolean result=false;
        //System.out.println(string.matches("^/d*[0-9/-/+/*///:]+/d+$"));
        return result;
    }
}
