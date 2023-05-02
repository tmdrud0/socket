package manager.file;

import java.lang.reflect.*;
import java.util.*;

import manager.*;

public class FileTokens extends Tokens{
    @Override
    protected ArrayList<Token> getTokens() {
        ArrayList<Token> result = new ArrayList<>(3);
        result.add(0, new ReadToken());
        result.add(1, new WriteToken());
        result.add(2,new AppendToken());
        return result;
    }
}

class WriteToken extends Token{
    @Override
    protected String getString() {return "w";}
    @Override
    protected int getArgNum() {return 3;}

    @Override
    protected Method getm() throws Exception {
        return FileMachine.class.getDeclaredMethod("write", String.class,String.class);
    }
}
class AppendToken extends Token{
    @Override
    protected String getString() {return "a";}
    @Override
    protected int getArgNum() {return 3;}

    @Override
    protected Method getm() throws Exception {
        return FileMachine.class.getDeclaredMethod("append", String.class,String.class);
    }
}