package fengke.model.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ģʽ 
 * 
 * ������ ��Դ����԰
 * http://www.cnblogs.com/java-my-life/archive/2012/06/19/2552617.html
 * 
 * @author ���
 * 
 *  ��飺 
 *  
 *  ���壺
 *  �������Ե��ķ������ҽ���һ�������������͸������еľ��ӡ�
 *    
 *    ������ʽ(Expression)��ɫ��
 *         ����һ�����еľ�����ʽ��ɫ����Ҫʵ�ֵĳ���ӿڡ�����ӿ���Ҫ��һ��interpret()�������������Ͳ�����
 * 
 *         �� �ս�����ʽ(Terminal Expression)��ɫ��
 *         ʵ���˳�����ʽ��ɫ��Ҫ��Ľӿڣ���Ҫ��һ��interpret()������
 *         �ķ��е�ÿһ���ս������һ�������ս���ʽ��֮���Ӧ��������һ���򵥵Ĺ�ʽR=R1+R2��������R1��R2�����ս������Ӧ�Ľ���R1��R2�Ľ����������ս�����ʽ��
 * 
 *         �����ս�����ʽ(Nonterminal
 *         Expression)��ɫ���ķ��е�ÿһ��������Ҫһ������ķ��ս�����ʽ�����ս�����ʽһ�����ķ��е���������������ؼ���
 *         �����繫ʽR=R1+R2�У���+"���Ƿ��ս����������+���Ľ���������һ�����ս�����ʽ��
 * 
 *         ��������(Context)��ɫ�������ɫ������һ������������ķ��и����ս������Ӧ�ľ���ֵ������R=R1+R2�����Ǹ�R1��ֵ100��
 *         ��R2��ֵ200����Щ��Ϣ��Ҫ��ŵ�������ɫ�У��ܶ����������ʹ��Map���䵱������ɫ���㹻��
 */
public class InterpreterA {
	
	public static void main(String[] args) {
		Context ctx = new Context();
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Constant c = new Constant(true);
        ctx.assign(x, false);
        ctx.assign(y, true);
        
        Expression exp = new Or(new And(c,x) , new And(y,new Not(x)));
        System.out.println("x=" + x.interpret(ctx));
        System.out.println("y=" + y.interpret(ctx));
        System.out.println(exp.toString() + "=" + exp.interpret(ctx));

	}

}
abstract class Expression {
    /**
     * �Ի���Ϊ׼�����������͸������κ�һ�����ʽ
     */
    public abstract boolean interpret(Context ctx);
    /**
     * �����������ʽ�ڽṹ���Ƿ���ͬ
     */
    public abstract boolean equals(Object obj);
    /**
     * ���ر��ʽ��hash code
     */
    public abstract int hashCode();
    /**
     * �����ʽת�����ַ���
     */
    public abstract String toString();
}
class Constant extends Expression{
    
    private boolean value;

    public Constant(boolean value){
        this.value = value;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(obj != null && obj instanceof Constant){
            return this.value == ((Constant)obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {
        
        return value;
    }

    @Override
    public String toString() {
        return new Boolean(value).toString();
    }
    
}
class Variable extends Expression {

    private String name;

    public Variable(String name){
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        
        if(obj != null && obj instanceof Variable)
        {
            return this.name.equals(
                    ((Variable)obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean interpret(Context ctx) {
        return ctx.lookup(this);
    }

}
class And extends Expression {

    private Expression left,right;
    
    public And(Expression left , Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof And)
        {
            return left.equals(((And)obj).left) &&
                right.equals(((And)obj).right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {
        
        return left.interpret(ctx) && right.interpret(ctx);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " AND " + right.toString() + ")";
    }

}
 class Or extends Expression {
    private Expression left,right;

    public Or(Expression left , Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Or)
        {
            return this.left.equals(((Or)obj).left) && this.right.equals(((Or)obj).right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {
        return left.interpret(ctx) || right.interpret(ctx);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " OR " + right.toString() + ")";
    }

}
class Not extends Expression {

	    private Expression exp;
	    
	    public Not(Expression exp){
	        this.exp = exp;
	    }
	    @Override
	    public boolean equals(Object obj) {
	        if(obj != null && obj instanceof Not)
	        {
	            return exp.equals(
	                    ((Not)obj).exp);
	        }
	        return false;
	    }

	    @Override
	    public int hashCode() {
	        return this.toString().hashCode();
	    }

	    @Override
	    public boolean interpret(Context ctx) {
	        return !exp.interpret(ctx);
	    }

	    @Override
	    public String toString() {
	        return "(Not " + exp.toString() + ")";
	    }

	}
class Context {

    private Map<Variable,Boolean> map = new HashMap<Variable,Boolean>();
    
    public void assign(Variable var , boolean value){
        map.put(var, new Boolean(value));
    }
    
    public boolean lookup(Variable var) throws IllegalArgumentException{
        Boolean value = map.get(var);
        if(value == null){
            throw new IllegalArgumentException();
        }
        return value.booleanValue();
    }
}