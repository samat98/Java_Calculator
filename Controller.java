public class Controller{

    View view = new View();

    public Controller(){
        String[] expression = view.getInputText().split(" ", 0);
        Model model = new Model(expression);
        view.printResult(model.getRes());
    }
}