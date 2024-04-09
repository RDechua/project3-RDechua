package dictionary;

import java.util.List;

/** Dictionary ADT with extra functionality: the ability to make a spelling suggestion.
 *  You may not change anything in this interface. */
public interface Dictionary {

    /** Adds a given word to the dictionary
     * @param word The word to add to the dictionary
     */
    void add(String word);

    /**
     * Checks if a given word is in the dictionary
     * @param word The word to check
     * @return true if the word is in the dictionary, false otherwise
     */
    boolean check(String word);

    /**
     * Checks if a given prefix is stored in the dictionary
     * @param prefix The prefix of a word
     * @return true if this prefix is a prefix of a valid word in the dictionary,
     * and false otherwise
     */
    boolean checkPrefix(String prefix);

    /**
     * Returns an ArrayList of spelling suggestions - entries in the dictionary close to
     * the target word (that have the longest common prefix with the given word - see description)
     * @param word the target word
     * @return suggestions
     */
     List<String> suggest(String word);

    /** Return the string representation of the prefix tree
     *
     * @return string representing the tree.
     */
     String toString();
}
