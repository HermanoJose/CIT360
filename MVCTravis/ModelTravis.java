package MVCTravis;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Joseph on 10/8/16.
 */
public class ModelTravis {
    private HashMap<String, CollegeBean> collegeHash = new HashMap<>();

    public void addCollege(String key, CollegeBean bean)
    {
        collegeHash.put(key, bean);
    }

    public Map getAllColleges()
    {
        TreeMap sortedColleges = new TreeMap(this.collegeHash);
        return sortedColleges;
    }

    public CollegeBean getCollegeByName(String name) {
        return collegeHash.get(name);
    }
}
