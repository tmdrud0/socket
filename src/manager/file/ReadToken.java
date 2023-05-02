package manager.file;

import java.lang.reflect.Method;

import manager.Token;

class ReadToken extends Token{
    @Override
    protected String getString() {return "r";}
    @Override
    protected int getArgNum() {return 2;}

    @Override
    protected Method getm() throws Exception {
        return FileMachine.class.getDeclaredMethod("read", String.class);
    }
}