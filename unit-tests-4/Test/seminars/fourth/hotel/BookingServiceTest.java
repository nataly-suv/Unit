package seminars.fourth.hotel;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {
    private HotelService checkRoom;
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        checkRoom = mock(HotelService.class);
        bookingService = new BookingService(checkRoom);
    }

    @Test
    void checkNumberTrue() {
        when(checkRoom.isRoomAvailable(24)).thenReturn(true);

        boolean result = bookingService.bookRoom(24);

        assertTrue(result);
    }

    @Test
    void checkNumberFalse() {
        when(checkRoom.isRoomAvailable(23)).thenReturn(false);

        boolean result = bookingService.bookRoom(23);

        assertFalse(result);
    }


}