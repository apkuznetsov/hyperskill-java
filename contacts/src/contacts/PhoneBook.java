package contacts;

import org.jetbrains.annotations.NotNull;

public class PhoneBook {

    final private Contact firstContact;

    public PhoneBook(@NotNull Contact contact) {

        firstContact = contact;
    }
}
