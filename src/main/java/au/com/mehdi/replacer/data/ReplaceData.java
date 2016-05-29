package au.com.mehdi.replacer.data;

import java.io.File;

/**
 * Java bean for user input data
 */
public class ReplaceData {

    private String pattern;

    private boolean regularExpression;

    private File file;

    public ReplaceData(String pattern, boolean regularExpression, File file) {
        this.pattern = pattern;
        this.regularExpression = regularExpression;
        this.file = file;
    }

    public String getPattern() {
        return pattern;
    }

    public boolean isRegularExpression() {
        return regularExpression;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ReplaceData{");
        sb.append("pattern='").append(pattern).append('\'');
        sb.append(", regularExpression=").append(regularExpression);
        sb.append(", path='").append(file.getAbsoluteFile()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
