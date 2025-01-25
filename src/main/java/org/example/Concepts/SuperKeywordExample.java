package org.example.Concepts;

class Parents{

    String parentMessage;
    void display(){
        System.out.println("Display method in parent class");
    }
    String names = "shanmuka";

    Parents(String message){
        System.out.println(message);
        parentMessage = message + ": Message is received";
    }
}

 class SuperKeywordExample extends Parents {

    @Override
    void display(){
        System.out.println("Display method in child class");
    }

    void show(){
        super.display();
    }
    String names = "shiva gurunathan";

    void displayNames(){
        System.out.println("child name: " + names);
        System.out.println("parent name: " + super.names);
    }

    SuperKeywordExample(String msg){
        super(msg);
    }

}

 class SuperExecution{

     public static void main(String[] args) {
         SuperKeywordExample sup = new SuperKeywordExample("My message to");
         sup.display();
         sup.show();
         sup.displayNames();
         System.out.println(sup.parentMessage);
     }
}
