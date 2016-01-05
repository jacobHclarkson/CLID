Command Line Interface Dictionary - CLID
Jacob H Clarkson, January 2016
----------------------------------------

A simple program that allows you to get the definition of a word in the command line. Uses the Merriam-Webster online dictionary API. Requires internet connection.


Installation:
    javac Dict.java
    jar cfm CLID.jar Manifest.txt *.class
    mkdir ~/bin
    mv CLID.jar ~/bin
    alias define="java -jar ~/bin/CLID.jar"
    
    NOTE: to make the alias permanent, you will need to add the last line to the appropriate rc file (eg .bash_aliases for     bash)

Usage:
    Type "define word" where "word" is the word you want to look up. Hit enter.
    If nothing happens, the word you entered is not in the dictionary.
