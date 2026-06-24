import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ThermometerTest {
    private Thermometer thermometer;
    private int initialChanges;
    private int expectedIncrease;

    @BeforeAll
    static void initAll() {
        System.out.println("Запуск тестов Thermometer");
        Thermometer.resetTemperatureChanges();
    }

    @BeforeEach
    void setUp() {
        thermometer = new Thermometer(25.0);
        initialChanges = Thermometer.getTemperatureChanges();
        expectedIncrease = 0;
        System.out.println("Создан термометр с 25°C. Счётчик изменений: " + initialChanges);
    }

    @AfterEach
    void tearDown() {
        int finalChanges = Thermometer.getTemperatureChanges();
        assertEquals(initialChanges + expectedIncrease, finalChanges,
                "Счётчик изменений должен увеличиться на " + expectedIncrease);
        System.out.println("Тест завершён. Счётчик изменений: " + finalChanges);
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Все тесты завершены. Общее количество изменений температуры: "
                + Thermometer.getTemperatureChanges());
    }

    @Test
    @DisplayName("Задание 1: Проверка начальной температуры (25°C)")
    void testCelsiusInitial() {
        expectedIncrease = 0;
        assertEquals(25.0, thermometer.getCelsius(), 0.001);
        System.out.println("Выполняется testCelsiusInitial");
    }

    @Test
    @DisplayName("Задание 2: Конвертация 0°C в 32°F")
    void testFahrenheitZero() {
        expectedIncrease = 1;
        thermometer.setTemperature(0.0);
        assertEquals(32.0, thermometer.getFahrenheit(), 0.001);
        System.out.println("Выполняется testFahrenheitZero");
    }

    @Test
    @DisplayName("Задание 2: Конвертация 100°C в 212°F")
    void testFahrenheitHundred() {
        expectedIncrease = 1;
        thermometer.setTemperature(100.0);
        assertEquals(212.0, thermometer.getFahrenheit(), 0.001);
        System.out.println("Выполняется testFahrenheitHundred");
    }
}
