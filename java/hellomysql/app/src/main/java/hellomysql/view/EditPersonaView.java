package hellomysql.view;

import hellomysql.controller.EditPersonaController;

public class EditPersonaView {
    private EditPersonaController controller;

    public EditPersonaView(EditPersonaController controller) {
        this.controller = controller;
    }

    private void menu() {
        System.out.println("================================");
        System.out.println("1. Modifica nome");
        System.out.println("2. Modifica cognome");
        System.out.println("3. Modifica codice fiscale");
        System.out.println("================================");
    }

    public void show() {
        menu();
        controller.handleInputMenu();
    }
}
