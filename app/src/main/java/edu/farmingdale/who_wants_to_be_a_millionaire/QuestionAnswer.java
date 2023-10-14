package edu.farmingdale.who_wants_to_be_a_millionaire;

public class QuestionAnswer {

    //Array of questions
    public static String[] question = {
            "Who is the alter ego of Norman Osborn in the 2002 film Spider-Man?",
            "Which breed of dog is traditionally used for hunting hares?",
            "The Starbucks coffee company was founded in which US City?",
            "Traditionally, mozzarella cheese is made from the milk of which Animal?",
            "Where traditionally do birds fly in winter?",
            "Which of the following is NOT a Bird of Prey?",
            "What name is given to the part of a Logarithm after the decimal point?",
    };

    //Array of choices for answers
    public static String[][] choices = {
            {"Red Dragon", "Yellow Peril", "Green Goblin", "Silver Shadow"},
            {"Dachshund", "Beagle", "Great Dane", "Border Collie"},
            {"Seattle", "Dallas", "Miami", "Boston"},
            {"Sheep", "Goat", "Moose", "Buffalo"},
            {"North", "East", "South", "Ibiza"},
            {"Owl", "Buzzard", "Eagle", "Sparrow"},
            {"Mantilla", "Manumit", "Mantissa", "Manzanilla"}
    };

    //Array for correct answers
    public static String[] correctAnswers = {
            "Green Goblin",
            "Beagle",
            "Seattle",
            "Buffalo",
            "South",
            "Sparrow",
            "Mantissa"
    };
}
