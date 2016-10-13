import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Encoder {

/*
Enter String: *****
/Td6WFoAAATm1rRGAgAhARYAAAB0L+WjAQBEQXBhY2hlIE1hdmVuIGlzIGEgc29mdHdhcmUgcHJvamVjdCBtYW5hZ2VtZW50IGFuZCBjb21wcmVoZW5zaW9uIHRvb2wuAAAAAMXaU7TVffeMAAFdRS0jJSkftvN9AQAAAAAEWVo=
*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: ");
        String s = br.readLine();

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        XZCompressorOutputStream xzOut = new XZCompressorOutputStream(bout);
        xzOut.write(s.getBytes());
        xzOut.close();

        String result = Base64.encodeBase64String(bout.toByteArray());
        System.out.println(result);
    }

}

