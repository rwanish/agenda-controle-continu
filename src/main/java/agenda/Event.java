package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

public class Event {

    /**
     * The myTitle of this event
     */
    private final String myTitle;
    
    /**
     * The starting time of the event
     */
    private final LocalDateTime myStart;

    /**
     * The durarion of the event 
     */
    private final Duration myDuration;

    //Ajout autres attributs
    private ChronoUnit repetitionFrequency;

    private final Set<LocalDate> exceptions = new HashSet<>();

    private LocalDate terminationDate;

    private long occurrencesCount;


    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    public void setRepetition(ChronoUnit frequency) {
        // TODO : implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté")
        this.repetitionFrequency = frequency;
    }

    public void addException(LocalDate date) {
        // TODO : implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        //Ajoute des dates d'exception où l'évènement ne doit pas se répéter.
        // (voir attributs en haut) Dans ce cas on peut utiliser une collection pour stocker ces dates d'exception
        exceptions.add(date);
    }

    public void setTermination(LocalDate terminationInclusive) {
        // TODO : implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        //Définit une date de fin de répétition
        this.terminationDate = terminationInclusive;
    }

    public void setTermination(long numberOfOccurrences) {
        // TODO : implémenter cette méthode
        //Définit un nombre d'occurrences après lequel l'événement ne se répète plus.
        this.occurrencesCount = numberOfOccurrences;

        //throw new UnsupportedOperationException("Pas encore implémenté");


    }

    public int getNumberOfOccurrences() {
        // TODO : implémenter cette méthode
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    public LocalDate getTerminationDate() {
        // TODO : implémenter cette méthode
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        // TODO : implémenter cette méthode

        //throw new UnsupportedOperationException("Pas encore implémenté");
        // Dans la fonction isInDay, on cherche à convertir la date de début en LocalDate
        LocalDate eventStartDate = myStart.toLocalDate();
        //Ensuite, on calcule la date de fin en fonction de la duréé
        LocalDate eventEndDate = myStart.plus(myDuration).toLocalDate();

        //On vérifie si aDay est compris entre la date de début et de fin
        return (aDay.isEqual(eventStartDate) || aDay.isAfter(eventStartDate)) &&
                (aDay.isEqual(eventEndDate) || aDay.isBefore(eventEndDate));
    }
   
    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

    @Override
    public String toString() {
        return "Event{title='%s', start=%s, duration=%s}".formatted(myTitle, myStart, myDuration);
    }

}
