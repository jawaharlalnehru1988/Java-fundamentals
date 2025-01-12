package org.example.WrapperClassMethods;

public class StringMethods {
    public static void main(String[] args) {
        String str = "Hello World";

        // length() method returns the length of the string
//        System.out.println(str.length());

        // charAt() method returns the character at the specified index
//        System.out.println(str.charAt(0));
//
//        System.out.println(str.charAt(6));

        // substring() method returns a new string from start index to end index
//        System.out.println(str.substring(0, 5));

        // substring() method returns a new string from start index to the end of the string
//        System.out.println(str.substring(6));

        // indexOf() method returns the index of the first occurrence of the specified character
//        System.out.println(str.indexOf("o"));

        // lastIndexOf() method returns the index of the last occurrence of the specified character
//        System.out.println(str.lastIndexOf("o"));

        // indexOf() method returns the index of the first occurrence of the specified character after the specified index
//        System.out.println(str.indexOf("o", 5));

        // lastIndexOf() method returns the index of the last occurrence of the specified character before the specified index
//        System.out.println(str.lastIndexOf("o", 5));

        // startsWith() method returns true if the string starts with the specified prefix
//        System.out.println(str.startsWith("Hello"));

        // endsWith() method returns true if the string ends with the specified suffix
//        System.out.println(str.endsWith("World"));

        // contains() method returns true if the string contains the specified sequence of characters
//        System.out.println(str.contains("Hello"));

        // contains() method returns true if the string contains the specified sequence of characters
//        System.out.println(str.contains("World"));

        // equals() method returns true if the string is equal to the specified string
//        System.out.println(str.equals("Hello World"));

        // equalsIgnoreCase() method returns true if the string is equal to the specified string, ignoring case differences
//        System.out.println(str.equalsIgnoreCase("hello world"));

        // compareTo() method compares two strings lexicographically
//        System.out.println(str.compareTo("Hello World"));

        // compareToIgnoreCase() method compares two strings lexicographically, ignoring case differences
//        System.out.println(str.compareToIgnoreCase("hello world"));

        // replace() method replaces all occurrences of the specified character sequence with another character sequence
//        System.out.println(str.replace("World", "Java"));

        // toUpperCase() method converts all characters in the string to upper case
//        System.out.println(str.toUpperCase());

        // toLowerCase() method converts all characters in the string to lower case
//        System.out.println(str.toLowerCase());

        // trim() method removes leading and trailing white spaces
//        String str2 = "  Hello World  ";
//        System.out.println(str2);
//        System.out.println(str2.trim());

//        disadvantage of trim() method
//        String str6 = "\u2002Hello World\u2002";
//        System.out.println("Trimmed: [" + str6.trim() + "]"); // trailing white space is not removed

        // strip() method removes leading and trailing white spaces
//        String str5 = "  Hello World   ";
//        System.out.println(str5.length());
//        System.out.println(str5.strip());
//        System.out.println(str5.strip().length());

        // Advantage of strip() method over trim() method
//        String str7 = "\u2002Hello World\u2002";
//        System.out.println("Stripped: [" + str.strip() + "]"); // trailing white space is removed

        // concat() method concatenates the specified string to the end of the string
//        System.out.println(str.concat(" Java"));

        // concatenation using the + operator
//        System.out.println(str + " Java");

        // isEmpty() method returns true if the string is empty
//        String str3 = "";
//        System.out.println(str3.isEmpty());

        // isBlank() method returns true if the string is empty or contains only white spaces
//        String str4 = "";
//        System.out.println(str4.isBlank());

        // join() method joins the elements of the specified iterable with the specified delimiter
//        String[] array = {"Hello", "World"};
//        System.out.println(String.join(" ", array));

        // split() method splits the string around matches of the specified regular expression
//        String str8 = "Hello, World";
//        String[] parts = str8.split("");
//        System.out.println(Arrays.toString(parts));
//        for (String part : parts) {
//            System.out.println(part);
//        }

        // split() method splits the string around matches of the specified regular expression
//        String str9 = "Hello World";
//        String[] parts2 = str9.split(" ");
//        for (String part : parts2) {
//            System.out.println(part);
//        }

        // toCharArray() method converts the string to a character array
//        String str10 = "Hello World";
//        char[] chars = str10.toCharArray();
//        System.out.println(Arrays.toString(chars));
//        for (char ch : chars) {
//            System.out.println(ch);
//        }

        // valueOf() method converts the specified value to a string
//        int value = 10;
//        String str11 = String.valueOf(value);
//        System.out.println(str11);

        // getBytes() method encodes the string into a sequence of bytes using the platform's default charset
//        String str12 = "Hello World";
//        byte[] bytes = str12.getBytes();
//        for (byte b : bytes) {
//            System.out.println(b);
//        }

        // getChars() method copies characters from the string to the destination character array
//        String str13 = "Hello World";
////        char[] dest = new char[5];
////        str13.getChars(0, 5, dest, 0);
////        System.out.println(dest);

        // format() method formats the string using the specified format string and arguments
//        String str14 = "Hello";
//        String str15 = "World";
//        String formatted = String.format("%s %s", str14, str15);
//        System.out.println(formatted);

        // repeat() method returns a string whose value is the concatenation of the specified string repeated the specified number of times
//        String str16 = "Hello ";
//        String repeated = str16.repeat(3);
//        System.out.println(repeated);

        // stripLeading() method removes leading white spaces
//        String str17 = "  Hello World";
//        System.out.println(str17.stripLeading());

        // stripTrailing() method removes trailing white spaces
//        String str18 = "Hello World   ";
//        System.out.println(str18.stripTrailing());

//        String str19 = "Hello World";
//         CharSequence result = str19.subSequence(0, 5);
//        System.out.println(result);




    }
}
