public class Thermometer {
    private double celsius;
    private static int temperatureChanges = 0;

    public Thermometer(double initialCelsius) {
        this.celsius = initialCelsius;
    }

    public void setTemperature(double celsius) {
        this.celsius = celsius;
        temperatureChanges++;
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return celsius * 9.0 / 5.0 + 32;
    }

    public static int getTemperatureChanges() {
        return temperatureChanges;
    }

    public static void resetTemperatureChanges() {
        temperatureChanges = 0;
    }
}