import java.util.Comparator;

public class SortUmlObject implements Comparator<UmlObject> {
    public int compare(UmlObject umlObject, UmlObject umlObject2) {
        if(umlObject.getDepth() > umlObject2.getDepth())
            return -1;
        else
            return 1;
    }
}
