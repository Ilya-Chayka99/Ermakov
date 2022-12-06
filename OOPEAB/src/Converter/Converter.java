package src.Converter;

public final class Converter {
    private Readable read;
    private Writeable write;
    private Changable change;

    public Converter(Readable read, Writeable write, Changable change) {
        this.read = read;
        this.write = write;
        this.change = change;
    }
    public void read(){
        this.read.read();
    }
    public void wtite(String st){
        if(this.read.read()) this.write.write(st);
    }
    public void change(String st){
        if(this.read.read()) this.change.chang(st);
    }
}
