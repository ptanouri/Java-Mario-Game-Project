Pouya Tanouri
Project 4
4/29/2017
ptanouri@u.rochester.edu
29574995
Head TA: Tallis Polashenski
Workshop day: Sunday 3-4.15 pm
Workshop TA: Alex Mai

I did not collaborate with anyone on this assignment.

This folder contains the fololowing files:
- Character.java
- Game.java
- Hazards.java
- Powers.java
- Rect.java
- RectManager.java
- Run.java *** (please run this file to play the game)


Extra credit:

For extra credit I decided to generate 60 random rectangles for the ground (levels) that each have a 
random height, width and gap between them. Even though the spacing between each rectangle and the size of
each rectangle changes, I made sure that my game is always playable and it is always possible to finish the game
(although it might be a little bit challenging). 


Details of the game:
- In my game I have shown the character with a red rectangle, hazards with black rectangles and the score power-ups with
yellow rectangles. The player has 3 lives, and loses one of them each time it colides with one of the hazards. However,
the character dies instantly if it run into a wall or fall into a bottomless pits.
- Capturing the each yellow rectangle (power-up) will increase the player's score by 20 points. So the more power-up the 
character collects, the higher the final score is.
- I have created two levels that are visually distinct, a day level and a night one. The player starts with the day level
and after playing it for a certain amount of time, the level automatically changes from day time to night time.
The night level is more challenging since it contains more hazards and it moves faster than the day-level

**Note
- Based on the way my bounding box and my detection methods are set up, when the character jumps from one block to a 
second block, if all or most of the character's surface area is not touching the ground the game might consider it as a fall and 
the game will end in that case. This is due to the fact that the game compares the left edge of the characer's rectangle
with the hight of the ground. However, this is NOT A BUG. This was intentional in order to make the game a little bit more challenging.
Because this way, the right timing for the character to jump from one block to another is crucial. 



