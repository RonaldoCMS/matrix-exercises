package hellomysql.controller;

import java.util.List;
import java.util.Scanner;

import hellomysql.model.Persona;
import hellomysql.repositories.PersonaDaoImpl;
import hellomysql.view.ErrorMessageView;

public class FindPersonaController {
    private Scanner scanner = new Scanner(System.in);


    private void outList(List<Persona> persone) {
        persone.forEach(e -> {
            System.out.println(e.toString());
        });
    }



    private void findById() throws NumberFormatException {
        System.out.println("id:\t");
        String value = scanner.nextLine();
        Persona persona = new PersonaDaoImpl().findById(Integer.parseInt(value));
        System.out.println(persona.toString());
    }

    private void findByNome() {
        System.out.println("nome:\t");
        String value = scanner.nextLine();
        List<Persona> persone = new PersonaDaoImpl().findByName(value);
        outList(persone);
    }
    private void findByCognome() {
        System.out.println("cognome:\t");
        String value = scanner.nextLine();
        List<Persona> persone = new PersonaDaoImpl().findByCognome(value);
        outList(persone);
    }

    private void findByCdf() {
        System.out.println("cdf:\t");
        String value = scanner.nextLine();
        Persona persona  = new PersonaDaoImpl().findByCdf(value);
        System.out.println(persona.toString());
    }

    public void handleInputMenu() throws NumberFormatException {
        String value = scanner.nextLine();
        switch(Integer.parseInt(value)) {
                /*
                System.out.println("1. Ricerca per id");
                System.out.println("2. Ricerca per nome");
                System.out.println("3. Ricerca per cognome");
                System.out.println("4. Ricerca per codice fiscale");
                */

            case 1: findById(); break;
            case 2: findByNome(); break;
            case 3: findByCognome(); break;
            case 4: findByCdf(); break;
            default: ErrorMessageView.showInputInvalid(); break;
        }
    }
    
}
