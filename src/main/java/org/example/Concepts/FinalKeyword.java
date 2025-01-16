package org.example.Concepts;

 class FinalKeyword {
    final int Max_value = 100;

  final void display(){
        System.out.println("Max Value " + Max_value);
    }

    void display(final int value){
        System.out.println( value + 200);
    }
}

class Someclass {
    public static void main(String[] args) {

        FinalKeyword finalKeyword = new FinalKeyword();

         finalKeyword.display();
         finalKeyword.display(200);
    }
}