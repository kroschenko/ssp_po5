package ftry;

public final class FileEncryptorFactory extends FileEncryptor {
    private FileEncryptorFactory(final Encryptor c_Encryptor) {
        super(c_Encryptor);
    }

    public final static FileEncryptor f_get_vowels_file_encryptor() {
        return new FileEncryptor(new FileEncryptor.VowelsEncryptor());
    }

    public final static FileEncryptor f_get_xor_file_encryptor(final Integer c_XorValue) {
        return new FileEncryptor(new FileEncryptor.XorEncryptor(c_XorValue));
    }

    public final static FileEncryptor f_get_shift_file_encryptor(final Integer c_ShiftValue) {
        return new FileEncryptor(new FileEncryptor.ShiftEncryptor(c_ShiftValue));
    }
}
