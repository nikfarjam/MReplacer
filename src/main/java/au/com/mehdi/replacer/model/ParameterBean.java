package au.com.mehdi.replacer.model;

import java.util.Objects;

/**
 * Created by mehdi on 6/5/16.
 */
public class ParameterBean {

    private String parameter;
    private String value;

    public ParameterBean(String parameter, String value) {
        this.parameter = parameter;
        this.value = value;
    }

    public ParameterBean() {
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParameterBean)) return false;
        ParameterBean that = (ParameterBean) o;
        return Objects.equals(parameter, that.parameter) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameter, value);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ParameterBean{");
        sb.append("parameter='").append(parameter).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
