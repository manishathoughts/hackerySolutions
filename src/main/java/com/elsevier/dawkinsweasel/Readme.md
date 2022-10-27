The idea here is that we have 100 strings which are randomly changing, and by always picking the one which is closest to the “correct” string, we will eventually (through random luck) get the right answer. The algorithm looks like:

- Create a random string of 28 characters
- Create 100 copies of the string
- For each character in the 100 strings, with a probability of 5% replace that character with a random character
- Find the string which has the most characters that match “METHINKS IT IS LIKE A WEASEL”
- Go to step 2 and use this as the new string