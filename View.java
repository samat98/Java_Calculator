import java.util.Scanner;

public class View{
    private String inputText;
    private String res;

    public View(){
        Scanner in = new Scanner(System.in);
        System.out.print("Input expression: ");
        this.inputText = in.nextLine();
        in.close();
    }

    public void printResult(String res){
        System.out.println(res);
    }

    public String getInputText() {
        return inputText;
    }
}