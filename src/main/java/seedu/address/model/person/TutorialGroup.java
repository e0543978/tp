package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's tutorial group in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidTutorialGroup(String)}
 */
public class TutorialGroup {

    public static final String MESSAGE_CONSTRAINTS =
            "Tutorial Groups should only contain numbers, and it should not be blank";
    public static final String VALIDATION_REGEX = "\\d+";

    public final String value;

    /**
     * Constructs an {@code TutorialGroup}.
     *
     * @param tutorialGroup A valid tutorial group.
     */
    public TutorialGroup(String tutorialGroup) {
        requireNonNull(tutorialGroup);
        checkArgument(isValidTutorialGroup(tutorialGroup), MESSAGE_CONSTRAINTS);
        this.value = tutorialGroup;
    }

    /**
     * Returns true if a given string is a valid tutorial group.
     */
    public static boolean isValidTutorialGroup(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TutorialGroup // instanceof handles nulls
                && value.equals(((TutorialGroup) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
