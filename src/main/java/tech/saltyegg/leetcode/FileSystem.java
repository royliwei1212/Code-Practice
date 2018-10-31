package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileSystem {

    private Trie root;

    public FileSystem() {
        root = new Trie();
    }

    public List<String> ls(String path) {
        Trie node = root;
        String name = "";
        for (String s : path.split("/")) {
            if (s.isEmpty()) continue;
            if (!node.children.containsKey(s)) return new ArrayList<>();
            node = node.children.get(s);
            name = s;
        }

        if (node.isFile) {
            return Collections.singletonList(name);
        } else {
            return new ArrayList<>(node.children.keySet());
        }
    }

    public void mkdir(String path) {
        _mkdir(path);
    }

    private Trie _mkdir(String path) {
        Trie node = root;
        for (String s : path.split("/")) {
            if (s.isEmpty()) continue;
            if (!node.children.containsKey(s)) {
                node.children.put(s, new Trie());
            }
            node = node.children.get(s);
        }
        return node;
    }

    public void addContentToFile(String filePath, String content) {
        Trie node = _mkdir(filePath);
        node.isFile = true;
        node.content += content;
    }

    public String readContentFromFile(String filePath) {
        Trie node = _mkdir(filePath);
        return node.content;
    }


    static class Trie {
        boolean isFile = false;
        String content = "";
        Map<String, Trie> children = new TreeMap<>();
    }
}
