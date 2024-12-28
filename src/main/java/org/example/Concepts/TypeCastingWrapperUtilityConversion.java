package org.example.Concepts;

public class TypeCastingWrapperUtilityConversion {
    public static void main(String[] args) {
        //Implicit Type Casting between primitives
//        int i = 100;
//        long l = i;
//        float f = l;
//        double d = f;
//        System.out.println("Implicit Type Casting");
//        System.out.println("Int value: " + i);
//        System.out.println("Long value: " + l);
//        System.out.println("Float value: " + f);
//        System.out.println("Double value: " + d);
//
//        //Explicit Type Casting
//        double d1 = 100.04;
//        long l1 = (long) d1;
//        int i1 = (int) l1;
//        System.out.println("Explicit Type Casting");
//        System.out.println("Double value: " + d1);
//        System.out.println("Long value: " + l1);
//        System.out.println("Int value: " + i1);

        // Parsing string to primitive
//        String str = "123";
//        int num = Integer.parseInt(str);
//        System.out.println("String value: " + str);

        // Parsing string to wrapper class
//        String str = "123";
//        Integer num = Integer.valueOf(str);
//        System.out.println("String value: " + str);

        // Converting primitive to string
//          int num = 123;
//            String str = String.valueOf(num);
//            System.out.println("String value: " + str);

        // Converting wrapper class to string
//        Integer num = 123;
//        String str = num.toString();
//        System.out.println("String value: " + str);

        // Converting string to double (primitive string value to primitive double)
//        String str = "123.45";
//        double num = Double.parseDouble(str);
//        System.out.println("Double value: " + num);
//
//        // Converting string to double (primitive string value to wrapper Double)
//        String str1 = "123.45";
//        Double num1 = Double.valueOf(str1);
//        System.out.println("Double value: " + num1);

        // Converting double to string (primitive double value to primitive string)
//        double num = 123.45;
//        String str = String.valueOf(num);
//        System.out.println("String value: " + str);

        // Converting double to string (primitive double value to wrapper String)
//        double num = 123.45;
//        String str = Double.toString(num);
//        System.out.println("String value: " + str);

        // Converting string to boolean (primitive string value to primitive boolean)
//        String str = "true";
//        boolean bool = Boolean.parseBoolean(str);
//        System.out.println("Boolean value: " + bool);

        // Converting string to boolean (primitive string value to wrapper Boolean)
//        String str = "true";
//        Boolean bool = Boolean.valueOf(str);
//        System.out.println("Boolean value: " + bool);

        // Converting boolean to string (primitive boolean value to primitive string)
//        boolean bool = true;
//        String str = String.valueOf(bool);
//        System.out.println("String value: " + str);

        // Converting Boolean to string (Wrapper Boolean value to wrapper String)
//        Boolean bool = true;
//        String str = bool.toString();
//        String str = Boolean.toString(bool);
//        System.out.println("String value: " + str);

            // Converting string to char (primitive string value to primitive char)
//        String str = "a";
//        char ch = str.charAt(0);
//        System.out.println("Char value: " + ch);

        // Converting char to string (primitive char value to primitive string)
//        char ch = 'a';
//        String str = String.valueOf(ch);
//        System.out.println("String value: " + str);

        // Converting string to char (primitive string value to wrapper Character)
//        String str = "a";
//        char ch = str.charAt(0);
//        Character character = ch;
//        System.out.println("Character value: " + character);

    // Converting string float to primitive float
//        String str = "123.45";
//        float num = Float.parseFloat(str);
//        System.out.println("Float value: " + num);

        // Converting string float to wrapper Float
//        String str = "123.45";
//        Float num = Float.valueOf(str);
//        System.out.println("Float value: " + num);

        // Converting primitive float to string
//        float num = 123.45f;
//        String str = String.valueOf(num);
//        System.out.println("String value: " + str);

        // Converting wrapper Float to string
//        Float num = 123.45f;
//        String str = num.toString();
//        System.out.println("String value: " + str);

        // Converting string to byte (primitive string value to primitive byte)
//        String str = "123";
//        byte num = Byte.parseByte(str);
//        System.out.println("Byte value: " + num);

        // Converting string to byte (primitive string value to wrapper Byte)
//        String str = "123";
//        Byte num = Byte.valueOf(str);
//        System.out.println("Byte value: " + num);

        // Converting primitive byte to string
//        byte num = 123;
//        String str = String.valueOf(num);
//        System.out.println("String value: " + str);

        // Converting wrapper Byte to string
//        Byte num = 123;
//        String str = num.toString();
//        System.out.println("String value: " + str);

        // Converting string to short (primitive string value to primitive short)
//        String str = "123";
//        short num = Short.parseShort(str);
//        System.out.println("Short value: " + num);

        // Converting string to short (primitive string value to wrapper Short)
//        String str = "123";
//        Short num = Short.valueOf(str);
//        System.out.println("Short value: " + num);

        // Converting primitive short to string
//        short num = 123;
//        String str = String.valueOf(num);
//        System.out.println("String value: " + str);

        // Converting wrapper Short to string
//        Short num = 123;
//        String str = num.toString();
//        System.out.println("String value: " + str);

        // Converting string to long (primitive string value to primitive long)
//        String str = "123";
//        long num = Long.parseLong(str);
//        System.out.println("Long value: " + num);

        // Converting string to long (primitive string value to wrapper Long)
//        String str = "123";
//        Long num = Long.valueOf(str);
//        System.out.println("Long value: " + num);

        // Converting primitive long to string
//        long num = 123;
//        String str = String.valueOf(num);
//        System.out.println("String value: " + str);

        // Converting wrapper Long to string
//        Long num = 123L;
//        String str = num.toString();
//        System.out.println("String value: " + str);


//        comparison of primitives
        int i = 100;
        long l = 100;
        System.out.println(i == l);
        System.out.println(i == 100);

        Integer inte = Integer.compare(10, 100);
        System.out.println(inte);



            }
}
