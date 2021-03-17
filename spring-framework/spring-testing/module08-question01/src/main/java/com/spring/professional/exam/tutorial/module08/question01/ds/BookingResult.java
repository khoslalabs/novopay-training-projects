package com.spring.professional.exam.tutorial.module08.question01.ds;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;
import java.util.Optional;


public class BookingResult {
    private BookingState bookingState;
    private Reservation reservation;

    public static BookingResult createRoomBookedResult(Reservation reservation) {
        return new BookingResult(BookingState.ROOM_BOOKED, reservation);
    }

    public static BookingResult createNoRoomAvailableResult() {
        return new BookingResult(BookingState.NO_ROOM_AVAILABLE, null);
    }

    private BookingResult(BookingState bookingState, Reservation reservation) {
        this.bookingState = bookingState;
        this.reservation = reservation;
    }

    public BookingState getBookingState() {
        return bookingState;
    }

    public Optional<Reservation> getReservation() {
        return Optional.ofNullable(reservation);
    }

    public enum BookingState {
        ROOM_BOOKED,
        NO_ROOM_AVAILABLE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingResult that = (BookingResult) o;
        return bookingState == that.bookingState && Objects.equals(reservation, that.reservation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingState, reservation);
    }

    @Override
    public String toString() {
        return "BookingResult{" +
                "bookingState=" + bookingState +
                ", reservation=" + reservation +
                '}';
    }
}
