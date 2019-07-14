package com.solfugasoft.springdata;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {
    private CarRepo carRepo;

    @Autowired
    public Start(CarRepo carRepo) {
        this.carRepo = carRepo;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {

        Car car = new Car("Volvo", "s60", Color.BLACK);
        carRepo.save(car);

        Car car2 = new Car("Honda", "NSX", Color.RED);
        carRepo.save(car2);

        Car car3 = new Car("BMW", "e36", Color.BLUE);
        carRepo.save(car3);


        Car car4 = new Car("Audi", "a4", Color.RED);
        carRepo.save(car4);


        //carRepo.deleteById(1L);

      Iterable<Car> all = carRepo.findAll();
        all.forEach(System.out::println);
        System.out.println("============");

    }
}

