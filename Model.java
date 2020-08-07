import java.util.*;

public class Model{

    private String res;

    public Model(String[] expression){
        if((int) expression[0].charAt(0) > 64){
            try {
                res = withRoman(expression);
            } catch(Exception e) {
                System.out.println(e);
            }

        }
        else {
            try {
                res = withArabic(expression);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private int calc(int x ,String op, int y) throws HandledException{
        switch (op){
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                throw new HandledException("calc", "operator is not acceptable");
        }
    }
    private String withArabic(String[] x) throws HandledException {
        if(x.length != 3) throw new HandledException("withArabic", "Must be two variables with operations: +,-,/,* and seperated with whitespace");
        try {
            int c1 = Integer.parseInt(x[0]);
            String op = x[1];
            int c2 = Integer.parseInt(x[2]);
            if (c1 > 10 || c2 > 10) throw new HandledException("withArabic", "must be less 10");
            else {
                return  Integer.toString(calc(c1, op, c2));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return "Something went wrong";
    }
    private String withRoman(String[] x) throws HandledException {
        HashMap<String, String> map=new HashMap<String, String>();
        map.put("I", "1");
        map.put("II", "2");
        map.put("III", "3");
        map.put("IV", "4");
        map.put("V", "5");
        map.put("VI", "6");
        map.put("VII", "7");
        map.put("VIII", "8");
        map.put("IX", "9");
        map.put("X", "10");
        map.put("XI", "11");
        map.put("XII", "12");
        map.put("XIII", "13");
        map.put("XIV", "14");
        map.put("XV", "15");
        map.put("XVI", "16");
        map.put("XVII", "17");
        map.put("XVIII", "18");
        map.put("XIX", "19");
        map.put("XX", "20");

        if(map.containsKey(x[0]) && map.containsKey(x[2])){
            x[0] = map.get(x[0]);
            x[2] = map.get(x[2]);
            return getKey(map, withArabic(x));
        }
        else throw new HandledException("withRoman", "must be proper roman characters");

    }
    private  <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String getRes() {
        return res;
    }
}
