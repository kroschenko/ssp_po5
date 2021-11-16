package ftry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Main {
    public final static void main(final String[] c_Args) throws IOException {
        final Integer c_ShiftValue = 5, c_XorValue = 2;

        final FileEncryptor c_VowelsFileEncryptor = FileEncryptorFactory.f_get_vowels_file_encryptor(),
                c_XorFileEncryptor = FileEncryptorFactory.f_get_xor_file_encryptor(c_XorValue),
                c_ShiftFileEncryptor = FileEncryptorFactory.f_get_shift_file_encryptor(c_ShiftValue);

        final String c_Input = new String(Files.readString(Path.of("test.txt")));

        System.out.println("Source: " + c_Input + '\n');
        System.out.println("After vowels encryption: " + c_VowelsFileEncryptor.f_encrypt(c_Input));
        System.out.println("After xor encryption: " + c_XorFileEncryptor.f_encrypt(c_Input));
        System.out.println("After shift encryption: " + c_ShiftFileEncryptor.f_encrypt(c_Input));
    }
}
