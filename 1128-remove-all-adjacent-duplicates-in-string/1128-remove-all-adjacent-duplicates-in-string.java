class Solution {
    public String removeDuplicates(String s) {
        int n=s.length();
       Stack<Character>stack=new Stack<>();

       for(char ch:s.toCharArray())
       {
             if(!stack.isEmpty() && stack.peek()==ch)
             {
                stack.pop();
             }
             else
             {
                    stack.push(ch);
             }
       }
      StringBuilder sb=new StringBuilder();
       while(!stack.isEmpty())
       {
         sb.append(stack.pop());
       }
       sb.reverse();
return sb.toString();
        
    }
}