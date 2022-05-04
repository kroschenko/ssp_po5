package ftry;

public class FileEncryptor {
    private final FileEncryptor.Encryptor m_Encryptor;

    protected FileEncryptor(final FileEncryptor.Encryptor c_Encryptor) {
        this.m_Encryptor = c_Encryptor;
    }

    public final String f_encrypt(final String c_Input) {
        return m_Encryptor.f_encrypt(c_Input);
    }

    protected static interface Encryptor {
        public String f_encrypt(final String c_Input);
    }

    protected final static class VowelsEncryptor implements Encryptor {
        public VowelsEncryptor() {
        }

        @Override
        public final String f_encrypt(final String c_Input) {
            return c_Input.replaceAll("[AEIOUaeiou]", "");
        }
    }

    protected final static class XorEncryptor implements Encryptor {
        private final Integer m_XorValue;

        public XorEncryptor(final Integer c_XorValue) {
            this.m_XorValue = c_XorValue;
        }

        @Override
        public final String f_encrypt(final String c_Input) {
            char[] v_Result = c_Input.toCharArray();

            for (Integer v_I = 0, v_Size = v_Result.length; v_I < v_Size; ++v_I) {
                v_Result[v_I] = (char) (((int) v_Result[v_I]) ^ this.m_XorValue);
            }

            return new String(v_Result);
        }
    }

    protected final static class ShiftEncryptor implements Encryptor {
        private final Integer m_ShiftValue;

        public ShiftEncryptor(final Integer c_ShiftValue) {
            this.m_ShiftValue = c_ShiftValue;
        }

        @Override
        public final String f_encrypt(final String c_Input) {
            char[] v_Result = c_Input.toCharArray();

            for (Integer v_I = 0, v_Size = v_Result.length; v_I < v_Size; ++v_I) {
                v_Result[v_I] = (char) (((int) v_Result[v_I]) + this.m_ShiftValue);
            }

            return new String(v_Result);
        }
    }
}
