****Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.****

class Solution {
public:
    bool isValid(string s) {
        stack<char> par;
        for(int i=0;i<s.length();i++){
            if(s[i]=='(' || s[i]=='{' || s[i]=='[')
                par.push(s[i]);
            
            else {
                if(par.empty())
            return false;
            char temp = par.top();
            par.pop();
            if(s[i]==')' && temp!='(')
                return false;
            if(s[i]=='}' && temp!='{')
                return false;
            if(s[i]==']' && temp!='[')
                return false;
            }
        }
        if (!par.empty()) 
            return false;
        return true;
    }
    
};
