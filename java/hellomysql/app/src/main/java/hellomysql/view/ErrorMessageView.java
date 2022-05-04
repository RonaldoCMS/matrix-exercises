package hellomysql.view;

public class ErrorMessageView {
    public static void showInputInvalid() {
        System.out.println("Il valore inserito non è valido.");
        loading();
    }

    private static void loading() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            System.out.println("Errore! Chisura in corso");
            System.exit(-1);
        }
    }

    public static void showNumberException() {
        System.out.println("Attenzione, probabilmente hai inserito un carattere non valido!");
        loading();
    }
    
    public static void showIntegrityException() {
        //com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException e
        System.out.println("Attenzione, violazione integrità: la persona probabilmente già è stata inserita.");
    }
}
