package hellomysql.controller;

import java.util.List;
import java.util.Scanner;
import hellomysql.exceptions.InputInvalidException;
import hellomysql.model.Persona;
import hellomysql.repositories.PersonaDaoImpl;
import hellomysql.view.EditPersonaView;
import hellomysql.view.ErrorMessageView;
import hellomysql.view.FindPersonaView;

public class MainController {
    private Scanner scanner = new Scanner(System.in);

    public void handleInputMenu() throws NumberFormatException, InputInvalidException {
        System.out.print("-->\t");
        String value = scanner.nextLine();
        switch(Integer.parseInt(value)) {
            case 0: System.exit(0); break;
            case 1: showAddPersona(); break;
            case 2: showDelPersona(); break;
            case 3: showEditPersona(); break;
            case 4: showListPersone(); break;
            case 5: findPersona(); break;
            default: throw new InputInvalidException();
        }
    }

    public void showAddPersona() {
        System.out.print("nome:\t");
        String nome = scanner.nextLine();

        System.out.print("cognome:\t");
        String cognome = scanner.nextLine();

        System.out.println("codice fiscale:\t");
        String cdf = scanner.nextLine();

        try {
            new PersonaDaoImpl().save(new Persona(cdf, nome, cognome));
        } catch (Exception e) {
            ErrorMessageView.showIntegrityException();
            System.out.println("ERRORE");
        }
    }

    public void showDelPersona() {
        System.out.print("id:\t");
        try {
            String id = scanner.nextLine();
            new PersonaDaoImpl().delete(Integer.parseInt(id));
            System.out.println("Cancellazione effettuata con successo!");
        } catch(NumberFormatException e) {
            ErrorMessageView.showNumberException();
        }

    }

    public void showEditPersona() {
        System.out.print("id:\t");
        try {
            String id = scanner.nextLine();
            Persona persona = new PersonaDaoImpl().findById(Integer.parseInt(id));
            if(persona == null) System.out.println("Persona non trovata");
            EditPersonaController controller = new EditPersonaController(persona);
            EditPersonaView view = new EditPersonaView(controller);
            view.show();
            System.out.println("Modifica effettuata con successo!");
        } catch(NumberFormatException e) {
            ErrorMessageView.showNumberException();
        }
        
    }
    public void showListPersone() {
        
        List<Persona> persone = new PersonaDaoImpl().findAll();

        String leftAlignFormat = "| %-2d | %-11s | %-15s |  %-20s |%n";
        String divider = "+------------------+-----------------+-----------------------+%n";
        System.out.format(divider);
        System.out.format("| ID |    NOME     |    COGNOME      |    CODICE FISCALE     |%n");
        System.out.format(divider);
        persone.forEach(e -> {
            System.out.format(leftAlignFormat, e.getId(), e.getNome(), e.getCognome(), e.getCdf());
        });
        System.out.format(divider);

        System.out.println();
        System.out.print("Invia qualsiasi tasto per tornare indietro >");
        scanner.nextLine();
    }
    
    public void findPersona() {
        FindPersonaController controller = new FindPersonaController();
        FindPersonaView view = new FindPersonaView(controller);
        view.show();
    }

}
