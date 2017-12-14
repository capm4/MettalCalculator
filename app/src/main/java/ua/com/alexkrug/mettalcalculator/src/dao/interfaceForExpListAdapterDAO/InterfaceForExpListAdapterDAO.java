package ua.com.alexkrug.mettalcalculator.src.dao.interfaceForExpListAdapterDAO;

import java.util.List;

import ua.com.alexkrug.mettalcalculator.src.model.RectangularProfileTube;

public interface InterfaceForExpListAdapterDAO<T> {
    //used for HotRolledSteel, ColdRolledSteel, SteelStrips,ProfileTubeSquare, RoundTube
    List<T> selectByThickness (Double thickness, List<T> list);
    //used for only for RectangularProfileTube
    List<T> selectByDimensions (Double width, Double height, List<T> list);
    //used for HotRolledSteel, ColdRolledSteel, SteelStrips,ProfileTubeSquare, RoundTube
    List<Double> listOfThickness();
}
