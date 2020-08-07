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
        //если больше чем 2 переменных и 1 оператора
        if(x.length != 3) throw new HandledException("withArabic", "Must be two variables with operations: +,-,/,* and seperated with whitespace");
        try {
            int c1 = Integer.parseInt(x[0]);
            String op = x[1];
            int c2 = Integer.parseInt(x[2]);
            if (c1 > 10 || c2 > 10 || c1 < 1 || c2 < 1) throw new HandledException("withArabic", "must be less 10 and greeter than 1");
            else {
                return  Integer.toString(calc(c1, op, c2));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return "something wrong";
    }
    private String withRoman(String[] x) throws HandledException {
        // Мап со значениями от 1 до 10
        HashMap<String, String> map=new HashMap<String, String>();
        map.put("", "0");map.put("I", "1");map.put("II", "2");
        map.put("III", "3");map.put("IV", "4");map.put("V", "5");
        map.put("VI", "6");map.put("VII", "7");map.put("VIII", "8");
        map.put("IX", "9");map.put("X", "10");map.put("C", "100");//и 100))

        //I обозначает 1, V обозначает 5, X — 10, L — 50, C — 100
        if(map.containsKey(x[0]) && map.containsKey(x[2])){
            x[0] = map.get(x[0]);
            x[2] = map.get(x[2]);
            String temp = withArabic(x);
            if(Integer.parseInt(temp) < 0) return "-" + getKey(map, temp.substring(1));
            else if (temp.length() == 2){
                String secondChar = getKey(map, String.valueOf(temp.charAt(1)));
                //X = I, L = V, C = X в десятичных 99 = (IX)IX = XCIX
                String firstChar = getKey(map, String.valueOf(temp.charAt(0))).replace("X","C").replace("V", "L").replace("I", "X");
                return firstChar + secondChar;
            }
            //0 на римском Nulla
            else if(Integer.parseInt(temp) == 0) return "nulla";
            else return getKey(map, temp);
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
