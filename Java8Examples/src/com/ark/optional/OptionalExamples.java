package com.ark.optional;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;

/**
 * Java 8 Optional Examples
 */
public class OptionalExamples {
    public static void main(String[] args) {
        Optional<Car> emptyOptional = Optional.empty();// calling get() will result in NoSuchElementException
        System.out.println("Optional with no value" + emptyOptional.isPresent());
        Car car = new Car("ABC", 22.00);
        Optional<Car> nonEmptyOptional = Optional.of(car);
        System.out.println("Non Empty Optional " + nonEmptyOptional.get());
        System.out.println("Non Empty Optional isPresent()" + nonEmptyOptional.isPresent());
        Consumer<Car> carConsumer = (car1 -> System.out.println("I am purchasing car " + car1));
        nonEmptyOptional.ifPresent(carConsumer);
        emptyOptional.ifPresent(carConsumer);//nothing happens as ifPresent return false
        emptyOptional.orElse(new Car("New Car", 22.0));
        Optional<Double> correctPrice = getCarPriceFromStr("12.22");
        System.out.println(correctPrice.get());
        Optional<Double> incorrectPrice = getCarPriceFromStr("12.22abc");
        System.out.println(incorrectPrice.isPresent());
    }

    //Example of Exception handling with Optional

    public static Optional<Double> getCarPriceFromStr(String price) {
        try {
            return Optional.of(Double.valueOf(price));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

class Car {
    private final String model;
    private final double price;

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}
