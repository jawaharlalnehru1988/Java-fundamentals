package org.example.Concepts;

public class StringBuffering {
    public static void main(String[] args) {
        // Create a StringBuffer
        StringBuffer stringBuffer = new StringBuffer();

        // Append elements
        stringBuffer.append("Java");
        stringBuffer.append(" Python");
        stringBuffer.append(" JavaScript");
        stringBuffer.append(" Ruby");

        // Print the StringBuffer
        System.out.println(stringBuffer);

//        // Remove elements
//        stringBuffer.delete(4, 8);
//        System.out.println(stringBuffer);

//        // Insert elements
//        stringBuffer.insert(4, "Python");
//        System.out.println(stringBuffer);
//
//        // Replace elements
//        stringBuffer.replace(4, 10, "Python");
//        System.out.println(stringBuffer);
//
//        // Reverse the StringBuffer
//        stringBuffer.reverse();
//        System.out.println(stringBuffer);
//
//        // Get the length of the StringBuffer
//        System.out.println(stringBuffer.length());
//
//        // Get the capacity of the StringBuffer
//        System.out.println(stringBuffer.capacity());
//
//        // Set the length of the StringBuffer
//        stringBuffer.setLength(10);
//        System.out.println(stringBuffer);
//
//        // Ensure the capacity of the StringBuffer
//        stringBuffer.ensureCapacity(20);
//        System.out.println(stringBuffer);
//
//        // Trim the capacity of the StringBuffer
//        stringBuffer.trimToSize();
//        System.out.println(stringBuffer);
//
//        // Get the character at a given index
//        System.out.println(stringBuffer.charAt(4));
//
//        // Get the index of a given character
//        System.out.println(stringBuffer.indexOf("Python"));
//
//        // Get the last index of a given character
//        System.out.println(stringBuffer.lastIndexOf("Python"));
//
//        // Get the substring of a given string
//        System.out.println(stringBuffer.substring(4, 10));
//
//        // Convert the StringBuffer to a String
//        String str = stringBuffer.toString();
//        System.out.println(str);
//
//        // Clear the StringBuffer
//        stringBuffer.delete(0, stringBuffer.length());
//        System.out.println(stringBuffer);
    }
}
