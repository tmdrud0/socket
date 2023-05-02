package manager;

public class Manager {
    Tokens tokenManager;
    Object object;
    public Manager(Tokens tokenManager, Object object){
        this.tokenManager = tokenManager;
        this.object = object;
    }
    public String work(String input){
        String result="";
        try {
            Token curToken = tokenManager.findToken(input);
            result = (String)curToken.getMethod().invoke(object, curToken.makeArgs(input));
        } catch (Exception e) {
            System.out.println(object.getClass().getName()+"실행오류");
            result = object.getClass().getName() + "실행오류";
        }
        return result;
    }
}