package src.Bird;

public class Popygai extends Bird{
    public Popygai(String text) {
        super(text);
    }

    @Override
    public void song() {
        int kol  = (int) (Math.random()*text.length())+1;
        char tmp;
        char[] arr=text.toCharArray();
        for(int i=0;i<kol;i++){
            int start = (int) (Math.random()*text.length());
            int end = (int) (Math.random()*text.length());
            tmp = arr[start];
            arr[start]=arr[end];
            arr[end]=tmp;
        }
        System.out.println(arr);
    }
}
