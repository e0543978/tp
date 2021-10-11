package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Nationality;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.SocialHandle;
import seedu.address.model.person.TutorialGroup;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_NATIONALITY = "Singapore";
    public static final String DEFAULT_TUTORIAL_GROUP = "01";
    public static final String DEFAULT_SOCIAL_HANDLE = "@amybee";

    private Name name;
    private Phone phone;
    private Email email;
    private Nationality nationality;
    private TutorialGroup tutorialGroup;
    private SocialHandle socialHandle;
    private Set<Tag> tags;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        nationality = new Nationality(DEFAULT_NATIONALITY);
        tutorialGroup = new TutorialGroup(DEFAULT_TUTORIAL_GROUP);
        socialHandle = new SocialHandle(DEFAULT_SOCIAL_HANDLE);
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        nationality = personToCopy.getNationality();
        tutorialGroup = personToCopy.getTutorialGroup();
        socialHandle = personToCopy.getSocialHandle();
        tags = new HashSet<>(personToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>}
     * and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Nationality} of the {@code Person} that we are building.
     */
    public PersonBuilder withNationality(String nationality) {
        this.nationality = new Nationality(nationality);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code TutorialGroup} of the {@code Person} that we are building.
     */
    public PersonBuilder withTutorialGroup(String tutorialGroup) {
        this.tutorialGroup = new TutorialGroup(tutorialGroup);
        return this;
    }

    /**
     * Sets the {@code SocialHandle} of the {@code Person} that we are building.
     */
    public PersonBuilder withSocialHandle(String socialHandle) {
        this.socialHandle = new SocialHandle(socialHandle);
        return this;
    }

    /**
     * Returns a new {@code Person} that we are building.
     */
    public Person build() {
        return new Person(name, phone, email, nationality, tutorialGroup,
                socialHandle, tags);
    }

}
