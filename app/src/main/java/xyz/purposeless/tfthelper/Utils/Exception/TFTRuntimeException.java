package xyz.purposeless.tfthelper.Utils.Exception;

public class TFTRuntimeException extends RuntimeException {

    public TFTRuntimeException(String message) {
        super(message);
    }

    public TFTRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
