package tech.saltyegg.leetcode;

import java.util.Stack;

/**
 * Created by hzhou on 5/7/15. codeashobby@gmail.com Given an absolute path for a file (Unix-style), simplify it.
 * <p/>
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * <p/>
 * Corner Cases: Did you consider the case where path = "/../"? In this case, you should return "/". Another corner case is the path might contain
 * multiple slashes '/' together, such as "/home//foo/". In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) return "/";
        String[] splits = path.split("/");

        Stack<String> stack = new Stack<>();
        for (String s : splits) {
            if (s.isEmpty() || s.equals(".")) continue;
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}