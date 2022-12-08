package src.Stydent;

import java.util.List;

public interface RuleSudent<T> {
    boolean otl(List<T> a);
    T getMediumRate(List<T> a);

}

