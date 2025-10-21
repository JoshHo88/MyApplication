package com.example.myapplication_java;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.concurrent.TimeUnit;

/**
 * ✅ Verified working version for OpenRouter AI on Android
 */
public class AIHelper {

    // 🔑 Replace with your valid OpenRouter key
    private static final String OPENROUTER_API_KEY = "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";  // your full key here
    private static final String OPENROUTER_URL = "https://openrouter.ai/api/v1/chat/completions";
    private static final String MODEL = "deepseek/deepseek-chat";

    public static String askAI(String question) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(45, TimeUnit.SECONDS)
                .readTimeout(45, TimeUnit.SECONDS)
                .build();

        try {
            JSONObject message = new JSONObject();
            message.put("role", "user");
            message.put("content", question);

            JSONArray messages = new JSONArray();
            messages.put(message);

            JSONObject payload = new JSONObject();
            payload.put("model", MODEL);
            payload.put("messages", messages);

            RequestBody body = RequestBody.create(
                    payload.toString(),
                    MediaType.parse("application/json")
            );

            Request request = new Request.Builder()
                    .url(OPENROUTER_URL)
                    .addHeader("Authorization", "Bearer " + OPENROUTER_API_KEY)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("HTTP-Referer", "https://github.com/yourgithub")  // ✅ must be valid!
                    .addHeader("X-Title", "MyHealthAI Android")  // ✅ descriptive title
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();

            if (response.isSuccessful() && response.body() != null) {
                String result = response.body().string();
                JSONObject resJson = new JSONObject(result);
                JSONArray choices = resJson.optJSONArray("choices");

                if (choices != null && choices.length() > 0) {
                    JSONObject messageObj = choices.getJSONObject(0).getJSONObject("message");
                    String content = messageObj.optString("content", "").trim();
                    return "🤖 " + content;
                } else {
                    return "⚠️ No AI response received.";
                }

            } else {
                String errorMsg = response.body() != null ? response.body().string() : "No response";
                return "❌ Request failed: " + errorMsg;
            }

        } catch (Exception e) {
            return "⚠️ Error: " + e.getMessage();
        }
    }
}