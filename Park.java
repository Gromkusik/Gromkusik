public class Park {
    //3. Создать класс Park с внутренним классом, с помощью объектов которого
    //можно хранить информацию об аттракционах, времени их работы и стоимости.
    private String parkName;
    private String location;
    private int capacity;
    public Park(String parkName, String location, int capacity) {
        this.parkName = parkName;
        this.location = location;
        this.capacity = capacity;
    }
    public class Attraction {
        private String attractionName;
        private int attractionCapacity;
        private String attractionPrice;
        private String attractionTime;
        public Attraction(String attractionName, int attractionCapacity, String attractionPrice, String attractionTime) {
            this.attractionName = attractionName;
            this.attractionCapacity = attractionCapacity;
            this.attractionPrice = attractionPrice;
            this.attractionTime = attractionTime;
        }
    }

}
