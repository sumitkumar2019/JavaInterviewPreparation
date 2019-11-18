package com.sky.java.preparation.String;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/***
 * ==============
 * String Class
 * ==============
 * ---------------------------------------------------------------------------------------
 * 1. An object represents Sequence of characters
 * 2. Implements CharSequence, Serializable and Comparable
 * 3. String is thread safe in java because it is immutable
 *---------------------------------------------------------------------------------------
 *
 *                                      Some Important Points about String

 *         /*----------------------------------------------------------------------------------------*
 *             Why String is Immutable in java? : Reusability(Sharing) , Security & Thread Safety
 *         /*----------------------------------------------------------------------------------------*
 *             #1. String Pool: reusablity and secure sharing of String literals from String pool.
 *             #2. Used as Parameters: Database urls, file name.
 *             #3. Class Loading: During class loading, class name are used as String.
 *             #4. Thread Safety
 *             #5. caching its hashcode: Hash Map recommendation to use String objects as keys.
 *
 *         /*------------------------------------------------------------------------------*
 *             Why Character array is better than String for storing password in Java? - Reference: Java Revisited
 *         /*------------------------------------------------------------------------------*
 *             Since Strings are immutable in Java if you store password as plain text, it will be available in memory until Garbage collector clears it
 *             and since String are used in String pool for re-usability there is pretty high chance that it will be remain in memory for long duration,
 *             which pose a security threat. Since any one who has access to memory dump can find the password in clear text and that's another reason
 *             you should always used an encrypted password than plain text. Since Strings are immutable there is no way contents of Strings can be changed
 *             because any change will produce new String, while if you char[] you can still set all his element as blank or zero. So Storing password in character
 *             array clearly mitigates security risk of stealing password. Java itself recommends using getPassword() method of JPasswordField which returns a char[]
 *             and deprecated getText() method which returns password in clear text stating security reason. Its good to follow advice from Java team and adhering to
 *             standard rather than going against it.
 *
 *        /*----------------------------------------------------------------------------------*
 *             What is string constant pool? Difference in String pool between Java 6 and 7
 *         /*----------------------------------------------------------------------------------*
 *                 To minimize the redundancy and memory waste/overuse caused by storing String objects with duplicate values
 *                 on the heap Java Created a special area on the Heap memory called String Constant Pool. It is created using
 *                 HashMap in Java.
 *
 *                  a. String objects created without the use of new keyword are stored in the String Constant Pool part of the heap.
 *                  b. String objects created using new keyword are stored in the normal memory part on the heap.
 *
 *              --------------------------
 *              Before Jdk 7 or till Jdk 6
 *              --------------------------
 *                 Before JDk 7, String Constant pool was placed inside PermGen space of JVM memory,
 *                 which was a fixed size area for storing class metadata. The biggest issue of having String pool
 *                 in PermGen is the small and fixed size of PermGen space.
 *                 In some JVM it ranges from 32M to 96M, which is quite small for a large program.
 *                 Since String is extensively used in both small and large Java application,
 *                 Java designers thought String pool is the best way optimize the use of String object in Java.
 *
 *              --------------------------
 *              After Jdk 7 or till Jdk 6
 *              --------------------------
 *                 #1. String pool is relocated to Java heap space from PermGen space.
 *                 #2. The default size of String pool is increased to 600013 entries from 1009 in Java 6.
 *                 #3. The -XX:StringTableSize JVM option is provided to specify the size of String pool.
 *
 * ---------------------------------------------------------------------------------------
 * */
public class StringBasics {

    private enum LOAN {
        HOME_LOAN {
            @Override
            public String toString() {
                return "Always look for cheaper Home loan";

            }
        },
        AUTO_LOAN {
            @Override
            public String toString() {
                return "Cheaper Auto Loan is better";
            }
        },
        PEROSNAL_LOAN{
            @Override
            public String toString() {
                return "Personal loan is not cheaper any more";
            }
        }
    }

