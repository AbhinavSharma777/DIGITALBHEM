import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        // Default exchange rates
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
    }

    public void addExchangeRate(String currencyCode, double rate) {
        exchangeRates.put(currencyCode, rate);
    }

    public void displayExchangeRates() {
        System.out.println("Available Exchange Rates:");
        for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.getOrDefault(fromCurrency, 1.0);
        double toRate = exchangeRates.getOrDefault(toCurrency, 1.0);
        return (amount / fromRate) * toRate;
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Display Exchange Rates");
            System.out.println("2. Convert Currency");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    converter.displayExchangeRates();
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter from currency code: ");
                    String fromCurrency = scanner.nextLine().toUpperCase();

                    System.out.print("Enter to currency code: ");
                    String toCurrency = scanner.nextLine().toUpperCase();

                    double result = converter.convertCurrency(amount, fromCurrency, toCurrency);
                    System.out.println(amount + " " + fromCurrency + " = " + result + " " + toCurrency);
                    break;
                case 3:
                    System.out.println("Currency Converter application closed. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
