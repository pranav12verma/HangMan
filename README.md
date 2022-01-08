# HangMan
### Problem Statement
Hangman is a popular word guessing game where the player attempts to build a missing word by guessing one letter at a time. After a certain number of incorrect guesses, the game ends and the player loses. The game also ends if the player correctly identifies all the letters of the missing word.
### About
It is a command line based game developed in java in which player has 5 lives to guess the word.
### Rules of the game

-   Random word is selected from a list of words using API [https://random-word-api.herokuapp.com/word?number=10](https://random-word-api.herokuapp.com/word?number=10)
    
-   The user will get only 5 lives to play the game
    
-   Initially the user is shown “_” (underscore) in the console for each letter in the word. For example, if the word is “banana”, user will see “_ _ _ _ _ _”
    
-   For every correct letter guess, replace the “_” (underscore) with the letter. For example, if user guessed “n”, user will see “_ _ n _ n _”
    
-   If the user guesses the same letter again, don’t do anything and continue with the game. For example, if the user guessed “n” again, show “_ _ n _ n _” and continue.
    
-   For every incorrect guess, reduce the number of lives by 1
    
-   The game ends when the user guesses the word correctly or there are no lives remaining.
### Screen Shots
![alt text](https://github.com/[username]/[reponame]/blob/[branch]/image1.jpg?raw=true)
![alt text](https://github.com/[username]/[reponame]/blob/[branch]/image2.jpg?raw=true)

