package com.urise.webapp.storage;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }


    /*@Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.MAX_SIZE; i++) {
                storage.save(new Resume());
            }
        } catch (Exception e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }*/

    /*@Test
    public void fillDeletedElement() {
    }

    @Test
    public void insertElement() {
    }

    @Test
    public void testGetIndex() {
    }*/
}