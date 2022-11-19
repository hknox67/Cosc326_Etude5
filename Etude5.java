import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.io.PrintStream;  
import static java.nio.charset.StandardCharsets.UTF_8;  


/** 
@author Hayden Knox
@author Connor Dobson
@author Ariana van Lith
*/
public class Translate{
   /** These static java data fields are used to represent the different keys which can be 
    * mapped to various words which are used in the process of translating English words (Keys) 
    * to Maori Words (Values). Each HashMap is responsible for a different type of grammatical 
    * word ranging from tense, verbs, and pronouns. 

    /** These Boolean data fields are used if a key value entered by the use from the Scanner class 
     * input does not match the correct translations. A different form of output is printed to the 
     * terminal depending on the number of HashMap keys are deemed incorrect. If only an incorrect 
     * verb is entered as input then the word is indicated in the terminal output. If more than one 
     * Boolean flag value is changed, the word “gibberish” is printed to the terminal to note that 
     * an English to maori translation is impossible
     */


    private static HashMap<String, String> maoriVerbs = new HashMap<String, String>();
    private static HashMap<String, String> maoriPronouns = new HashMap<String, String>();
    private static HashMap<String, String> maoriTense = new HashMap<String, String>();
    private static boolean pronounFlag = false;
    private static boolean verbFlag = false;
    private static boolean tenseFlag = false;

