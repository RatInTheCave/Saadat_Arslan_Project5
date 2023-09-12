package Part2_Decomposition;

import java.util.Scanner;

public class Decomposition {
    public static void main(String[] args) {
        boolean RepeatFlag = false;
        while (!RepeatFlag) {
            String name = Name();
            String recommendation = Preference(name);
            int age = Age();
            int PreferredGenreFlag = Genre(age);


            if (recommendation.equals("Animated films")) {
                if (PreferredGenreFlag == 0) {
                    print(name + " since you like live-action films, and you like horror movies, I would recommend ''The Thing (1982)''");
                } else if (PreferredGenreFlag == 1) {
                    print(name + " since you like live-action films, and you like history movies, I would recommend ''The Founder''");
                } else if (PreferredGenreFlag == 2) {
                    if (age < 16) {
                        print(name + " since you like live-action films, and you like fantasy movies, I would recommend ''Pinocchio (1940)''");
                    } else {
                        print(name + " since you like live-action films, and you like fantasy movies, I would recommend ''The Lord of the Rings: The Fellowship of the Ring''");
                    }
                } else if (PreferredGenreFlag == 3) {
                    if (age < 16) {
                        print(name + " since you like live-action films, and you like detective movies, I would recommend ''Knives Out'");
                    }
                } else if (PreferredGenreFlag == 4) {
                    if (age < 16) {
                        print(name + " since you like live-action films, and you like Science Fiction, I would recommend ''Guardians of the Galaxy'");
                    } else {
                        print(name + " since you like live-action films, and you like Science Fiction, I would recommend ''Inception''");
                    }
                } else if (PreferredGenreFlag == 5) {
                    print(name + " since you like live-action films, and you like comedy, I would recommend ''The Mask (1994)''");

                }
            } else {

                if (PreferredGenreFlag == 0) {
                    print(name + " since you like animated films, and you like horror movies, I would recommend ''Caroline(2009)''");
                } else if (PreferredGenreFlag == 1) {
                    print(name + " since you like animated films, and you like history movies, I would recommend ''Mr. Peabody & Sherman''");
                } else if (PreferredGenreFlag == 2) {
                    if (age < 16) {
                        print(Name() + " since you like animated films, and you like fantasy movies, I would recommend ''Tangled''");
                    } else {
                        print(name + " since you like animated films, and you like fantasy movies, I would recommend ''Shrek (2001)''");
                    }
                } else if (PreferredGenreFlag == 3) {
                    if (age < 16) {
                        print(name + " since you like animated films, and you like detective movies, I would recommend ''The Great Mouse Detective''");
                    }
                } else if (PreferredGenreFlag == 4) {
                    if (age < 16) {
                        print(name + " since you like animated films, and you like Science Fiction, I would recommend ''WALL-E''");
                    } else {
                        print(name + " since you like animated films, and you like Science Fiction, I would recommend ''Spider Man: Into the Spider-Verse''");
                    }
                } else if (PreferredGenreFlag == 5) {
                    print(name + " since you like animated films, and you like comedy, I would recommend ''Puss in Boots: The Last Wish ''");
                }
            }
            String answer = GetUserString("Would you like to repeat this conversation? Answer with Y or N");
            if (answer.contains("y")) {
                RepeatFlag = false;
            } else {
                RepeatFlag = true;
            }

        }
    }

    public static String Name() {
        String name = GetUserString("Hi! What is your name? ");
        return name;
    }

    public static String Preference(String name) {
        boolean answerFlag = false;
        int PreferredFilmsFlag = 0;
        while (!answerFlag) {
            String PreferredFilms = GetUserString(name + ", do you prefer animated movies or live-action films?");
            if (PreferredFilms.toLowerCase().contains("anim")) {
                answerFlag = true;
                print("Great you prefer animated movies, I like them too");
                PreferredFilmsFlag = 1;
            } else if (PreferredFilms.toLowerCase().contains("live")) {
                answerFlag = true;
                print("Okay, let's talk about Live-action movies");
            } else if (PreferredFilms.toLowerCase().contains("action")) {
                answerFlag = true;
                print("Okay, let's talk about Live-action movies");
            } else {
                print("I don't understand");
            }
        }
        String recommendation = "";
        switch (PreferredFilmsFlag) {
            case 0 -> recommendation = "Animated films";
            case 1 -> recommendation = "Live-Action";
        }
        return recommendation;
    }

    public static int Age() {
        print("What is your age?");
        Scanner UserInput = new Scanner(System.in);
        int age = UserInput.nextInt();
        if (age < 1) {
            print("Your age is impossible");
            System.exit(0);
        }
        print("So you are " + age + " years old. I will use this when recommending a movie");
        return age;
    }

    public static int Genre(int age) {
        int PreferredGenreFlag = 99;
        boolean answerFlag2 = false;
        while (!answerFlag2) {
            String genre = GetUserString("What is your favorite genre? Horror, historical, fantasy, detective, SciFi or maybe comedy? ");
            if (genre.toLowerCase().contains("hor")) {
                answerFlag2 = true;
                print("So you like horror movies?");
                if (age > 13) {
                    PreferredGenreFlag = 0;
                } else {
                    print("Why are you watching horror movies if you are so young?");
                }
            } else if (genre.toLowerCase().contains("hist")) {
                answerFlag2 = true;
                print("So you like historical movies?");
                PreferredGenreFlag = 1;
            } else if (genre.toLowerCase().contains("fant")) {
                answerFlag2 = true;
                print("So you like Fantasy movies?");
                PreferredGenreFlag = 2;
            } else if (genre.toLowerCase().contains("det")) {
                answerFlag2 = true;
                print("So you like detective movies?");
                PreferredGenreFlag = 3;
            } else if (genre.toLowerCase().contains("sci")) {
                answerFlag2 = true;
                PreferredGenreFlag = 4;
                print("So you like science fiction movies?");
            } else if (genre.toLowerCase().contains("com")) {
                answerFlag2 = true;
                PreferredGenreFlag = 5;
                print("So you like comedy?");
            } else {
                print("I don't know this genre");
            }

        }
        return PreferredGenreFlag;
    }

    public static String GetUserString(String QuestionToUser) {

        Scanner UserInput = new Scanner(System.in);
        String Answer = "";
        print(QuestionToUser);
        Answer = UserInput.nextLine();
        UserInput = null;

        return Answer;
    }

    public static void print(String toPrint) {
        System.out.println(toPrint);
    }
}
