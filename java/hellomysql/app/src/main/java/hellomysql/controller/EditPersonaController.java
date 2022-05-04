package hellomysql.controller;

import java.util.Scanner;

import hellomysql.model.Persona;
import hellomysql.repositories.PersonaDaoImpl;

public class EditPersonaController {
    Scanner scanner = new Scanner(System.in);
    Persona persona;
    public EditPersonaController(Persona persona) {
        this.persona = persona;
    }

    public void handleInputMenu() {
        System.out.print("-->\t");
        String value = scanner.nextLine();
        try {
            switch(Integer.parseInt(value)) {
                case 1: editNome(); break;
                case 2: editCognome(); break;
                case 3: editCdf(); break;
            }
        } catch(NumberFormatException e) {
            System.out.println("Attenzione, non hai inserito un numero!");
        }

        /**
         *      System.out.println("1. Modifica nome");
                System.out.println("2. Modifica cognome");
                System.out.println("3. Modifica codice fiscale");
         */
    }

    private void editCdf() {
        System.out.print("cdf: ");
        String nome = scanner.nextLine();
        persona.setCdf(nome);
        new PersonaDaoImpl().update(persona);
    }

    private void editCognome() {
        System.out.print("cognome: ");
        String cognome = scanner.nextLine();
        persona.setCognome(cognome);
        new PersonaDaoImpl().update(persona);
    }

    private void editNome() {
        System.out.print("nome: ");
        String cognome = scanner.nextLine();
        persona.setNome(cognome);
        new PersonaDaoImpl().update(persona);
    }
    
}
