package data;

public interface ExecutionContext
{
    void push(Object arguments);
    Object pop();
    void define(Object[] arguments);
    public Object getDefinedValue(String value);
    Object[] getTopElements(int elementsNumber)  throws java.lang.NumberFormatException;
    int getDataElementsNumber();
    Object peek();
    void clear();
}
