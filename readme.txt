Assumptions:  

-Whitespace to be tokenized.
-Text will not contain abbreviates ending in “.” (e.g. “Mr.,” “Dr.,” “No.”)

My Approach was to construct data as an ArrayList of sentences, with each sentence having a child ArrayList of Tokens.  

For Named Entity Recognition, the program searches each sentence for named entitities by iterating through the set of named entities and compares it against the text of each sentence.  From there, it will determine if the Named Entity is contained in valid tokens and then add them to the list of found named entities to be printed.  This approach is time consuming and will feature redundant searches.  A more efficient manner would have been to search on the text as a whole rather that each sentence, and to mark the position of the found substrings, but alas.

Unfortunately, I wasn't able to get to Requirement #3