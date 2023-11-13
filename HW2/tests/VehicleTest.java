/*
 Домашнее задание к семинару №2 JUnit:
 1. Настроить новый проект:
     a). Нужно создать новый проект, с представленной структурой классов
     b). Настроить тестовую среду
         (создать тестовый класс VehicleTest, пометить папку как Test sources (зеленая папка),
         импортировать необходимые для тестов библиотеки (JUnit, assertJ - все что было на семинаре))
     c). Написать следующие тесты:
         - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
         - проверка того, объект Car создается с 4-мя колесами
         - проверка того, объект Motorcycle создается с 2-мя колесами
         - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
         - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
         - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
         - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
*/


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;



public class VehicleTest {

    // проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
    @Test
    public void testCarIsInstanceOfVehicle() {
        Car car = new Car("Dodge", "Ram", 2010);
        assertTrue(car instanceof Vehicle);
    };

    // проверка того, объект Car создается с 4-мя колесами
    @Test
    public void checkNumWheelsOfCar() {
        Car car = new Car("Dodge", "Ram", 2010);
        assertThat (car.getNumWheels()).isEqualTo(4);
    }

   // проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    public void checkNumWheelsOfMotorcycle() {
        Motorcycle motorcycle = new Motorcycle("Yamaha", "Super Tenere", 2013);
        assertThat (motorcycle.getNumWheels()).isEqualTo(2);
    }

    //проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    public void checkSpeedOfCar(){
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    // проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    public void checkSpeedOfMotorcycle(){
        Motorcycle motorcycle = new Motorcycle("Yamaha", "Super Tenere", 2013);
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    // проверить, что в режиме парковки (сначала testDrive, потом park,
    // т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    public void checkSpeedPakrOfCar(){
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    // проверить, что в режиме парковки (сначала testDrive, потом park
    // т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    public void checkSpeedPakrOfMotorcycle(){
        Motorcycle motorcycle = new Motorcycle("Yamaha", "Super Tenere", 2013);
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }


}
