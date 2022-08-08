package advanceddsa.stack1;

import java.util.Stack;

/**
 * Given a string A representing an absolute path for a file (Unix-style).
 * <p>
 * Return the string A after simplifying the absolute path.
 * <p>
 * Note:
 * <p>
 * In Unix-style file system:
 * <p>
 * A period '.' refers to the current directory.
 * A double period '..' refers to the directory up a level.
 * Any multiple consecutive slashes '//' are treated as a single slash '/'.
 * In Simplified Absolute path:
 * <p>
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path doesn't end with trailing slashes '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Path will not have whitespace characters.
 * <p>
 * Input Format
 * <p>
 * The only argument given is string A.
 * Output Format
 * <p>
 * Return a string denoting the simplified absolute path for a file (Unix-style).
 * For Example
 * <p>
 * Input 1:
 * A = "/home/"
 * Output 1:
 * "/home"
 * <p>
 * Input 2:
 * A = "/a/./b/../../c/"
 * Output 2:
 * "/c"
 */
public class SimplifyDirectoryPath {

    public static String simplifyPath(String A) {
        A += "/";
        Stack<String> stack = new Stack<>();
        StringBuilder dirName = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '/') {
                switch (dirName.toString()) {
                    case "":
                    case ".":
                        break;
                    case "..":
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                        break;
                    default:
                        stack.push(dirName.toString());
                        break;
                }
                dirName.setLength(0);
            } else {
                dirName.append(ch);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stack) {
            stringBuilder.append("/").append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String A = "/home/";
        System.out.println(simplifyPath(A));
    }
}
