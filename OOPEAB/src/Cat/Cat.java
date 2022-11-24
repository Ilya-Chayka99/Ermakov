package src.Cat;

public class Cat extends Cats{
    public Cat(String name) {
        super(name);
    }
    public void meow(int n){
        String str="";
        for(int i=0;i<n;i++)
        {
            str+=(i!=0?"-":"") +"мяу";
        }
        System.out.println(name+":"+str+"!");
    }
    public void meow()
    {
        this.meow(1);
    }
    @Override
    public String toString() {
        return "кот:" + name;
    }
}
