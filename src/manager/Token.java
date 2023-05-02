package manager;

import java.lang.reflect.*;

public abstract class Token {
    String string;
    int argNum;
    Method method;
    public Token(){
        string = getString();
        argNum = getArgNum();
        try {
            this.method = getm();
        } catch (Exception e) {
            System.out.println("Token 생성 오류");
            e.printStackTrace();
        }
    }

    public Boolean isMatching(String input){
        return string.equals(input);
    }
    public Boolean isRightArgs(String input){
        return argNum == input.split(" ").length;
    }
    public Method getMethod(){
        return method;
    }
    public Object[] makeArgs(String input){
        return (Object[])input.substring(input.indexOf(" ")+1,input.length()).split(" ");
    }
    protected abstract String getString();
    protected abstract int getArgNum();
    protected abstract Method getm() throws Exception;
}