package main.java.ui;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import main.java.service.ExchangeRateApiService;

public class Main {
    public static void main(String[] args) throws IOException {

        // Bienvenida y solicitud del valor a convertir
        System.out.println("Hello, welcome to the exchange money software");

        ///First input part
        // Mostrar menú de opciones de conversión
        System.out.println("Please select your based currency:");
        System.out.println("Type a number(option)");
        System.out.println("1. USD - Dollars");
        System.out.println("2. ARS - Argentine Peso");
        System.out.println("3. COP - Colombian Peso");
        System.out.println("4. EUR - Euro");
        System.out.println("5. UYU - Uruguayan Peso");
        System.out.println("6. PEN - Peruvian Peso");
        System.out.println("7. CLP - Chilean Peso");
        System.out.println("8. BRL - Brazilian Reais");
        System.out.println("9. BOB - Bolivian Peso");

        Scanner scannerFirstInput = new Scanner(System.in);
        // Leer la opción seleccionada por el usuario
        int optionBasedCurrency = scannerFirstInput.nextInt();
        scannerFirstInput.nextLine(); // Limpiar el buffer

        // Convertir la opción seleccionada a la moneda correspondiente
        String originCurrency = switch (optionBasedCurrency) {
            case 1 -> "USD";
            case 2 -> "ARS";
            case 3 -> "COP";
            case 4 -> "EUR";
            case 5 -> "UYU";
            case 6 -> "PEN";
            case 7 -> "CLP";
            case 8 -> "BRL";
            case 9 -> "BOB";
            default -> null;
        };

        //Show the selected based currency
        System.out.println("Your selected based currency is:" +originCurrency);

        ///Second input part
        // Mostrar menú de opciones de conversión
        System.out.println("Now, Please select your target currency:");
        System.out.println("Type a number(option)");
        System.out.println("1. USD - Dollars");
        System.out.println("2. ARS - Argentine Peso");
        System.out.println("3. COP - Colombian Peso");
        System.out.println("4. EUR - Euro");
        System.out.println("5. UYU - Uruguayan Peso");
        System.out.println("6. PEN - Peruvian Peso");
        System.out.println("7. CLP - Chilean Peso");
        System.out.println("8. BRL - Brazilian Reais");
        System.out.println("9. BOB - Bolivian Peso");

        //User input value
        Scanner scannerSecondInput = new Scanner(System.in);
        int optionTargetCurrency = scannerSecondInput.nextInt();
        scannerSecondInput.nextLine(); // Limpiar el buffer

        String targetCurrency = switch (optionTargetCurrency) {
            case 1 -> "USD";
            case 2 -> "ARS";
            case 3 -> "COP";
            case 4 -> "EUR";
            case 5 -> "UYU";
            case 6 -> "PEN";
            case 7 -> "CLP";
            case 8 -> "BRL";
            case 9 -> "BOB";
            default -> null;
        };

        //Show the selected based currency
        System.out.println("Your selected target currency is:" +targetCurrency);

        //resume selected data
        System.out.println("Resume:\nYour selected based currency is: "+ originCurrency+"\nYour selected target currency is: "+targetCurrency);

        //
        System.out.println("Finally, type the value you want to convert ");
        Scanner valueToConvertKeyboard = new Scanner(System.in).useLocale(Locale.US);
        double valueToConvert = valueToConvertKeyboard.nextDouble();


        // Utilizar el servicio ExchangeRateApiService para obtener la respuesta JSON
        ExchangeRateApiService services = new ExchangeRateApiService();
        double conversionRate = services.getConversionRate(originCurrency, targetCurrency);
        //System.out.println("Conversion rate for: "+ targetCurrency + conversionRate);

      double finalConvertedValue = getValueConverted(valueToConvert,conversionRate);

       System.out.println("Your converted value is "+ finalConvertedValue);

    }

    //In this function we calculated the converted value
    public static double getValueConverted(double valueToConvert, double conversionRate) {

        return valueToConvert * conversionRate;
    }


}