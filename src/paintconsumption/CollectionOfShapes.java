package paintconsumption;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class CollectionOfShapes extends LinkedList <Shape> {
    public double getTotalCost () {
        double totalCost = 0;
        for (Shape shape : this) {
            totalCost += shape.getTotalCostOfPainting();
        }
        return new BigDecimal(totalCost).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }


    public double getTotalAmount () {
        double totalAmount  = 0;
        for (Shape shape : this) {
            totalAmount += shape.getPaintAmount();
        }
        return new BigDecimal(totalAmount).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }

    public double getTotalSquare () {
        double totalSquare  = 0;
        for (Shape shape : this) {
            totalSquare += shape.getSquare();
        }
        return new BigDecimal(totalSquare).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }
}
