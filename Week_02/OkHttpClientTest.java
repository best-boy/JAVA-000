import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author zhangsen
 * @date 2020/10/28 10:45 下午
 */
public class OkHttpClientTest {
  public static void main(String[] args) throws IOException {
    OkHttpClient client = new OkHttpClient().newBuilder().build();
    Request request =
        new Request.Builder().url("http://localhost:8088/api/hello").method("GET", null).build();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());
  }
}
