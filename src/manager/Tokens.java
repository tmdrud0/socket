package manager;

import java.util.ArrayList;

public abstract class Tokens {
    ArrayList<Token> tokens;

    abstract protected ArrayList<Token> getTokens();
    public Tokens(){
        tokens = getTokens();
    }
    
    public Token findToken(String input) throws Exception{
        return tokens.stream()
                .filter(t -> t.isMatching(input.substring(0,input.indexOf(" ") )))
                .findAny()
                .orElseThrow(()->new Exception(""));
    }
}