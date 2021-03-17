package com.spring.professional.exam.tutorial.module08.question08.ds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Objects;


public class BookingRequest {
    private Guest guest;
    private LocalDate bookingDate;

    @SuppressWarnings("unused")
    BookingRequest() {
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "guest=" + guest +
                ", bookingDate=" + bookingDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingRequest that = (BookingRequest) o;
        return Objects.equals(guest, that.guest) && Objects.equals(bookingDate, that.bookingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guest, bookingDate);
    }

    public BookingRequest(Guest guest, LocalDate bookingDate) {
        this.guest = guest;
        this.bookingDate = bookingDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
