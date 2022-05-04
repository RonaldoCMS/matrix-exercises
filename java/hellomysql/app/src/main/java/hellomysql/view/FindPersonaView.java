package hellomysql.view;

import hellomysql.controller.FindPersonaController;

public class FindPersonaView {
    private FindPersonaController controller;

    public FindPersonaView(FindPersonaController controller) {
        this.controller = controller;
    }

    private void menu() {
        System.out.println("================================");
        System.out.println("1. Ricerca per id");
        System.out.println("2. Ricerca per nome");
        System.out.println("3. Ricerca per cognome");
        System.out.println("4. Ricerca per codice fiscale");
        System.out.println("================================");

    }

    public void show() {
        menu();
        controller.handleInputMenu();
    }

}
