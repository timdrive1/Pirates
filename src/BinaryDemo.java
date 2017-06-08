import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Тим on 08.06.2017.
 */
public class BinaryDemo {
    final static String FILE = "test.dat";
    final static String FILE2 = "test2.dat";

    static String[] names = {"Jameson", "William", "Bushmills"};
    static int[] gold = {24, 45, 31};
    static double[] highs = {1.74, 1.68, 1.82};

    public static void main(String[] args) throws IOException {
        try {
            writeOutBinary();
            readInBinary();
            //soutValues();
            writeOutBytes();
            readInBytes();
            soutValues();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void writeOutBinary() throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
        try {
            for (int i = 0; i < names.length; i++) {
                dataOutputStream.writeUTF(names[i]);
                dataOutputStream.writeInt(gold[i]);
                dataOutputStream.writeDouble(highs[i]);
            }
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String[] namesIn = new String[names.length];
    static int[] goldIn = new int[gold.length];
    static double[] highsIn = new double[highs.length];

    static void readInBinary() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);

        try {
            for (int i = 0; i < namesIn.length; i++) {
                namesIn[i] = dataInputStream.readUTF();
                goldIn[i] = dataInputStream.readInt();
                highsIn[i] = dataInputStream.readDouble();
            }
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static byte[] StrToByteArr(String[] arr) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(arr.length * 2);
        for (String x : arr
                ) {
            byteBuffer.putChar(x.charAt(0));
        }
        return byteBuffer.array();
    }

    static byte[] IntToByteArr(int[] arr) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(arr.length * Integer.BYTES);
        for (int x : arr
                ) {
            byteBuffer.putInt(x);
        }
        return byteBuffer.array();
    }

    static byte[] DoubleToByteArr(double[] arr) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(arr.length * Double.BYTES);
        for (double x : arr
                ) {
            byteBuffer.putDouble(x);
        }
        return byteBuffer.array();
    }

    static void writeOutBytes() {
        byte[] bufNames = StrToByteArr(names);
        byte[] bufInts = IntToByteArr(gold);
        byte[] bufDoubles = DoubleToByteArr(highs);
        Path p = Paths.get(FILE2);
        try {
            Files.write(p, bufNames);
            Files.write(p, bufInts, StandardOpenOption.APPEND);
            Files.write(p, bufDoubles, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readInBytes() throws IOException {
        Path p = Paths.get(FILE2);
        byte[] buf = Files.readAllBytes(p);
        int i = 0, k = 0;
        int namesArrEnd = names.length * 2;
        int goldArrEnd = namesArrEnd + gold.length * Integer.BYTES;
        for (; i < namesArrEnd; i += 2) {
            byte[] minibuf = {buf[i], buf[i + 1]};
            namesIn[k] = String.valueOf(ByteBuffer.wrap(minibuf).getChar());
            k++;
        }
        k = 0;
        for (; i < goldArrEnd; i += 4) {
            byte[] minibuf = {buf[i], buf[i + 1], buf[i + 2], buf[i + 3]};
            goldIn[k] = ByteBuffer.wrap(minibuf).getInt();
            k++;
        }
        k = 0;
        for (; i < buf.length; i += 8) {
            byte[] minibuf = {buf[i], buf[i + 1],buf[i+2],buf[i+3],buf[i+4],buf[i+5],buf[i+6],buf[i+7]};
            highsIn[k] = ByteBuffer.wrap(minibuf).getDouble();
            k++;
        }
    }

    static void soutValues() {
        for (int i = 0; i < namesIn.length; i++) {
            System.out.println(namesIn[i] + " " + goldIn[i] + " " + highsIn[i]);
        }
    }
}

