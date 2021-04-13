package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public interface Filtering {

    String message = "Filtering";
    public default void message(){
        System.out.println(message);
    }

}
