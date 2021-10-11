package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's social handle in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidSocialHandle(String)}
 */
public class SocialHandle {

    public static final String MESSAGE_CONSTRAINTS = "Social handle (Telegram handle) should be "
            + "a single string without whitespaces, starts with a '@' character, "
            + "and not be blank";

    /*
     * The first character of the social handle must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "@\\S+";

    public final String value;

    /**
     * Constructs an {@code SocialHandle}.
     *
     * @param socialHandle A valid Telegram handle.
     */
    public SocialHandle(String socialHandle) {
        requireNonNull(socialHandle);
        checkArgument(isValidSocialHandle(socialHandle), MESSAGE_CONSTRAINTS);
        value = socialHandle;
    }

    /**
     * Returns true if a given string is a valid social handle.
     */
    public static boolean isValidSocialHandle(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SocialHandle // instanceof handles nulls
                && value.equals(((SocialHandle) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
