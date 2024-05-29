package org.example.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.context.BookingContext;

public class NewBookingState implements BookingState {
    private static final Logger logger = LogManager.getLogger(NewBookingState.class);
    @Override
    public void bookRoom(BookingContext context) {
        logger.info("Booking room " + context.getRoomNumber());
    }

    @Override
    public void cancelBooking(BookingContext context) {
        context.setState(new CancelledBookingState());
        logger.info("Cancel a new booking for room " + context.getRoomNumber());
    }
    @Override
    public void confirmBooking(BookingContext context) {
        context.setState(new ConfirmedBookingState());
        logger.info("Booking is confirmed for room " + context.getRoomNumber());
    }
}
