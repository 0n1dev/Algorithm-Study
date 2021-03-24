import java.util.EmptyStackException;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        
        String[] chars = s.split("");        
        Stack<String> stack = new Stack<>();
        
        for (String c : chars) {
            try {
                switch (c) {
                    case ")":                  
                        if (!stack.pop().equals("("))
                            return false;
                        break;
                    case "}":                    
                        if (!stack.pop().equals("{"))
                            return false;
                        break;
                    case "]":                    
                        if (!stack.pop().equals("["))
                            return false;
                        break;
                    default :
                        stack.push(c);
                }
            } catch(EmptyStackException e) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}