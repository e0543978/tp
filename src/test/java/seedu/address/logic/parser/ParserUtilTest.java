package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Nationality;
import seedu.address.model.person.Phone;
import seedu.address.model.person.SocialHandle;
import seedu.address.model.person.TutorialGroup;
import seedu.address.model.tag.Tag;

public class ParserUtilTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_NATIONALITY = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TUTORIAL_GROUP = "B";
    private static final String INVALID_SOCIAL_HANDLE = "rachel walker";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = "Rachel Walker";
    private static final String VALID_PHONE = "123456";
    private static final String VALID_NATIONALITY = "Vietnam";
    private static final String VALID_EMAIL = "rachel@example.com";
    private static final String VALID_TUTORIAL_GROUP = "09";
    private static final String VALID_SOCIAL_HANDLE = "@rachelw";
    private static final String VALID_TAG_1 = "friend";
    private static final String VALID_TAG_2 = "neighbour";

    private static final String WHITESPACE = " \t\r\n";

    @Test
    public void parseIndex_invalidInput_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseIndex("10 a"));
    }

    @Test
    public void parseIndex_outOfRangeInput_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_INVALID_INDEX, ()
            -> ParserUtil.parseIndex(Long.toString(Integer.MAX_VALUE + 1)));
    }

    @Test
    public void parseIndex_validInput_success() throws Exception {
        // No whitespaces
        assertEquals(INDEX_FIRST_PERSON, ParserUtil.parseIndex("1"));

        // Leading and trailing whitespaces
        assertEquals(INDEX_FIRST_PERSON, ParserUtil.parseIndex("  1  "));
    }

    @Test
    public void parseName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseName((String) null));
    }

    @Test
    public void parseName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseName(INVALID_NAME));
    }

    @Test
    public void parseName_validValueWithoutWhitespace_returnsName() throws Exception {
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(VALID_NAME));
    }

    @Test
    public void parseName_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        String nameWithWhitespace = WHITESPACE + VALID_NAME + WHITESPACE;
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(nameWithWhitespace));
    }

    @Test
    public void parsePhone_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePhone((String) null));
    }

    @Test
    public void parsePhone_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parsePhone(INVALID_PHONE));
    }

    @Test
    public void parsePhone_validValueWithoutWhitespace_returnsPhone() throws Exception {
        Phone expectedPhone = new Phone(VALID_PHONE);
        assertEquals(expectedPhone, ParserUtil.parsePhone(VALID_PHONE));
    }

    @Test
    public void parsePhone_validValueWithWhitespace_returnsTrimmedPhone() throws Exception {
        String phoneWithWhitespace = WHITESPACE + VALID_PHONE + WHITESPACE;
        Phone expectedPhone = new Phone(VALID_PHONE);
        assertEquals(expectedPhone, ParserUtil.parsePhone(phoneWithWhitespace));
    }

    @Test
    public void parseNationality_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseNationality((String) null));
    }

    @Test
    public void parseNationality_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseNationality(INVALID_NATIONALITY));
    }

    @Test
    public void parseNationality_validValueWithoutWhitespace_returnsNationality() throws Exception {
        Nationality expectedNationality = new Nationality(VALID_NATIONALITY);
        assertEquals(expectedNationality, ParserUtil.parseNationality(VALID_NATIONALITY));
    }

    @Test
    public void parseNationality_validValueWithWhitespace_returnsTrimmedNationality() throws Exception {
        String nationalityWithWhitespace = WHITESPACE + VALID_NATIONALITY + WHITESPACE;
        Nationality expectedNationality = new Nationality(VALID_NATIONALITY);
        assertEquals(expectedNationality, ParserUtil.parseNationality(nationalityWithWhitespace));
    }

    @Test
    public void parseEmail_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseEmail((String) null));
    }

    @Test
    public void parseEmail_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseEmail(INVALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithoutWhitespace_returnsEmail() throws Exception {
        Email expectedEmail = new Email(VALID_EMAIL);
        assertEquals(expectedEmail, ParserUtil.parseEmail(VALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithWhitespace_returnsTrimmedEmail() throws Exception {
        String emailWithWhitespace = WHITESPACE + VALID_EMAIL + WHITESPACE;
        Email expectedEmail = new Email(VALID_EMAIL);
        assertEquals(expectedEmail, ParserUtil.parseEmail(emailWithWhitespace));
    }

    @Test
    public void parseTutorialGroup_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTutorialGroup((String) null));
    }

    @Test
    public void parseTutorialGroup_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTutorialGroup(INVALID_TUTORIAL_GROUP));
    }

    @Test
    public void parseTutorialGroup_validValueWithoutWhitespace_returnsTutorialGroup() throws Exception {
        TutorialGroup expectedTutorialGroup = new TutorialGroup(VALID_TUTORIAL_GROUP);
        assertEquals(expectedTutorialGroup, ParserUtil.parseTutorialGroup(VALID_TUTORIAL_GROUP));
    }

    @Test
    public void parseTutorialGroup_validValueWithWhitespace_returnsTrimmedTutorialGroup() throws Exception {
        String tutorialGroupWithWhitespace = WHITESPACE + VALID_TUTORIAL_GROUP + WHITESPACE;
        TutorialGroup expectedTutorialGroup = new TutorialGroup(VALID_TUTORIAL_GROUP);
        assertEquals(expectedTutorialGroup, ParserUtil.parseTutorialGroup(tutorialGroupWithWhitespace));
    }

    @Test
    public void parseSocialHandle_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseSocialHandle((String) null));
    }

    @Test
    public void parseSocialHandle_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseSocialHandle(INVALID_SOCIAL_HANDLE));
    }

    @Test
    public void parseSocialHandle_validValueWithoutWhitespace_returnsSocialHandle() throws Exception {
        SocialHandle expectedSocialHandle = new SocialHandle(VALID_SOCIAL_HANDLE);
        assertEquals(expectedSocialHandle, ParserUtil.parseSocialHandle(VALID_SOCIAL_HANDLE));
    }

    @Test
    public void parseSocialHandle_validValueWithWhitespace_returnsTrimmedSocialHandle() throws Exception {
        String socialHandleWithWhitespace = WHITESPACE + VALID_SOCIAL_HANDLE + WHITESPACE;
        SocialHandle expectedSocialHandle = new SocialHandle(VALID_SOCIAL_HANDLE);
        assertEquals(expectedSocialHandle, ParserUtil.parseSocialHandle(socialHandleWithWhitespace));
    }

    @Test
    public void parseTag_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTag(null));
    }

    @Test
    public void parseTag_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTag(INVALID_TAG));
    }

    @Test
    public void parseTag_validValueWithoutWhitespace_returnsTag() throws Exception {
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(VALID_TAG_1));
    }

    @Test
    public void parseTag_validValueWithWhitespace_returnsTrimmedTag() throws Exception {
        String tagWithWhitespace = WHITESPACE + VALID_TAG_1 + WHITESPACE;
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(tagWithWhitespace));
    }

    @Test
    public void parseTags_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTags(null));
    }

    @Test
    public void parseTags_collectionWithInvalidTags_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, INVALID_TAG)));
    }

    @Test
    public void parseTags_emptyCollection_returnsEmptySet() throws Exception {
        assertTrue(ParserUtil.parseTags(Collections.emptyList()).isEmpty());
    }

    @Test
    public void parseTags_collectionWithValidTags_returnsTagSet() throws Exception {
        Set<Tag> actualTagSet = ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, VALID_TAG_2));
        Set<Tag> expectedTagSet = new HashSet<Tag>(Arrays.asList(new Tag(VALID_TAG_1), new Tag(VALID_TAG_2)));

        assertEquals(expectedTagSet, actualTagSet);
    }
}
