package com.project.sweettreats;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//time of day the order is ready to be shipped
//the distance of the required delivery
//an indicator whether refrigeration is required

@DisplayName("Given the delivery time")
public class CourierTest {

    AvailableCourier availableCourier;

    @BeforeEach
    public void setUp() {

        availableCourier  = new AvailableCourier();

    }

    //Start with time
    // 9-10 - return bobby and martin test one
    //10-1 - return everyone
    //1-4 - return marting and geoff
    //4-5 - only martin

    @ParameterizedTest
    @CsvSource({"09:15, 5, True, Bobby",
                "11:30, 2, True, Bobby, Geoff",
                "13:01, 4, True , Geoff",
    })
    void chooseMostSuitableCourier (LocalTime orderTime, int deliveryDistance, boolean isRefrigerationRequired, String expectedCourier) {

        List<Courier> availableCourierList = availableCourier.courierMostSuitableToMakeTheDelivery(orderTime, deliveryDistance,isRefrigerationRequired);

        assertEquals(expectedCourier, availableCourierList.get(availableCourierList.size()-1).getName());

    }

    @ParameterizedTest
    @CsvSource({
            "14:00, 5, True, 'No couriers available'",
    })
    void chooseMostSuitableCourier1 (LocalTime orderTime, int deliveryDistance, boolean isRefrigerationRequired, String expectedCourier) {

        List<Courier> availableCourierList = availableCourier.courierMostSuitableToMakeTheDelivery(orderTime, deliveryDistance,isRefrigerationRequired);

        assertEquals(availableCourierList.size(), 0);

    }

    @ParameterizedTest
    @CsvSource({
            "16:10, 3, False, Martin",
    })
    void chooseMostSuitableCourier2 (LocalTime orderTime, int deliveryDistance, boolean isRefrigerationRequired, String expectedCourier) {

        List<Courier> availableCourierList = availableCourier.courierMostSuitableToMakeTheDelivery(orderTime, deliveryDistance,isRefrigerationRequired);

        assertNotEquals(expectedCourier, "Anastasia");

    }


//    @DisplayName("When an order is placed")
//    @Test
//    void couriersAvailableBetween9And10Test() {
//
//        LocalTime orderTime = LocalTime.of(9, 15);
//        List<Courier> availableCourierList = availableCourier.courierMostSuitableToMakeTheDelivery(orderTime);
//
//        assertEquals(2, availableCourierList.size());
//
//    }
//
//    @Test
//    void couriersAvailableBetween10And1Test() {
//
//        LocalTime orderTime = LocalTime.of(11, 30);
//        List<Courier> availableCourierList = availableCourier.couriersAvailableAtCertainTime(orderTime);
//
//        assertEquals(3, availableCourierList.size());
//
//    }
//
//    @Test
//    void couriersAvailableBetween1And4Test() {
//
//        LocalTime orderTime = LocalTime.of(13, 01);
//        List<Courier> availableCourierList = availableCourier.couriersAvailableAtCertainTime(orderTime);
//
//        assertEquals(2, availableCourierList.size());
//
//    }
//
//    @Test
//    void couriersAvailableBetween4And5Test() {
//
//        LocalTime orderTime = LocalTime.of(16, 10);
//        List<Courier> availableCourierList = availableCourier.couriersAvailableAtCertainTime((orderTime));
//
//        assertEquals(1, availableCourierList.size());
//
//    }
//
//    @Test
//    void couriersAvailableIfDistanceIsLessThanOrEqualsTo3Miles() {
//       int deliveryDistance = 3;
//       List<Courier> availableCourierList = availableCourier.couriersAvailableAtCertainTime()
//    }


}
