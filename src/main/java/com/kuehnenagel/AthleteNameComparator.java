package com.kuehnenagel;

import java.util.Comparator;

public class AthleteNameComparator implements Comparator<Athlete> {
    @Override
    // descending order
    public int compare(Athlete o1, Athlete o2) {
        return o2.getFullName().compareTo(o1.getFullName());
    }
}
