package src.Converter;

public final class Converter {
    private Readable read;
    private Writeable write;
    private Changable change;


    public Converter(Readable read, Writeable write, Changable change) {// ну и какой-то файл навернго для этого=)
        this.read = read;
        this.write = write;
        this.change = change;
    }
    public  void change(){
//        this.write.write(this.change.change(this.read.read()));
//        if(this.read.read()) {
//            if(this.change.chang()) this.write.write();
//        }
    }
}
