package a005;

import java.util.Stack;

/**
 * 71. Simplify Path
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * path = "/a/../../b/../c//.//", => "/c"
 * path = "/a//b////c/d//././/..", => "/a/b/c"
 *
 * In a UNIX-style file system, a period ('.') refers to the current directory,
 * so it can be ignored in a simplified path. Additionally, a double period ("..") moves up a directory,
 * so it cancels out whatever the last directory was. For more information,
 *
 *
 *
 * look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style
 *
 * Corner Cases:
 *
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class simplifyPaths_071 {
    public String simplifyPath(String path) {
        //两个点 1. string.split   format  input String
        //2.stack
        if(path.length() == 0 || path == null)return "/";

        String[] nor = path.split("/");
        Stack<String> s = new Stack<>();
        for(int i  = 0; i < nor.length; i++){
            if(nor[i].equals(".") || nor[i].equals("")  ) continue;

            if(nor[i].equals("..") && !s.isEmpty()){
                s.pop();
            }else if(!nor[i].equals("..")){
                s.push(nor[i]);}
        }

        String res = "";
        if(s.isEmpty()) return "/";
        while(!s.isEmpty()){
            res = "/" + s.pop() +res;
        }


        return res;

    }
}