    /**
     * The main method sets the English translation key words to be mapped to Maori. In the order 
     * of Verbs, Tense then Pronoun. 
    * Verb words are set to three different tenses (Past, Present and Future) for thorough translations. 
    * Tense words and phrases are set to the three grammatical forms like verbs (Past, Present and Future).
    * Pronoun words are set to the standard terms (relating to a single person pronoun, second person pronouns 
    * and third person pronouns). However, each pronoun corresponding to Maori translation perspective listeners.

    * Each input from the user is enter by the use of a while loop, The scanner class reads in the input 
    * from the terminal and splits each word corresponding to the whitespace between words.
    * There are checks to eliminate “We” and ”Us” words cases if they are formatted incorrectly making input 
    * string processing much simpler. For each iteration of input processing the Boolean flags are reset to 
    * check new String inputs. 

     * @param args
     */
    public static void main(String[] args) {
        //Encode in UTF-8 to print out macros
        PrintStream out = new PrintStream(System.out, true, UTF_8); // true = autoflush  

         //Verbs Maori
         maoriVerbs.put("go", "haere");
         maoriVerbs.put("going", "haere");
         maoriVerbs.put("gone", "haere");
         maoriVerbs.put("went", "haere");
         maoriVerbs.put("make", "hanga");
         maoriVerbs.put("making", "hanga");
         maoriVerbs.put("made", "hanga");
         maoriVerbs.put("see", "kite");
         maoriVerbs.put("seeing", "kite");
         maoriVerbs.put("seen", "kite");
         maoriVerbs.put("saw", "kite");
         maoriVerbs.put("want", "hiahia");
         maoriVerbs.put("wanting", "hiahia");
         maoriVerbs.put("wanted", "hiahia");
         maoriVerbs.put("call", "karanga");
         maoriVerbs.put("calling", "karanga");
         maoriVerbs.put("called", "karanga");
         maoriVerbs.put("ask", "pātai");
         maoriVerbs.put("asking", "pātai");
         maoriVerbs.put("asked", "pātai");
         maoriVerbs.put("read", "pānui");
         maoriVerbs.put("reading", "pānui");
         maoriVerbs.put("learn", "ako");
         maoriVerbs.put("learning", "ako");
         maoriVerbs.put("learned", "ako");
 
         //Tense
         maoriTense.put("will", "Ka");
         maoriTense.put("go", "Kei te");
         maoriTense.put("are", "Kei te");
         maoriTense.put("am", "Kei te");
         maoriTense.put("is", "Kei te");
         maoriTense.put("asked", "I");
         maoriTense.put("learned", "I");
         //maoriTense.put("gone", "I");
         maoriTense.put("saw", "I");
         maoriTense.put("wanted", "I");
         maoriTense.put("called", "I");
         maoriTense.put("went", "I");
         maoriTense.put("made", "I");

 
         //Pronouns
                 //First person
         maoriPronouns.put("i", "au");
         maoriPronouns.put("I", "au");
         maoriPronouns.put("me", "ahau");
         maoriPronouns.put("you", "koe");
         maoriPronouns.put("he", "ai");
         maoriPronouns.put("she", "ai");
         maoriPronouns.put("him", "ai");
         maoriPronouns.put("her", "ai");
         maoriPronouns.put("Her", "ai");
         maoriPronouns.put("Him", "ai");
         maoriPronouns.put("She", "ai");
         maoriPronouns.put("He", "ai");
         maoriPronouns.put("You", "koe");
         maoriPronouns.put("Me", "ahau");
         
                 //Two Person Maori
         maoriPronouns.put("Wen2", "tāua");
         maoriPronouns.put("Usn2", "tāua");
         maoriPronouns.put("Wex2", "māua");
         maoriPronouns.put("Usx2", "māua");
         maoriPronouns.put("Theyn2", "kōrua");
         maoriPronouns.put("Youx1", "koe");
         maoriPronouns.put("Youn1", "koe");
         maoriPronouns.put("Youn2", "kōrua");
         maoriPronouns.put("Theyx2", "rāua");
         maoriPronouns.put("Themx2", "rāua");
         maoriPronouns.put("wen2", "tāua");
         maoriPronouns.put("usn2", "tāua");
         maoriPronouns.put("wex2", "māua");
         maoriPronouns.put("usx2", "māua");
         maoriPronouns.put("theyn2", "kōrua");
         maoriPronouns.put("youn2", "kōrua");
         maoriPronouns.put("youx1", "koe");
         maoriPronouns.put("youn1", "koe");
         maoriPronouns.put("theyx2", "rāua");
         maoriPronouns.put("themx2", "rāua");         
         
                 //Three Person Maori
         maoriPronouns.put("Wen3","tātou");
         maoriPronouns.put("Usn3", "tātou");
         maoriPronouns.put("Wex3", "mātou");
         maoriPronouns.put("Usx3", "mātou");
         maoriPronouns.put("Youn3", "koutou");
         maoriPronouns.put("Theyx3", "rātou");
         maoriPronouns.put("Themx3", "rātou");
         maoriPronouns.put("wen3","tātou");
         maoriPronouns.put("usn3", "tātou");
         maoriPronouns.put("wex3", "mātou");
         maoriPronouns.put("usx3", "mātou");
         maoriPronouns.put("youn3", "koutou");
         maoriPronouns.put("theyx3", "rātou");
         maoriPronouns.put("themx3", "rātou");

         Scanner scanner = new Scanner(System.in);
         while(scanner.hasNextLine()){
            pronounFlag = false; // reset pronounFlag for each new sentence
            verbFlag = false; // reset verbFlag for each new sentence
            tenseFlag = false; // reset tenseFlag for each new sentence
            String input = scanner.nextLine();
            String output = "" ;
            String flaggedWord = null;

            if (input.length() < 1) {
                continue;
            }

            String[] checkWords = input.split(" ");

            for (String word : checkWords) {
                if (word.equalsIgnoreCase("We") || word.equalsIgnoreCase("Us") || word.equalsIgnoreCase("You") || word.equalsIgnoreCase("They") || word.equalsIgnoreCase("Them") || word.contains("(") || word.contains(")") || word.equalsIgnoreCase("Are") || word.equalsIgnoreCase("will") || word.equalsIgnoreCase("went") || maoriTense.containsKey(word) || maoriPronouns.containsKey(word)) {
                    pronounFlag = false;
                    tenseFlag = false;
                } else if (!maoriVerbs.containsKey(word)) {
                    flaggedWord = word;
                    verbFlag = true; // doesnt work cause work will eventaully not equal a verb
                }
            }

            for (String word : checkWords) {
                if (word.equalsIgnoreCase("We") || word.equalsIgnoreCase("Us") || word.equalsIgnoreCase("You") || word.equalsIgnoreCase("They") || word.equalsIgnoreCase("Them") || word.contains("(") || word.contains(")") || word.equalsIgnoreCase("Are") || word.equalsIgnoreCase("will") || word.equalsIgnoreCase("went") || maoriVerbs.containsKey(word) || maoriTense.containsKey(word)) {
                    verbFlag = false;
                    tenseFlag = false;
                } else if (!maoriPronouns.containsKey(word)) {
                    pronounFlag = true;
                }
            }

            for (String word : checkWords) {
                if (word.equalsIgnoreCase("We") || word.equalsIgnoreCase("Us") || word.equalsIgnoreCase("You")
                        || word.equalsIgnoreCase("They") || word.equalsIgnoreCase("Them") || word.contains("(")
                        || word.contains(")") || word.equalsIgnoreCase("Are") || word.equalsIgnoreCase("will")
                        || word.equalsIgnoreCase("went") || maoriVerbs.containsKey(word)
                        || maoriPronouns.containsKey(word)) {
                    pronounFlag = false;
                    verbFlag = false;
                } else if (!maoriTense.containsKey(word)) {
                    tenseFlag = true;
                }
            }

            if(verbFlag == true && tenseFlag == false && pronounFlag == false){
                out.println("Unknown verb: " + flaggedWord);
                continue; // skip to next sentence
            } else if(verbFlag == true && tenseFlag == true && pronounFlag == true){
                out.println("invalid sentence");
                continue; // skip to next sentence
            } else if (verbFlag == false && tenseFlag == true) {
                out.println("Unknown verb: " + flaggedWord);
                continue;
            } else if (verbFlag == false && tenseFlag == false) {
                //Tense, Verb, Pronouns
                output = tenseTranslate(input, maoriTense) + translateInput(input, maoriVerbs) + pronounKey(input, maoriPronouns);
            }  else if (checkWords.length < 1 || verbFlag == false && pronounFlag == false){
                output = "Ka" + translateInput(input, maoriVerbs) + pronounKey(input, maoriPronouns);
            }
             
            out.println(output);
             
            
            }
            scanner.close();
            }
            /**
            * @param input
            * @param maoriPronouns
            * @return
            * In this method three elements of input from the first Word are used in the creation of a 
            * Pronoun Key for the Pronoun HashMap. From the input “We (3 incl)”. The three Substring 
            * “We”, “3” and (“n” or “x” are used to create a new HashMap key. 
            * Example: “Wen3” is a new key used to traverse the HashMap.
            */
     public static String pronounKey(String input, HashMap<String, String> maoriPronouns) {
         StringBuilder output = new StringBuilder();
         String pronounWord = null;
         String pronounKey = null;
         String Prokeypt1 = "";
         Character Prokeypt2 = null;
         String Prokeypt3 = null;
         if(input.contains(")") == true){
             pronounWord = input.substring(0, input.indexOf(")")+ 1);
             Prokeypt1 = pronounWord.replaceAll("[^0-9]+", "");
             if (Integer.valueOf(Prokeypt1) >= 3) {
                 Prokeypt1 = "3";
             }
             System.out.println(Prokeypt1);
         }
         if (input.contains("excl") == true) {
             Prokeypt2 = 'x';
             Prokeypt3 = pronounWord.substring(0, input.indexOf(" "));
             pronounKey = Prokeypt3 + Prokeypt2 + Prokeypt1;
                 if (maoriPronouns.containsKey(pronounKey)) {
                     output.append(maoriPronouns.get(pronounKey) + " ");
                     
                 }
         } else if (input.contains("incl") == true) {
             Prokeypt2 = 'n';
             Prokeypt3 = pronounWord.substring(0, input.indexOf(" "));
             pronounKey = Prokeypt3 + Prokeypt2 + Prokeypt1;
             if (maoriPronouns.containsKey(pronounKey)) {
                 output.append(maoriPronouns.get(pronounKey) + " ");
             }
             System.out.println(pronounKey);
                 
         } 
         else{
             pronounWord = input.substring(0, input.indexOf(' '));
             //System.out.println(pronounWord);
                 if (maoriPronouns.containsKey(pronounWord)) {
                     output.append(maoriPronouns.get(pronounWord) + " ");
                 }
         }
         return output.toString();
     }
     /**
      * 
      * @param input
      * @param maoriVerbs
      * @return //The identified hash word for Verb
      * This method simply iterates through the verbs which may occur as input in the Scanner class, 
      * Since there are three variations on the tenses of verbs, such as (listen, listening and listened). 
      * All verb tenses equate to a valid string entry. The correct entry when found is appended to the 
      * output variable and returned to the main method.
      */

    public static String translateInput(String input, HashMap<String, String> maoriVerbs){
        StringBuilder output = new StringBuilder();

        for (String key : maoriVerbs.keySet()) {
            if (input.contains(key) && !output.toString().contains(key) && !(output.length() > 0)) {
                output.append(maoriVerbs.get(key) + " ");
            }
        }
        return output.toString();
    }
    /**
     * 
     * @param input
     * @param maoriTense
     * @return //The identified hash word for Tense
     * 
     * This method like tesnseTranslate() simply iterates through the words describing sentence tense 
     * which can occur as input in the Scanner class, Since there are three variations on possible word 
     * tenses, such as (past: are, present: I will, future: ). All tenses equate to a valid string entry. 
     * The correct entry when found is appended to the output variable and returned to the main method
     */

    public static String tenseTranslate(String input, HashMap<String, String> maoriTense){
        StringBuilder output = new StringBuilder();
        for (String key : maoriTense.keySet()){
            if(input.contains(key) && !output.toString().contains(key) && !(output.length() > 0)) {
                output.append(maoriTense.get(key) + " ");
            }
        }

        return output.toString();
    }
}
