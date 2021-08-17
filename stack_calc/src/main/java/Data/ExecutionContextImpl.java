package data;

import java.util.*;
import consts.*;
public class ExecutionContextImpl implements ExecutionContext
{
    public Stack<Object> stack_;
    public Map<String, Double> definedValues_;
    public ExecutionContextImpl()
    {
        stack_ = new Stack<Object>();
        definedValues_ = new HashMap<String, Double>();
    }
    @Override
    public void push(Object argument)
    {
        stack_.push(argument);
    }

    @Override
    public Object pop() {
        Object value;
        if(stack_.empty()) {
            return null;
        }
        value = stack_.pop();
        return value;
    }

    @Override
    public void define(Object[] arguments)
    {
        String valueName = arguments[UsefulConsts.VALUE_NAME_INDEX].toString();
        String valueString = arguments[UsefulConsts.VALUE_INDEX].toString();
        Double value = definedValues_.get(valueString);
        if(value == null) {
            value = Double.valueOf(valueString);
        }
        definedValues_.put(valueName, value);
    }
    @Override
    public Object getDefinedValue(String name)
    {
        Object result = null;
        result = definedValues_.get(name);
        return result;
    }
    @Override
    public Object[] getTopElements(int elementsNumber) throws java.lang.NumberFormatException
    {
         String valueString;
         Double value;
         Double[] result = new Double[elementsNumber];
         if(stack_.empty() || stack_.size() < elementsNumber)
         {
             return null;
         }
        for(int i = 0; i < elementsNumber; i++)
        {
            valueString = stack_.pop().toString();
            value = (Double)this.getDefinedValue(valueString);
            if(value == null)
            {
                try
                {
                    value = Double.valueOf(valueString);
                }
                catch(java.lang.NumberFormatException formatEx)
                {
                    throw formatEx;
                }
            }
            result[i] = value;
        }
        return result;
    }
    @Override
    public int getDataElementsNumber()
    {
        return this.stack_.size();
    }

    @Override
    public Object peek()
    {
        Object value;
        if(stack_.empty()) {
            return null;
        }
        value = stack_.peek();
        return value;
    }

    @Override
    public void clear()
    {
        stack_.clear();
        definedValues_.clear();
    }
}
