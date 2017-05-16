package interceptor;

import com.jd.digital.common.util.tool.MD5Util;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

/**
 * **************************************************
 *
 * @author sunbingwei@360buy.com
 *         date: Feb 23, 2011
 *         <p/>
 *         ***************************************************
 */
public class AuthHeader {
    private String token;
    private String content;
    private String seed;

    public AuthHeader() {
    }

    private String getTokenValue() {
        if (StringUtils.isNotBlank(token)) return token;

        if (StringUtils.isNotEmpty(content) &&
                StringUtils.isNotEmpty(seed)) {
            byte[] bb = MD5Util.md5(content + "-" + seed);
            return new String(Base64.encodeBase64(bb));
        }
        return "";
    }

    public boolean checkTokenValue(String clientToken) {
        if (StringUtils.isEmpty(clientToken)) {
            return false;
        }
        String tmp = getTokenValue();

        return !StringUtils.isEmpty(tmp) && tmp.equals(clientToken);
    }


    public void setContent(String content) {
        this.content = content;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
