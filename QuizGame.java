
   
/*import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {

    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz!");
        
        // Start the quiz
        List<Question> questions = createQuestions();
        for (Question question : questions) {
            askQuestion(question);
        }

        // Display final score
        System.out.println("Quiz complete! Your score: " + score);
    }

    // Method to create a list of questions for the quiz
    private static List<Question> createQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is the capital of France?", new String[]{"a) Paris", "b) London", "c) Rome", "d) Berlin"}, "a"));
        questions.add(new Question("What is 2 + 2?", new String[]{"a) 3", "b) 4", "c) 5", "d) 6"}, "b"));
        questions.add(new Question("What is the color of the sky?", new String[]{"a) Green", "b) Blue", "c) Red", "d) Yellow"}, "b"));

        return questions;
    }

    // Method to ask each question and check the answer
    private static void askQuestion(Question question) {
        System.out.println(question.getQuestionText());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }

        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine();

        if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong! The correct answer was: " + question.getCorrectAnswer());
        }
        System.out.println();
    }
}

class Question {
    private String questionText;
    private String[] options;
    private String correctAnswer;

    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}*/
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Quiz questions and correct answers
        String[] questions = {
            "1. What is the capital of France? (a) Berlin (b) London (c) Paris (d) Rome",
            "2. Who wrote 'To Kill a Mockingbird'? (a) Harper Lee (b) Mark Twain (c) J.K. Rowling (d) Charles Dickens",
            "3. What is 5 + 7? (a) 10 (b) 11 (c) 12 (d) 13",
            "4. Which planet is known as the Red Planet? (a) Earth (b) Mars (c) Venus (d) Jupiter",
            "5. What is the square root of 16? (a) 2 (b) 3 (c) 4 (d) 5"
        };
        char[] answers = {'c', 'a', 'c', 'b', 'c'}; // Correct answers for each question

        // Loop through questions
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Your answer: ");
            char answer = scanner.next().charAt(0);

            // Check if answer is correct
            if (answer == answers[i]) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect.");
            }
            System.out.println();
        }

        // Display final score
        System.out.println("Quiz completed! Your final score is: " + score + "/" + questions.length);
        scanner.close();
    }
}

