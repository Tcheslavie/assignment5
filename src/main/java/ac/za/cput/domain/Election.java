package ac.za.cput.domain;

import java.util.ArrayList;
import java.util.List;

public class Election {
    private int year;

    private Election(){}
    private Election(Builder builder)
    {
        this.year = builder.year;
    }

    public int getYear() {
        return year;
    }


    public static class Builder
    {
        private int year;

        public Builder year (int year)
        {
            this.year = year;
            return this;
        }
        public Election build()
        {
            return new Election(this);
        }
    }
}
