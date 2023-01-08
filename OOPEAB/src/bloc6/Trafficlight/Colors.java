package src.bloc6.Trafficlight;

public enum Colors {
    red{
        private String name = "red";
        public Colors next(){
            return Colors.yellow;
        }
        @Override
        public String toString() {
            return "Color{" +
                    "name='" + name + '\'' +
                    '}';
        }
    },
    yellow{
        private String name = "yellow";

        public Colors next(){
            return Colors.green;
        }
        @Override
        public String toString() {
            return "Color{" +
                    "name='" + name + '\'' +
                    '}';
        }
    },
    green{
        private String name = "green";
        public Colors next(){
            return Colors.red;
        }

        @Override
        public String toString() {
            return "Color{" +
                    "name='" + name + '\'' +
                    '}';
        }
    };
    public abstract Colors next();
}
