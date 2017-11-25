public class ReturnException extends RuntimeException {

	public Value retVal;

    public ReturnException(Value v) {
    	retVal = v;
    }

}