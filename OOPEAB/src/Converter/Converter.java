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
    public void read(){
        this.read.read();
    } //тоже файл
    public void write(String st){
        if(this.read.read()) this.write.write(st);
    }
    public void change(String st){
        if(this.read.read()) {
            if(this.change.chang(st)) this.write.write();
        }
    }
}
