package jmp.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class Event {

    private Integer id;
    private String movieName;
    private Integer price;
    private LocalDateTime startTime;
    private Set<Integer> freePlaces;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Set<Integer> getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(Set<Integer> freePlaces) {
        this.freePlaces = freePlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) &&
                Objects.equals(movieName, event.movieName) &&
                Objects.equals(price, event.price) &&
                Objects.equals(startTime, event.startTime) &&
                Objects.equals(freePlaces, event.freePlaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieName, price, startTime, freePlaces);
    }

}
