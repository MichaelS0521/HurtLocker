import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    Pattern pattern;
    Matcher matcher;

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }
}
