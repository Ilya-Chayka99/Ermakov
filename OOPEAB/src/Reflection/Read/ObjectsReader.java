package src.Reflection.Read;

import src.Line.Line;
import src.Point.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectsReader<T> {
    String name;

    public ObjectsReader(String name) throws Exception{
        this.name = name;
    }
    private Object conv(String s)throws Exception{

        List<Object> o = new ArrayList<>();
        String[] pars = s.split("\\{");
        String name=pars[0];
        String oper = s.replaceFirst(name,"");
        char[] str = oper.toCharArray();
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> j =new ArrayList<>();
        Map<Integer,Integer> mapst = new HashMap<>();
        List<Integer> jst =new ArrayList<>();
        int k=0;
        while (k<str.length)
        {

            if(str[k]=='"' && jst.size()>0)
            {
                mapst.put(jst.get(jst.size()-1),k);
                jst.remove(jst.size()-1);
            }
            else {
                if(str[k]=='"')
                    jst.add(k);
            }
            k++;
        }
        k=0;
        while (k<str.length)
        {

            if(str[k]=='{'){
                Set<Integer> v = mapst.keySet();
                if(v.size()>0)
                    for(Integer m :v){
                        if(m<k) {
                            if (mapst.get(m) < k)
                                j.add(k);
                        }
                        else j.add(k);
                }
                else  j.add(k);
            }
            if(str[k]=='}')
            {
                Set<Integer> v = mapst.keySet();
                if(v.size()>0)
                    for(Integer m :v){
                        if(m<k)
                            if(mapst.get(m)<k) {
                                map.put(j.get(j.size()-1),k);
                                j.remove(j.size()-1);
                            }
                }
                else  {
                    map.put(j.get(j.size()-1),k);
                    j.remove(j.size()-1);
                }

            }
            k++;
        }
        k=0;
        while (k<str.length){
            if(str[k]==',')
            {
                Set<Integer> v = map.keySet();
                if(v.size()>0)
                    for(Integer m :v){
                        if(m<k)
                            if(map.get(m)<k ) {
                                str[k]='|';

                            }
                        else {
                            if(m==0)
                                str[k]='|';
                            else  str[k]=',';

                            }
                    }
                else  {
                    str[k]='|';
                    break;
                }
            }
            k++;
        }
        k=0;
        pars = new String(Arrays.copyOfRange(str,1,str.length-1)).split("\\|");
        for(int z=0;z<pars.length;z++) {
            String[] na = pars[z].split("=");
            String n= pars[z].replaceFirst(na[0]+"=","");
            Field field = Class.forName(name).getDeclaredField(na[0]);
            field.setAccessible(true);
            Class<?> t =transformPremetive(field.getType());
            System.out.println(t);
            if (t!=Integer.class && t!=Byte.class && t!=Character.class && t!=Double.class
                    && t!=Float.class && t!=Long.class && t!=Short.class && t!=Boolean.class && t!=String.class) {
                o.add(conv(n));

            } else {
                    switch (field.getType().getName()) {
                        case "int":
                            o.add(Integer.decode(n));
                            break;

                        case "byte":
                            o.add(Byte.decode(n));
                            break;

                        case "double":
                            o.add(Double.parseDouble(n));
                            break;

                        case "float":
                            o.add(Float.parseFloat(n));
                            break;

                        case "long":
                            o.add(Long.decode(n));
                            break;

                        case "short":
                            o.add(Short.decode(n));
                            break;

                        case "boolean":
                            o.add(Boolean.getBoolean(n));
                            break;
                        default: o.add(n);
                    }
                }

            }


            for (Constructor<?> constructor : Class.forName(name).getDeclaredConstructors()) {
                if (constructor.getParameterCount() != o.size()) continue;
                boolean good = true;
                for (int i = 0; i < constructor.getParameters().length; i++) {
                    Parameter parameter = constructor.getParameters()[i];
                    if (o.get(i).getClass() != transformPremetive(parameter.getType())) {
                        System.out.println(o.get(i).getClass());
                        System.out.println(transformPremetive(parameter.getType()));
                        good = false;
                        break;
                    }

                }
                if (good)
                    return  constructor.newInstance(o.toArray());

            }


        return new Line(1,1,1,1);
    }

    public List<T> reader() throws Exception {
        List<T> list =new ArrayList<>();
        File f =new File(name);
        Scanner sc = new Scanner(f);

        while (sc.hasNext()){
            String v =sc.nextLine();
            list.add((T)conv(v));
        }


        sc.close();
        return list;


    }

    private Class<?> transformPremetive(Class<?> clazz) {
        switch (clazz.getName()) {
            case "int":
                return Integer.class;

            case "byte":
                return Byte.class;

            case "char":
                return Character.class;

            case "double":
                return Double.class;

            case "float":
                return Float.class;

            case "long":
                return Long.class;

            case "short":
                return Short.class;

            case "boolean":
                return Boolean.class;

            default:
                return clazz;
        }
    }
}
