interface Printable{
    void print();
    interface Showable{
        void msg();
    }
}

class A7 implements Printable,Printable.Showable{

    public void print(){System.out.println("Hello");}
    public void msg(){System.out.println("Welcome");}

    public static void main(String args[]){
        A7 obj = new A7();
        obj.print();
        obj.msg();
    }
}  