    public static void main(String[] args) throws ParseException, UnsupportedEncodingException {

        /**
         * -----------------------------------
         * Two ways to Create a String
         * -----------------------------------
         */

        /** 1. By Using String Literals */
            String stringLiteral = "Hello World";

        /** 2. By Using new Keyword */
            String StringObject = new String("Hello World");


         /*--------------------------------------------*/
         /* String Constant pool and memory management */
         /*--------------------------------------------*/

        String s1 = "Welcome"; // It will create a new String instance and place it in the string constant pool
        String s2 = "Welcome"; //It will not create new instance, it will use the same instance created by s1 in the String Constant pool
        String s3 =new String("Welcome"); // it will create a new instance of String anf place that object into heap + string constant pool

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1==s3);
        System.out.println(s3==s2);
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s3));

        /*---------------------------------------------------------*/
        /* Converting char array to String & String array to char */
        /*--------------------------------------------------------*/

        char ch[]={'s','t','r','i','n','g','s'};
        String s4=new String(ch);
        System.out.println(s4);
        char ch2[] = s4.toCharArray();
        System.out.println(ch2);

        /*--------------------------------------*
                Substring Examples
        *--------------------------------------*/

        String s5 = "unhappy".substring(2);
        System.out.println(s5);

        /*---------------------------------------------------------*
            How substring works in Java?
        /*---------------------------------------------------------*
                   -----------
                    substring
                   -----------

                    #1 . substring is an overloaded method in String Class.
                    #2 . One version of substring has parameter beginIndex and it returns part of String started from beginIndex till end,
                         while other takes two parameters, beginIndex and endIndex, and returns part  of String starting from beginIndex to endIndex-1.
                    #3 . Every time when we call  substring() method in Java, it will return a new String because String is immutable in Java.

                   --------------------------------------
                    substring Internal Implementation: 1
                   --------------------------------------

                    public String substring(int beginIndex) {
                        if (beginIndex < 0) {
                            throw new StringIndexOutOfBoundsException(beginIndex);
                        }
                        int subLen = value.length - beginIndex;
                        if (subLen < 0) {
                            throw new StringIndexOutOfBoundsException(subLen);
                        }
                        return (beginIndex == 0) ? this : new String(value, beginIndex, subLen);
                    }

                   --------------------------------------
                    substring Internal Implementation: 2
                   --------------------------------------

                    public String substring(int beginIndex, int endIndex) {
                        if (beginIndex < 0) {
                            throw new StringIndexOutOfBoundsException(beginIndex);
                        }
                        if (endIndex > value.length) {
                            throw new StringIndexOutOfBoundsException(endIndex);
                        }
                        int subLen = endIndex - beginIndex;
                        if (subLen < 0) {
                            throw new StringIndexOutOfBoundsException(subLen);
                        }
                        return ((beginIndex == 0) && (endIndex == value.length)) ? this
                                : new String(value, beginIndex, subLen);
                    }


                    ---------------------------------------------------
                    Memory Leak Problem caused by substring() in JDK 6 : Referenced:https://www.geeksforgeeks.org/java-substring-method-memory-leak-issue-and-fix/
                    ---------------------------------------------------

                    This method works well with small Strings. but when it comes with taking substring() from a String with more characters,
                    it leads to serious memory issues if you are using JDK 6 or below.


                    Example:

                    String bigString = new String(new byte[100000]);

                    The above String already occupies a lot of memory in heap. Now consider the scenario where we need first 2 characters from bigString,

                    String substr = bigString.substring(0, 2)

                    Now we don’t need the original String.

                    bigString = null

                    We might think that bigString object will be Garbage collected as we made it null but our assumption is wrong.
                    When we call substring(), a new String object is created in memory.
                    But still it refers the char[] array value from original String.
                    This prevents bigString from Garbage collection process and we are unnecessarily storing 100000 bytes in memory (just for 2 characters).

                    BUG Details: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=6294060

                    --------------------------------------
                    Handling substring() in JDK 6
                    --------------------------------------

                    If we still use JDK6 then this issue should be handled by developers.
                    One option is creating new String object from substring returned String.

                    String substr = new String(bigString.substring(0, 2));

                    Now, new String object is created in java heap, having its own char[] array, eventually original bigString will eligible for garbage collection process.
                    Other option is, call intern() method on substring, which will then fetch an existing string from pool or add it if necessary.

                    String substr = bigString.substring(0, 2).intern()


                    --------------------------------------
                    Fix for substring() in JDK 7
                    --------------------------------------

                    When we invoke substring() in JDK 7, instead of referring char[] array from original String, jvm creates new String objects with its own char[] array.

                        //JDK 7
                        public String(char value[], int offset, int count) {
                            //check boundary
                            this.value = Arrays.copyOfRange(value, offset, offset + count);
                        }

                        public String substring(int beginIndex, int endIndex) {
                            //check boundary
                            int subLen = endIndex - beginIndex;
                            return new String(value, beginIndex, subLen);
                        }

        /*-------------------------------------------------------------*
            How to replace String in java using regular expression?
        /*-------------------------------------------------------------*
            There are 4 variants of replace() method in String
            #1. replace(char oldch, char newch): This method returns a new string resulting from replacing all occurrences of old characters in the string with new characters.
            #2. replace(CharSequence target, CharSequence replacement): This String replace method replaces one character sequence with other.
            #3. replaceAll(String regex, String replace_str) :This method replaces each substring of the string that matches the given regular expression with the given replace_str.
            #4. replaceFirst(String regex, String replace_str) :This method replaces the first substring of this string that matches the given regular expression with the given replace_str.
        /*-------------------------------------------------------------*/

        String replaceSampleCase1 = "This String replace Example shows how to replace one char from String";
        String newString1 = replaceSampleCase1.replace('r', 't');
        System.out.println(newString1);

        String replaceSampleCase2 = "String replace Example of replacing Character Sequence";
        String newString2 = replaceSampleCase2.replace("re", "RE");
        System.out.println(newString2);

        String replaceSampleCase3 = "String replace Example with regular expression";
        String newString3 = replaceSampleCase3.replaceAll("^S","R");
        System.out.println(newString3);

        String replaceSampleCase4 = "String replace Example with replaceFirst";
        String newString4 = replaceSampleCase4.replaceFirst("re","RE");
        System.out.println(newString4);


        /*------------------------------------------------------------------------------*
            How to convert String into Integer and Integer into String in Java?
        /*------------------------------------------------------------------------------*/
            String s6 = "200";
            Integer i=Integer.valueOf(s6);
            int x = Integer.parseInt(s6);
            System.out.println(i);
            System.out.println(x);

            String s7 = String.valueOf(x);
            String s8 = Integer.toString(x);
            String s9 = String.format("%d",i);
            System.out.println(s7);
            System.out.println(s8);
            System.out.println(s9);

        /*------------------------------------------------------------------------------*
               How to split String with examples in Java? Different Ways
        /*------------------------------------------------------------------------------*/

            //Using Split() method
            String s10 = "Apple:Ball:Cat:Dog:Elephant";
            String[] splits = s10.split(":");
            System.out.println("splits.size: " + splits.length);
            for(String s: splits){
                System.out.println(s);
            }

            //Using StringTokenizer
            StringTokenizer stringtokenizer = new StringTokenizer(s10, ":");
            while (stringtokenizer.hasMoreElements()) {
                System.out.println(stringtokenizer.nextToken());
            }

        /*------------------------------------------------------------------------------*
            How to compare two String in Java?
                equals(): compare content
                compareTo(): compare two strings lexicographically
                equalsIgnoreCase(): compare content (Not Case Sensitive)
                compareToIgnoreCase(): compare two strings lexicographically (Not Case Sensitive)
        /*------------------------------------------------------------------------------*/

        String tv = "Bravia";
        String television = "Bravia";

        // String compare example using equals
        if (tv.equals(television)) {
            System.out.println("Both tv and television contains same letters and equal by equals method of String");
        }

        // String compare example in java using compareTo
        if (tv.compareTo(television) == 0) {
            System.out.println("Both tv and television are equal using compareTo method of String");
        }

        television = "BRAVIA";

        // Java String comparison example using equalsIgnoreCase
        if (tv.equalsIgnoreCase(television)) {
            System.out.println("tv and television are equal by equalsIgnoreCase method of String");
        }

        // String comparison example in java using CompareToIgnoreCase
        if (tv.compareToIgnoreCase(television) == 0) {
            System.out.println("tv and television are same by compareToIgnoreCase of String");
        }

        String sony = "Sony";
        String samsung = "Samsung";

        // lexicographical comparison of String in Java with ComapreTo
        if (sony.compareTo(samsung) > 0) {
            System.out.println("Sony comes after Samsung in lexicographical order");
        } else if (sony.compareTo(samsung) < 0) {
            System.out.println("Sony comes before Samsung in lexicographical order");
        }


        /*--------------------------------------------------------------------------------------------------------------*
            What code is written by the compiler if you concatenate any string by + (string concatenation operator)? - Reference: JavaTPoint
        /*--------------------------------------------------------------------------------------------------------------*
                In java, String concatenation is implemented through the StringBuilder (or StringBuffer) class and its append method.
                String concatenation operator produces a new string by appending the second operand onto the end of the first operand.

                Example: */

                String s11="Sachin"+" Tendulkar";
                System.out.println(s11);

                /* Internally Java Compiler Convert the above code in to */

                String s13=(new StringBuilder()).append("Sachin").append(" Tendulkar").toString();
                System.out.println(s13);

                /* The string concatenation operator can concat not only string but primitive values also.

                Example: */

                String s12=50+30+"Sachin"+40+40;
                System.out.println(s12);

        /*------------------------------------------------------------------------*
            How to parse String to Enum in Java? : Override toString() method
        /*------------------------------------------------------------------------*
            private enum LOAN {
                HOME_LOAN {
                    @Override
                    public String toString() {
                        return "Always look for cheaper Home loan";

                    }
                },
                AUTO_LOAN {
                    @Override
                    public String toString() {
                        return "Cheaper Auto Loan is better";
                    }
                },
                PEROSNAL_LOAN{
                    @Override
                    public String toString() {
                        return "Personal loan is not cheaper any more";
                    }
                }
            }
            public static void main(String[] args) {

            ------ see Above code just after class definition on the top
         */

            LOAN homeLoan = LOAN.valueOf("HOME_LOAN");
            System.out.println(homeLoan);

            LOAN autoLoan = LOAN.valueOf("AUTO_LOAN");
            System.out.println(autoLoan);

            LOAN personalLoan = LOAN.valueOf("PEROSNAL_LOAN");
            System.out.println(personalLoan);

         /*--------------------------------------------------------------------------------*
            How to convert String into Double in Java and Double to String in java?
         /*--------------------------------------------------------------------------------*/

         //String to Double
             String s15 = "10.20";

             Double stringConvertedToDouble1 = Double.parseDouble(s15);
             Double stringConvertedToDouble2 = Double.valueOf(s15);

             System.out.println(stringConvertedToDouble1);
             System.out.println(stringConvertedToDouble2);

            // Double to String
            String s16 = ""+stringConvertedToDouble1;
            String s17 = String.valueOf(stringConvertedToDouble1);
            String s18 = stringConvertedToDouble1.toString();
            String s19 = String.format("%3f",stringConvertedToDouble1);

            System.out.println(s16);
            System.out.println(s17);
            System.out.println(s18);
            System.out.println(s19);

        /*----------------------------------------*
            How to format String in Java?

             Formatted String is a String which not only displays contents but also displays it in a format which is widely accepted like eg. including comma

             In Jdk1.5, two convenient api ways are defined : difference between two are below:
             #1. printf() in PrintStream Class: it writes to stdout.
             #2. format() in String class: it returns a formatted String

             String.format "%[argument number] [flags] [width] [.precision] type"
             eg: format ( "%,6.2f", 124.000)
             , - flag
             6- width
             .2 - precision
             f - type
         */
        /*----------------------------------------*/
            System.out.printf("%8.3f %n", Math.E);
            String s20 = String.format("%8.3f %n", Math.E);
            System.out.println(s20);

            String s21 = String.format("Today is %tD", new Date());
            System.out.println(s21);

            Date today = new Date();
            System.out.printf("Date in dd/mm/yy format %td/%tm/%ty %n", today,today,today );

        /*---------------------------------------------------------------------------------------------------*
            How to create comma separated String from Collection in Java? : String.join(delimiter, array)
        /*------------------------------------------------------------------------------------------------*/
            List<String> list = new ArrayList<>();
            list.add("apple");
            list.add("ball");
            list.add("cat");
            list.add("dog");

            String[] array = list.toArray(new String[0]);
            String s22 = String.join(",", array);
            System.out.println(s22);
            System.out.println(Arrays.toString(array));

        /*-----------------------------------------------*
            What does intern() method do in Java?
        /*------------------------------------------------*
            intern() is a native method. When the intern() method is invoked on a String object,
            if the String Pool already has a String with the same value, then the reference of String from the Pool is returned.
            Otherwise, this string object is added to the pool and the reference is returned.

            Example:
         */

            String s23 = new String("abc"); // created inside Heap Memory
            String s24 = "abc"; // created inside String Pool
            String s25 = "abc"; // created inside String Pool

            System.out.println("s23==s24? " + (s23 == s24)); // should be false
            System.out.println("s24==s25? " + (s24 == s25)); // should be true

            // call intern() method on s23
            s23 = s23.intern(); // this should return the String with same value, BUT from String Pool

            System.out.println("s23==s24? " + (s23 == s24)); // should be true now

        /*---------------------------------------------------------------------------*
            How to convert Date to String and String to Date in Java?
        /*---------------------------------------------------------------------------*/

            //Date to String

            Date dateNow = new Date();
            SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat dateformatddMMyyyy = new SimpleDateFormat("ddMMyyyy");
            SimpleDateFormat dateformatddMMyyyyWithDelimiter1 = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat dateformatddMMyyyyWithDelimiter2 = new SimpleDateFormat("dd/MM/yyyy");
            String dateToString = dateformatyyyyMMdd.format(dateNow);
            System.out.println(dateToString);
            dateToString = dateformatddMMyyyy.format(dateNow);
            System.out.println(dateToString);
            dateToString = dateformatddMMyyyyWithDelimiter1.format(dateNow);
            System.out.println(dateToString);
            dateToString = dateformatddMMyyyyWithDelimiter2.format(dateNow);
            System.out.println(dateToString);

            String dateString = dateformatddMMyyyyWithDelimiter2.format(dateNow);

            // String to Date
            Date dateToday=new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
            System.out.println(dateToday);

        /*---------------------------------------------------------*/
        /*          String in Switch cases                        */
        /*-------------------------------------------------------*/

            String str = "two";
            switch(str)
            {
                case "one":
                    System.out.println("one");
                    break;
                case "two":
                    System.out.println("two");
                    break;
                case "three":
                    System.out.println("three");
                    break;
                default:
                    System.out.println("no match");
            }

        /*---------------------------------------------------------*/
        /*          String class method and its uses              */
        /*-------------------------------------------------------*/

        // 1. public char charAt(int index) : returns a char value at the given index number

        String name="sumit kumar";
        char chr=name.charAt(4);
        System.out.println(chr);

        // 2. public int compareTo(String anotherString) :

        // compares the given string with current string lexicographically. It returns positive number, negative number or 0.
            //It compares strings on the basis of Unicode value of each character in the strings.
            //If first string is lexicographically greater than second string, it returns positive number (difference of character value).
            // If first string is less than second string lexicographically, it returns negative number and
            // if first string is lexicographically equal to second string, it returns 0.

            String s26="hello";
            String s27="hello";
            String s28="meklo";
            String s29="hemlo";
            String s30="flag";
            System.out.println(s26.compareTo(s27));
            System.out.println(s26.compareTo(s28));
            System.out.println(s26.compareTo(s29));
            System.out.println(s26.compareTo(s30));

        // 3. public String concat(String anotherString): combines specified string at the end of this string. It returns combined string.

        String s31="java string";
        System.out.println(s31.concat("is immutable"));

        // 4. public boolean contains(CharSequence sequence):
        // searches the sequence of characters in this string.
        // It returns true if sequence of char values are found in this string otherwise returns false

        String s32="what do you know about me";
        System.out.println(s32.contains("do you know"));
        System.out.println(s32.contains("about"));
        System.out.println(s32.contains("hello"));

        // 5. public boolean endsWith(String suffix):checks if this string ends with given suffix. It returns true if this string ends with given suffix else

        String s33="java revisited";
        System.out.println(s33.endsWith("d"));
        System.out.println(s33.endsWith("revisited"));

       //6.getBytes(): returns the byte array of the string. In other words, it returns sequence of bytes
        /* 3 variants of getBytes()
        public byte[] getBytes()
        public byte[] getBytes(Charset charset)
        public byte[] getBytes(String charsetName)throws UnsupportedEncodingException
        */

        String s34="ABCDEFG";
        byte[] barr=s34.getBytes();
        byte[] barr1=s34.getBytes("UTF-8");
        byte[] barr2=s34.getBytes(Charset.forName("ASCII"));
        for(int j=0;j<barr.length;j++){
            System.out.print(barr[j]+" "); //65 66 67 68 69 70 71
        }
        System.out.println();
        for(int j=0;j<barr1.length;j++){
            System.out.print(barr1[j]+" "); //65 66 67 68 69 70 71
        }
        System.out.println();
        for(int j=0;j<barr2.length;j++){
            System.out.print(barr2[j]+" "); //65 66 67 68 69 70 71
        }
        System.out.println();

        //7.getChars(): returns copies the content of this string into specified char array
        // public void getChars(int srcBeginIndex, int srcEndIndex, char[] destination, int dstBeginIndex)

        String s35 = new String("hello how r u today");
        char[] chrr = new char[10];
        s35.getChars(6, 16, chrr, 0);
        System.out.println(chrr);

        //8.getChars(): returns index of given character value or substring. If it is not found, it returns -1. The index counter starts from zero.
        /*
            There are 4 variants:
                int indexOf(int ch)	returns index position for the given char value
                int indexOf(int ch, int fromIndex)	returns index position for the given char value and from index
                int indexOf(String substring)	returns index position for the given substring
                int indexOf(String substring, int fromIndex)	returns index position for the given substring and from index
         */

        String s36 = "Sumit Kumar";
        int index1=s36.indexOf("Sumit");
        int index2=s36.indexOf("Kumar");
        System.out.println(index1+"  "+index2);

        int index3=s36.indexOf("um",4);
        System.out.println(index3);

        int index6=s36.indexOf('m');
        System.out.println(index6);

        int index5=s36.indexOf('m',4);
        System.out.println(index5);

        int index4=s36.indexOf('s');
        System.out.println(index4);

        //8.public boolean isEmpty() : checks if this string is empty or not. It returns true, if length of string is 0 otherwise false.

        String s37="";
        String s38="sky";

        System.out.println(s37.isEmpty());
        System.out.println(s38.isEmpty());

        //9.public int lastIndexOf() : returns last index of the given character value or substring. If it is not found, it returns -1. The index counter starts from zero.

        /*
            int lastIndexOf(int ch)	returns last index position for the given char value
            int lastIndexOf(int ch, int fromIndex)	returns last index position for the given char value and from index
            int lastIndexOf(String substring)	returns last index position for the given substring
            int lastIndexOf(String substring, int fromIndex)
        */

        String s39="this is sumit kumar sky";
        int index7=s39.lastIndexOf('s');
        System.out.println(index7);
        int index8=s39.lastIndexOf('s', 4);
        System.out.println(index8);
        int index9=s39.lastIndexOf("sumit");
        System.out.println(index9);
        int index10=s39.lastIndexOf("um", 4);
        System.out.println(index10);

        //10.public int length() : returns count of total number of characters.
        System.out.println(s39.length());

        //11.public String split() : splits this string against given regular expression and returns a char array.
        /*
            public String split(String regex)
            public String split(String regex, int limit)
        */

        String s40="sky has no limit";
        String[] words=s40.split(" ");
        for(String w:words){
            System.out.println(w);
        }
        System.out.println("*************************");
        String s41 = "sky has no limit";
        String[] arr = s41.split("i", 2);
        for (String w : arr) {
            System.out.println(w);
        }

        //12. startsWith(): checks if this string starts with given prefix. It returns true if this string starts with given prefix else returns false.
        /*
            public boolean startsWith(String prefix)
            public boolean startsWith(String prefix, int offset)
        */
        String s42="This is sky";
        System.out.println(s42.startsWith("ja"));
        System.out.println(s42.startsWith("sky"));

        //13. toLowerCase(): returns the string in lowercase letter
        /*
            public String toLowerCase()
            public String toLowerCase(Locale locale)
        */
        String s43="This is SKY";
        System.out.println(s43.toLowerCase());
        System.out.println(s43.toLowerCase(Locale.getDefault()));

        //14. toUpperCase(): returns the string in upper letter
        /*
            public String toUpperCase()
            public String toUpperCase(Locale locale)
        */
        String s44="This is SKY";
        System.out.println(s44.toUpperCase());
        System.out.println(s44.toUpperCase(Locale.getDefault()));


        //15. public String trim(): eliminates leading and trailing spaces

        String s45="  hello sky   ";
        System.out.println(s45+"dive");
        System.out.println(s45.trim()+"dive");
    }
}
