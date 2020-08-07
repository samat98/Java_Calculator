public class Controller{

    View view = new View();

    public Controller(){
        String inputText = view.getInputText();
        String[] expression = splittedText(inputText);
        Model model = new Model(expression);
        view.printResult(model.getRes());
    }

    String[] splittedText(String str){
        String[] res = new String[3];
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                res[0] = str.substring(0, i).trim();
                res[1] = String.valueOf(c);
                res[2] = str.substring(i+1).trim();
                return res;
            }
        }
        return res;
    }
}