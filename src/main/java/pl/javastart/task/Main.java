package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
        Product product = new Product("filet z kurczaka", "drób", 20.0, "mięso");
        ProductServices.showInfo(product);
        product = new Product("woda mineralna", "woda", 2.5, "woda");
        ProductServices.showInfo(product);
        product = new Product("laptop", "sprzęt IT", 999.97, "komputery");
        ProductServices.showInfo(product);
        product = new Product("szafa", "meble", 2000.0, null);
        ProductServices.showInfo(product);
        product = new Product("Imię róży", "Eco", 49.99, "książki");
        ProductServices.showInfo(product);
    }
}
