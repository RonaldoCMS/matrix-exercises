package hellomysql.view;
import hellomysql.controller.MainController;
import hellomysql.exceptions.InputInvalidException;

public class MainView {
    private MainController controller;

    public MainView(MainController controller) {
        this.controller = controller;
    }

    private void menu() {
        System.out.println("================================");
        System.out.println("1. Aggiungi persona");
        System.out.println("2. Rimuovi persona");
        System.out.println("3. Modifica persona");
        System.out.println("4. Lista persone");
        System.out.println("5. Ricerca persona");
        System.out.println("0. Exit");
        System.out.println("================================");
        try {
            controller.handleInputMenu();
        } 
        catch (InputInvalidException e) {
            ErrorMessageView.showInputInvalid();
        } catch(NumberFormatException e) {
            ErrorMessageView.showNumberException();
        } 
        finally {
            menu();
        }
    }

    public void view() {
        menu();
       
    }
}
