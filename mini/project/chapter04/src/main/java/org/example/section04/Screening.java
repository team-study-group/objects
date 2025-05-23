package org.example.section04;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Money calculateFee(int audienceCount){
        switch (movie.getMovieType()){
            case AMOUNT_DISCOUNT -> {
                if(movie.isDiscountable(whenScreened, sequence)){
                    return movie.calculateAmountDiscountedFee().times(audienceCount);
                }
            }
            case PERCENT_DISCOUNT -> {
                if(movie.isDiscountable(whenScreened, sequence)){
                    return movie.calculatePercentDiscountedFee().times(audienceCount);
                }
            }
            case NONE_DISCOUNT -> movie.calculateNoneDIscountFee().times(audienceCount);
        }
        return  movie.calculateNoneDIscountFee().times(audienceCount);
    }
}
