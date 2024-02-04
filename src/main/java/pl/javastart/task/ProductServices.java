package pl.javastart.task;

public class ProductServices {
    private static final double BASIC_VAT_RATE = 23.0;
    private static final double LOWERED_VAT_RATE = 8.0;
    private static final double ZERO_VAT_RATE = 0.0;

    public static double getGrossPrice(Product product) {
        double vatRate;
        if (product.getCategory() != null) {
            vatRate = switch (product.getCategory()) {
                case "owoce", "mięso" -> ZERO_VAT_RATE;
                case "woda", "książki" -> LOWERED_VAT_RATE;
                default -> BASIC_VAT_RATE;
            };
        } else {
            vatRate = BASIC_VAT_RATE;
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
