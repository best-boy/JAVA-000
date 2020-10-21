import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhangsen
 * @date 2020/10/21 11:33 下午
 */
public class HelloClassLoader extends ClassLoader {

  public static void main(String[] args)
          throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    Object hello=new HelloClassLoader().findClass("Hello").newInstance();
    Method helloMethod=hello.getClass().getMethod("hello");
    helloMethod.invoke(hello);
  }

  @Override
  protected Class<?> findClass(String name) {
    byte[] bytes = new byte[0];
    try {
      bytes = loadHello();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return defineClass(name, bytes, 0, bytes.length);
  }

  private static byte[] loadHello() throws IOException {
    try (InputStream inputStream =
        new FileInputStream(
            "./Hello.xlass"); ) {
      int count = inputStream.available();
      byte[] bytes = new byte[count];
      byte a = (byte) 255;
      inputStream.read(bytes);
      for (int i = 0; i < bytes.length; i++) {
        bytes[i] = (byte) (a - bytes[i]);
      }
      return bytes;
    }
  }

}
