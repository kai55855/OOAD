import java.util.Comparator;

public class SortShapeObject implements Comparator<Shape>{
    public int compare(Shape o, Shape o2){
        if(o.getDepth() > o2.getDepth()){
            return -1;
        }
        else
            return 1;
    }
}
