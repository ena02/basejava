package com.urise.webapp.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("ERROR: Resume " + uuid + " don't exist in the storage!", uuid);
    }
}
