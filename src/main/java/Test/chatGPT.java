package Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class chatGPT extends Application {
    private static final int HTTP_TOO_MANY_REQUESTS = 429;  // Define the 429 status code
    private ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setPromptText("Enter your prompt here...");
        Button sendButton = new Button("Send");

        sendButton.setOnAction(e -> {
            String prompt = textArea.getText();
            executorService.submit(() -> {
                try {
                    chatGPT(prompt);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        });

        VBox root = new VBox(10, textArea, sendButton);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("ChatGPT Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void chatGPT(String text) throws Exception {
        String url = "https://api.openai.com/v1/chat/completions";
        int retries = 0;
        int maxRetries = 5;
        boolean requestSuccessful = false;

        while (!requestSuccessful && retries < maxRetries) {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            try {
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Authorization", "Bearer sk-proj-I74JWSpzXXNtoEbNV5mKT3BlbkFJ7UY5jFy8qoHHDxICjn6u");  // Replace YOUR_API_KEY with the actual API key

                JSONObject data = new JSONObject();
                data.put("model", "gpt-3.5-turbo-16k");
                data.put("prompt", text);
                data.put("max_tokens", 256);
                data.put("temperature", 0.7);

                con.setDoOutput(true);
                con.getOutputStream().write(data.toString().getBytes());
                int responseCode = con.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    System.out.println("Response: " + response.toString());
                    requestSuccessful = true;
                } else if (responseCode == HTTP_TOO_MANY_REQUESTS) {
                    System.out.println("Retry attempt #" + retries);
                    Thread.sleep((long) Math.pow(2, retries) * 1000);
                    retries++;
                } else {
                    System.out.println("Request failed with HTTP error code: " + responseCode);
                    break;
                }
            } finally {
                con.disconnect();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}