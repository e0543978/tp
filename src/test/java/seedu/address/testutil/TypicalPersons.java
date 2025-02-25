package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GENDER_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GENDER_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NATIONALITY_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NATIONALITY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REMARK_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REMARK_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SOCIAL_HANDLE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SOCIAL_HANDLE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_GROUP_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_GROUP_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;


/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline").withGender("F")
            .withNationality("Singaporean").withEmail("alice@example.com")
            .withPhone("94351253").withTutorialGroup("T09")
            .withRemark("She likes aardvarks.").withTags("friends").withSocialHandles("tg:alicep")
            .build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier").withGender("M")
            .withNationality("Chinese").withEmail("johnd@example.com")
            .withPhone("98765432").withTutorialGroup("W08")
            .withRemark("He can't take beer!").withTags("owesMoney", "friends")
            .withSocialHandles("tg:bensonm")
            .build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withGender("M")
            .withPhone("95352563").withEmail("heinz@example.com").withNationality("Malaysian")
            .withTutorialGroup("T05").withRemark("She likes aardvarks.").withSocialHandles("tg:carlk")
            .build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withGender("M")
            .withPhone("87652533").withEmail("cornelia@example.com").withNationality("Thai")
            .withTutorialGroup("T09").withRemark("She likes aardvarks.").withSocialHandles("tg:danielm")
            .withTags("friends")
            .build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withGender("F")
            .withPhone("9482224").withEmail("werner@example.com").withNationality("American")
            .withTutorialGroup("T29").withRemark("She likes aardvarks.")
            .build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withGender("F")
            .withPhone("9482427").withEmail("lydia@example.com").withNationality("Australian")
            .withTutorialGroup("T19").withRemark("She likes aardvarks.")
            .build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withGender("M")
            .withPhone("9482442").withEmail("anna@example.com").withNationality("Vietnamese")
            .withTutorialGroup("T28").withRemark("She likes aardvarks.")
            .build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withGender("M")
            .withPhone("8482424").withEmail("stefan@example.com").withNationality("Indian")
            .withRemark("She likes aardvarks.")
            .build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withGender("M")
            .withPhone("8482131").withEmail("hans@example.com").withNationality("Chinese")
            .withRemark("She likes aardvarks.")
            .build();


    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder()
            .withName(VALID_NAME_AMY)
            .withGender(VALID_GENDER_AMY)
            .withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY)
            .withNationality(VALID_NATIONALITY_AMY)
            .withTutorialGroup(VALID_TUTORIAL_GROUP_AMY)
            .withRemark(VALID_REMARK_AMY)
            .withTags(VALID_TAG_FRIEND)
            .withSocialHandles(VALID_SOCIAL_HANDLE_AMY)
            .build();
    public static final Person BOB = new PersonBuilder()
            .withName(VALID_NAME_BOB)
            .withGender(VALID_GENDER_BOB)
            .withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB)
            .withNationality(VALID_NATIONALITY_BOB)
            .withTutorialGroup(VALID_TUTORIAL_GROUP_BOB)
            .withRemark(VALID_REMARK_BOB)
            .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .withSocialHandles(VALID_SOCIAL_HANDLE_BOB)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
