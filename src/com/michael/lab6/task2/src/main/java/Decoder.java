import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;

import java.io.*;

public class Decoder
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: ");
        String s = br.readLine();

        byte[] buffer = Base64.decodeBase64(s);
        byte[] rezultBuffer = new byte[100];

        ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);
        XZCompressorInputStream compressorInputStream = new XZCompressorInputStream(inputStream);

        compressorInputStream.read(rezultBuffer);
        compressorInputStream.close();

        String result = new String(rezultBuffer);
        System.out.println(result);
    }
}
