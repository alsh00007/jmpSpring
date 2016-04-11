package jmp.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private String number;
    private String movieName;
    private LocalDateTime startTime;
    private Integer place;
    private Integer price;
    private User user;

    public Order() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(number, order.number) &&
                Objects.equals(movieName, order.movieName) &&
                Objects.equals(startTime, order.startTime) &&
                Objects.equals(place, order.place) &&
                Objects.equals(price, order.price) &&
                Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, movieName, startTime, place, price, user);
    }

    @Override
    public String toString() {
        return "Order{" +
                "number='" + number + '\'' +
                ", movieName='" + movieName + '\'' +
                ", startTime=" + startTime +
                ", place=" + place +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}
