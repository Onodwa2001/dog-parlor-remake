package za.ac.cput.dogparlor.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class PaymentHistory {

    @Id
    private String paymentID;

    private double amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;

    private Booking booking;
    protected PaymentHistory(){}

    private PaymentHistory(Builder builder){
        this.paymentID = builder.paymentID;
        this.booking = builder.booking;
        this.amount = builder.amount;
        this.paymentDate = builder.paymentDate;
        this.paymentMethod = builder.paymentMethod;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }


    public Booking getBooking() {
        return booking;
    }


    public static class Builder{

        private String paymentID;

        private double amount;
        private LocalDateTime paymentDate;
        private String paymentMethod;
        private Booking booking;

        public Builder(){}

        public Builder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPaymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setBooking(Booking booking) {
            this.booking = booking;
            return this;
        }


        public Builder copy(PaymentHistory paymentHistory){
            this.paymentID = paymentHistory.paymentID;
            this.amount = paymentHistory.amount;
            this.paymentDate = paymentHistory.paymentDate;
            this.paymentMethod = paymentHistory.paymentMethod;
            this.booking = paymentHistory.booking;
            return this;
        }

        public PaymentHistory build(){
            return  new PaymentHistory(this);
        }
    }
}
