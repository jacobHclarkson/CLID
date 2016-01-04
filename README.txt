Command Line Interface Dictionary - CLID
Jacob H Clarkson, January 2016
----------------------------------------

A simple program that allows you to get the definition of a word in the command line. Uses the Merriam-Webster online dictionary API. Requires internet connection.


Installation:
    jar cfm CLID.jar Manifest.txt *.class
    mkdir ~/bin
    mv CLID.jar ~/bin
    alias define="java -jar ~/bin/CLID.jar"

Usage:
    Type "define word" where "word" is the word you want to look up. Hit enter.
