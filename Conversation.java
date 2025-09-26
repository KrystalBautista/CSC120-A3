import java.util.Scanner;


class Conversation implements Chatbot {

  String[] cannedResponses = {
    "Hmm.."
  };

  String[] transcript = new String[100];
  int transcriptIndex = 0;

  Conversation() {
    
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("How many conversation rounds?");
    int rounds = scanner.nextInt();
    scanner.nextLine();

    String greeting = "Hello! What's on your mind?";
    System.out.println(greeting);
    transcript[transcriptIndex++] = greeting;

    for (int i = 0; i < rounds; i++) {
      String userInput = scanner.nextLine();
      transcript[transcriptIndex++] = userInput;
      String response = respond(userInput);
      System.out.println(response);
      transcript[transcriptIndex++] = response;
    }

    String goodbye = "Goodbye!";
    System.out.println(goodbye);
    transcript[transcriptIndex++] = goodbye;
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println("\nTRANSCRIPT: ");
    for (int i = 0; i < transcriptIndex; i++) {
      System.out.println(transcript[i]);
    }
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = inputString; 


  /**
   * Ensures that the replacement doesn't return back to the original input 
   * (I turning into You but then You turning back into I)
   */
  returnString = returnString.replace("I", "__I__");
  returnString = returnString.replace("me", "__ME__");
  returnString = returnString.replace("am", "__AM__");
  returnString = returnString.replace("You", "__YOU__");
  returnString = returnString.replace("my", "__MY__");
  returnString = returnString.replace("your", "__YOUR__");
  returnString = returnString.replace("are", "__ARE__");

  returnString = returnString.replace("__I__", "You");
  returnString = returnString.replace("__ME__", "you");
  returnString = returnString.replace("__AM__", "are");
  returnString = returnString.replace("__YOU__", "I");
  returnString = returnString.replace("__MY__", "your");
  returnString = returnString.replace("__YOUR__", "my");
  returnString = returnString.replace("__ARE__", "am");

    if (!returnString.equals(inputString)) {
      returnString = returnString + "?";
    }
    else {
      int randomIndex = (int)(Math.random() * cannedResponses.length);
      returnString = cannedResponses[randomIndex];
    }
    
    return returnString;
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
