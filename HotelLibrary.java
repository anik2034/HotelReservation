
public class HotelLibrary {
     // allHotels;  after getting everything done here will be all hotels that our system has.

    public static  Hotel[] getAllHotels() {
        Hotel[] allHotels = new Hotel[10];   //Edit, continue other 9 hotels.
        Room h1r1= new Room(
                1000,
                10,
                9000,
                16000,
                "Single",
                1,
                true,
                false,
                14,
                1);
        Room h1r2= new Room(
                1000,
                10,
                9000,
                16000,
                "Single Lux",
                1,
                false,
                true,
                14,
                1);

        Room h1r3= new Room(
                3000,
                10,
                13000,
                19000,
                "Duo",
                2,
                true,
                false,
                8,
                2);
        Room h1r4= new Room(
                3000,
                10,
                13000,
                19000,
                "Duo Lux",
                2,
                false,
                true,
                8,
                2);
        Room h1r5= new Room(
                6000,
                20,
                24000,
                30000,
                "Quad",
                4,
                true,
                false,
                4,
                4);
        Room h1r6= new Room(
                6000,
                20,
                24000,
                30000,
                "Quad",
                4,
                false,
                true,
                4,
                4);
        Room[] h1Rooms={h1r1,h1r2,h1r3,h1r4,h1r5,h1r6};

        allHotels[0]=new Hotel(1,
                "Hotel Armenia",
                "Yerevan",
                "Amiryan Street 12",
                false,
                true,
                false,
                 h1Rooms);



        return allHotels;
    }
}
