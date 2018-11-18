package tech.saltyegg.airbnb;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {

    private Map<String, Integer> pathMap;
    private Map<String, Runnable> callMap;

    public FileSystem() {
        pathMap = new HashMap<>();
        callMap = new HashMap<>();
        pathMap.put("", 0);
    }


    public boolean create(String path, int value) {
        // check leaf exist
        if (pathMap.containsKey(path)) return false;

        // check folder exist
        String folder = path.substring(0, path.lastIndexOf("/"));
        if (!pathMap.containsKey(folder)) return false;

        pathMap.put(path, value);
        return true;
    }

    public boolean setValue(String path, int value) {
        if (!pathMap.containsKey(path)) return false;
        pathMap.put(path, value);

        while (!path.isEmpty()) {
            if (callMap.containsKey(path)) callMap.get(path).run();
            path = path.substring(0, path.lastIndexOf("/"));
        }
        return true;
    }

    public Integer getValue(String path) {
        return pathMap.get(path);
    }

    public boolean watch(String path, Runnable callback) {
        if (!pathMap.containsKey(path)) return false;
        callMap.put(path, callback);
        return true;
    }
}
