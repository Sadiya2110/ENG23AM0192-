
   
import java.util.ArrayList;
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
}

       
