package com.project.sweettreats;

import jakarta.annotation.PostConstruct;

import javax.lang.model.element.Name;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.stream.Collectors;

public class AvailableCourier {

    List<Courier> courierList = initCouriersList();

    @PostConstruct
    public List<Courier> initCouriersList() {

        List<Courier> courierList = List.of(
                new Courier("Bobby", 1.75, 5, LocalTime.of(9, 00), LocalTime.of(13, 00), true),
                new Courier("Martin", 1.50, 3, LocalTime.of(9, 00), LocalTime.of(17, 00), false),
                new Courier("Geoff", 2.00, 4, LocalTime.of(10, 00), LocalTime.of(16, 00), true)
        );
        return courierList;
    }

    public List<Courier> courierMostSuitableToMakeTheDelivery(LocalTime orderTime, int deliveryDistance, boolean isRefrigerationRequired) {


//        List<Courier> filteredList = courierList.stream()
//                .filter(c -> c.getStartTime().isBefore(orderTime) && c.getEndTime().isAfter(orderTime))
//                .filter(c -> c.getDistanceDelivered() >= deliveryDistance)
//                .filter(c -> c.isHasARefrigeratedBox() == isRefrigerationRequired)
//                .collect(Collectors.toList());
//
//        return filteredList;

        List<Courier> result = new ArrayList<>();
        for (int i = 0; i < courierList.size(); i++) {
            if ((courierList.get(i).getStartTime().isBefore(orderTime)) && (courierList.get(i).getEndTime().isAfter(orderTime))) {
                //System.out.println("inside first if statement");
                if (courierList.get(i).getDistanceDelivered() <= deliveryDistance) {
                    //System.out.println("inside second if statement");
                    result.add(courierList.get(i));
                    if (courierList.get(i).isHasARefrigeratedBox() == isRefrigerationRequired) {
//                        System.out.println("inside third if statement");
//                        System.out.println("value of get(i)" + courierList.get(i).getName());
                       // System.out.println("value of get(i)" + courierList.get(i).getDistanceDelivered());
                        //System.out.println("size of result is" + result.size());
                        result.add(courierList.get(i));
                        //System.out.println("size of result is" + result.size());

                    }
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
        System.out.println(result.get(i));
        }

        return result;
    }


}




//        List<Courier> result = new ArrayList<>();
//        for (int i = 0; i < courierList.size(); i++) {
//            if ((courierList.get(i).getStartTime().isBefore(orderTime)) && (courierList.get(i).getEndTime().isAfter(orderTime))) {
//                if (courierList.get(i).getDistanceDelivered() >= deliveryDistance) {
//                    if (courierList.get(i).isHasARefrigeratedBox() == isRefrigerationRequired){
//                        result.add(courierList.get(i));
//                    }
//
//                }
//
//            }
//
//        }
//        return result;

//      if ((courier.getStartTime().isBefore(orderTime)) && (courier.getEndTime().isAfter(orderTime))) {
//        if ((courier.getDistanceDelivered() >= deliveryDistance)) {
//            if (courier.isHasARefrigeratedBox() == isRefrigerationRequired) {
//                result.add(courier);
//            }

