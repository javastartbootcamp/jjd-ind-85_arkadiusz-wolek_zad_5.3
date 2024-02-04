package pl.javastart.task;

public class ProductServices {
    private static double basicVatRate = 23.0;
    private static double loweredVatRate = 8.0;
    private static double zeroVatRate = 0.0;

    public static double getGrossPrice(Product product) {
        double vatRate;
        if (product.getCategory() != null ) {
            vatRate = switch (product.getCategory()) {
                case "owoce", "mięso" -> zeroVatRate;
                case "woda", "książki" -> loweredVatRate;
                default -> basicVatRate;
            };
        } else {
            vatRate = basicVatRate;
        }
        return (Math.round((product.getNetPrice() * (1.0 + vatRate / 100.0)) * 100.0) / 100.0);
    }

    public static void showInfo(Product product) {
        System.out.println("\nProdukt: " + product.getName());
        System.out.println("Opis: " + product.getDescription());
        System.out.println("Kategoria: " + (product.getCategory() == null ? "BRAK" : product.getCategory()));
        System.out.printf("Cena netto: %.2fzł\n", product.getNetPrice());
        System.out.printf("Cena brutto: %.2fzł\n", getGrossPrice(product));
    }
}
