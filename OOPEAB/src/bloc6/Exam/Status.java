package src.bloc6.Exam;

public enum Status {
    PRINITO{
        @Override
        public String toString() {
            return "Принят";
        }
    },
    COMPLIT{
        @Override
        public String toString() {
            return "Выполнен";
        }
    },
    OTCLONENO{
        @Override
        public String toString() {
            return "Отклонен";
        }
    };


    public abstract String toString();
}
