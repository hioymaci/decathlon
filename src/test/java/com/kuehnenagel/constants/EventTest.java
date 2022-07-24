package com.kuehnenagel.constants;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EventTest {

    @Test
    void get_shouldReturnEvent_whenInputIsValid() {
        Event run100m = Event.get("100-meter dash");
        Assertions.assertNotNull(run100m);
    }

    @Test
    void get_shouldReturnNull_whenThereIsNoEventWithGivenInput() {
        Event event = Event.get("xxxxxx");
        Assertions.assertNull(event);
    }
}
