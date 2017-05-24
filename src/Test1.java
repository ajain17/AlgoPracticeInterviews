
class Test1{
    void m(){
        System.out.println(this);//prints same reference ID
    }

    public static void main(String args[]){
        Test1 obj=new Test1();
        System.out.println("id" + obj);//prints the reference ID

        obj.m();
        Test1 obj2=new Test1();
        System.out.println("id" + obj2);//prints the reference ID

        obj2.m();


    }
}